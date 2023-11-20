<template>
  <div class="trainer-mypage">
    <h1>트레이너 마이페이지</h1>

    <div v-if="isTrainerLoaded && trainer" class="trainer-info">
      <div class="profile">
        <div class="profile-section">
          <h2>프로필</h2>
          <div class="profile-details">
            <p><strong>이름:</strong> {{ trainer.name }}</p>
            <p><strong>닉네임:</strong> {{ trainer.nickname }}</p>
            <p><strong>소개:</strong> {{ trainer.readme }}</p>
            <!-- 서비스 관련 추가 -->
          </div>
          <!-- 수정 버튼 -->
          <div class="edit-button">
            <button @click="goToTrainerMypageUpdate">수정</button>
          </div>
        </div>
        <hr />

        <!-- 비디오 리스트 -->
        <div class="videos">
          <h2>비디오</h2>
          <VideoList
            :memberCode="route.params.member_code"
            v-if="isVideoLoaded"
          />
          <p v-else>비디오를 로딩 중입니다...</p>
        </div>

        <!-- 내가 작성한 글-->
        <div class="boards">
          <h2>내가 작성한 게시물</h2>
          <VideoList
            :memberCode="route.params.member_code"
            v-if="isBoardLoaded"
          />
          <p v-else>게시물을 로딩 중입니다...</p>
        </div>
        <!-- 추후 구현 -->
      </div>
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
import VideoList from "@/components/video/VideoList.vue";
import { useUserStore } from "@/stores/userStore";
import router from "@/router";

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
const videoList = ref([null]);
const reviews = ref([null]);
const boards = ref([null]);
const sessionMember = JSON.parse(sessionStorage.getItem('loginMember'));

onMounted(async () => {
  try {
    const member_code = route.params.member_code;
    await memberStore.selectTrainer(member_code);
    trainer.value = memberStore.trainer;
    isTrainerLoaded.value = true;

    await videoStore.VideoListByTrainer(member_code);
    videoList.value = videoStore.videoList;
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

// const goToTrainerMypageUpdate = () => {
//   const memberCode = userStore.loginMember ? userStore.loginMember.member_code : null;
//   console.log("memberCode: ", memberCode);
//   if (memberCode) {
//     router.push({ name: "trainerMypageUpdate", params: { member_code: memberCode } });
//   } else {
//     // Handle the case where member_code is not available
//     console.error("Member code not available");
//   }
// };
const goToTrainerMypageUpdate = () => {
  const memberCode = sessionMember ? sessionMember.member_code : null;
  console.log('memberCode: ', memberCode);
  if (memberCode) {
    //트레이너 마이페이지에, 인자로 membercode를 담아서 보냄
    router.push({ name: 'trainerMypageUpdate', params: { member_code: memberCode } });
  } else {
    // Handle the case where member_code is not available
    console.error('Member code not available');
  }
};

</script>

<style scoped>
.trainer-mypage {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  font-family: "Arial", sans-serif;
}

.trainer-info {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  margin-top: 20px;
}

.profile {
  margin-bottom: 30px;
}

.profile-section {
  margin-bottom: 20px;
}

.profile-details {
  border-bottom: 1px solid #ccc;
  padding-bottom: 15px;
}

.profile-details p {
  margin: 8px 0;
}

.edit-button button {
  padding: 8px 16px;
  background-color: #3498db;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.videos {
  margin-top: 30px;
}

.videos h2 {
  margin-bottom: 15px;
  font-size: 1.2em;
}

/* 추가적인 스타일링이 필요한 경우 여기에 추가하세요 */
</style>
