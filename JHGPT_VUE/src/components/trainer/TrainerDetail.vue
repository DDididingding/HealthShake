<template>
  <div class="trainer-detail">
    <h1>트레이너 상세페이지</h1>

    <div v-if="isTrainerLoaded && trainer" class="trainer-info">
      <div class="profile">
        <div class="profile-section">
          <h2>프로필</h2>
          <p><strong>이름:</strong> {{ trainer.name }}</p>
          <p><strong>닉네임:</strong> {{ trainer.nickname }}</p>
          <p><strong>소개:</strong> {{ trainer.readme }}</p>
        </div>

        <hr>

        <div v-if="isVideoLoaded && videos" class="videos">
          <h2>비디오</h2>
          <VideoList :memberCode="route.params.member_code" />
        </div>

        <hr>

        <div v-if="isBoardLoaded && boards" class="boards">
          <h2>게시판</h2>
          <BoardList :memberCode="route.params.member_code" />
        </div>

        <hr>

        <div v-if="isReviewLoaded && reviews" class="reviews">
          <h2>리뷰 리스트</h2>
          <ReviewList :memberCode="route.params.member_code" />
        </div>

        <hr>   
      </div>
    </div>

    <div v-else>
      데이터 로딩 중...
    </div>
  </div>
</template>

<script setup>
import { useMemberStore } from "@/stores/memberStore";
import { useVideoStore } from "@/stores/videoStore";
import { useBoardStore } from "@/stores/boardStore";
import { useReviewStore } from "@/stores/reviewStore";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import ReviewList from "@/components/review/ReviewList.vue";
import BoardList from "@/components/board/BoardList.vue";
import VideoList from "@/components/video/VideoList.vue";

const memberStore = useMemberStore();
const videoStore = useVideoStore();
const boardStore = useBoardStore();
const reviewStore = useReviewStore();
const route = useRoute();
const trainer = ref(null);
const isTrainerLoaded = ref(false);
const isVideoLoaded = ref(false);
const isReviewLoaded = ref(false);
const isBoardLoaded = ref(false);
const reviews = ref([null]);
const boards = ref([null]);
const videos = ref([null]);

onMounted(async () => {
  try {
    const member_code = route.params.member_code;
    await memberStore.selectTrainer(member_code);
    trainer.value = memberStore.trainer;
    isTrainerLoaded.value = true;

    await videoStore.VideoListByTrainer(member_code);
    videos.value = videoStore.videoList;
    isVideoLoaded.value = true;

    await boardStore.BoardListByMember(member_code);
    boards.value = boardStore.boards;
    isBoardLoaded.value = true;

    await reviewStore.ReviewListByTrainer(member_code);
    reviews.value = reviewStore.reviewList;
    isReviewLoaded.value = true;


  } catch (error) {
    console.error("트레이너 정보를 불러오는 동안 오류가 발생했습니다:", error);
  }
});

//각각 리스트에 데이터 담기는지 확인
</script>

<style scoped>
/* 추가적인 스타일링을 위한 CSS 코드 */
.trainer-detail {
  padding: 20px;
  font-family: Arial, sans-serif;
}

.trainer-info {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.profile {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 8px;
}

.profile-section {
  margin-bottom: 20px;
}

h2 {
  font-size: 1.2em;
  margin-bottom: 10px;
}

hr {
  border: none;
  border-top: 1px solid #ddd;
  margin: 20px 0;
}
</style>
