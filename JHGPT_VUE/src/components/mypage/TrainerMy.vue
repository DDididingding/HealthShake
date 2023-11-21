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
        <div v-if="isVideoLoaded && videos != null" class="videos">
          <h2>비디오</h2>
          <div class="video-card">
            <table class="video-list">
              <colgroup>
                <col style="width: 20%" />
                <col style="width: 40%" />
                <col style="width: 10%" />
                <col style="width: 30%" />
              </colgroup>
              <thead>
                <tr>
                  <th>Category</th>
                  <th>소개글</th>
                  <th>조회수</th>
                  <th>URL</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="video in videos" :key="video.code">
                  <td>{{ video.title }}</td>
                  <td>{{ video.readme }}</td>
                  <td>{{ video.viewcnt }}</td>
                  <td>
                    <a :href="video.url" target="_blank" rel="noopener noreferrer">{{ video.url }}</a>
                  </td>
                </tr>
              </tbody>
                <router-link :to="{ name: 'VideoRegist' }">
          <!--params: { member_code: route.params.member_code }-->
        <button class="btn btn-primary">비디오 추가 등록</button>
        </router-link>
            </table>
          </div>
        </div>

        <hr>

        <!-- 내가 작성한 글-->
        <div v-if="isBoardLoaded && boards != null" class="boards">
          <h2>내가 작성한 게시물</h2>
          <div class="board-card">
            <table class="board-list">
              <colgroup>
                <col style="width: 10%" />
                <col style="width: 25%" />
                <col style="width: 35%" />
                <col style="width: 30%" />
              </colgroup>
              <thead>
                <tr>
                  <th>번호</th>
                  <th>작성자</th>
                  <th>카테고리</th>
                  <th>내용</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="board in boards" :key="board.code">
                  <td>{{ board.code }}</td>
                  <td>{{ board.writercode }}</td>
                  <td>{{ board.title }}</td>
                  <td>{{ board.content}}</td>
                   <!-- <router-link :to="{ name: 'UpdateBoard', params: { board_code: board.code } }">
                    <button class="btn btn-primary">수정</button>
                  </router-link> -->
                </tr>
              </tbody>
            </table>
         </div>
        </div>
        
        <hr>
        <!-- 리뷰 리스트 -->
        <div v-if="isReviewLoaded && reviews != null" class="reviews">
          <h2>나에게 작성된 리뷰</h2>
          <div class="review-card">
          <table class="review-list">
            <colgroup>
              <col style="width: 15%" />
              <col style="width: 15%" />
              <col style="width: 55%" />
              <col style="width: 15%" />
            </colgroup>
            <thead>
              <tr>
                <th>번호</th>
                <th>작성자</th>
                <th>내용</th>
                <th>별점</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="review in reviews" :key="review.code">
                <td>{{ review.code }}</td>
                <td>{{ review.writer }}</td>
                <td>{{ review.content }}</td>
                <td>{{ review.rating }}</td>
              </tr>
            </tbody>
          </table>
          </div>
      </div>
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
import ReviewList from "@/components/review/ReviewList.vue";
import BoardList from "@/components/board/BoardList.vue";
import { useUserStore } from "@/stores/userStore";
import router from "@/router";
import { computed } from "vue";

const memberStore = useMemberStore();
const videoStore = useVideoStore();
const boardStore = useBoardStore();
const reviewStore = useReviewStore();
const route = useRoute();
const isTrainerLoaded = ref(false);
const isVideoLoaded = ref(false);
const isReviewLoaded = ref(false);
const isBoardLoaded = ref(false);
const sessionMember = JSON.parse(sessionStorage.getItem('loginMember'));
const videos = computed(() => videoStore.videoList);
const reviews = computed(() => reviewStore.reviewList);
const boards = computed(() => boardStore.boardList);
const trainer = computed(() => memberStore.trainer);


onMounted(async () => {
  try {
    const member_code = route.params.member_code;
    await memberStore.selectTrainerPromise(member_code);

    await videoStore.VideoListByTrainer(member_code);

    await boardStore.BoardListByMemberPromise(member_code);

    await reviewStore.ReviewListByTrainer(member_code);

    isTrainerLoaded.value = trainer.value !== null;
    isVideoLoaded.value = videos.value !== null;
    isReviewLoaded.value = reviews.value !== null;
    isBoardLoaded.value = boards.value !== null;

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
