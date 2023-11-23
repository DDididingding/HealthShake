<template>
  <div class="trainer-mypage">
    <div class="container w-screen">
      <div class="container-header my-12">
        <h2 class="font-bold text-3xl mb-3">마이 페이지에요.</h2>
        <p class="text-slate-600">
          업로드한 비디오, 게시판, 리뷰를 확인할 수 있어요
        </p>
      </div>
    </div>

    <div v-if="isTrainerLoaded && trainer" class="trainer-info">
      <div class="section profile w-screen">
        <div class="profile-section flex flex-row">
          <div class="flex flex-row gap-12 items-center">
            <img
              :src="trainer.profileImagePath"
              class="user-profile-image"
              style="width: 300px; height: auto"
            />
            <div class="flex flex-col gap-2">
              <div class="flex flex-row gap-y-4">
                <div class="w-40 text-slate-400">이름</div>
                <div class="flex-1 font-medium">{{ trainer.name }}</div>
              </div>
              <div class="flex flex-row gap-y-4">
                <div class="w-40 text-slate-400">닉네임</div>
                <div class="flex-1 font-medium">{{ trainer.nickname }}</div>
              </div>
              <div class="flex flex-row">
                <div class="w-40 text-slate-400">소개</div>
                <div class="flex-1 font-medium">{{ trainer.readme }}</div>
              </div>
              <button
                @click="goToTrainerMypageUpdate"
                class="bg-gradient-to-r from-rose-400 via-fuchsia-500 to-indigo-500 w-30 p-3 rounded-xl text-white font-bold mt-4"
              >
                수정
              </button>
            </div>
            <!-- 수정 버튼 -->
          </div>
          <hr />
        </div>

        <!-- 비디오 리스트 -->
        <h2 class="font-bold text-xl mb-3 ml-3">비디오</h2>
        <div v-if="isVideoLoaded && videos != null" class="section video">
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
                    <a
                      :href="video.url"
                      target="_blank"
                      rel="noopener noreferrer"
                      >{{ video.url }}</a
                    >
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <router-link
          :to="{
            name: 'VideoRegist',
            params: { member_code: route.params.member_code },
          }"
        >
          <!--params: { member_code: route.params.member_code }-->
          <button class="btn btn-primary">비디오 추가 등록</button>
        </router-link>

        <hr />

        <!-- 내가 작성한 글-->
        <h2 class="font-bold text-xl mb-3 ml-3">내가 작성한 게시물</h2>
        <div v-if="isBoardLoaded && boards != null" class="section board">
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
                  <td>{{ board.content }}</td>
                  <!-- <router-link :to="{ name: 'UpdateBoard', params: { board_code: board.code } }">
                    <button class="btn btn-primary">수정</button>
                  </router-link> -->
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div>
          <router-link
            :to="{
              name: 'BoardRegist',
              params: { member_code: route.params.member_code },
            }"
          >
            <button class="btn btn-primary">게시물 등록</button>
          </router-link>
        </div>

        <hr />
        <!-- 리뷰 리스트 -->
        <div v-if="isReviewLoaded && reviews != null" class="section review">
          <h2 class="font-bold text-xl mb-3 ml-3">나에게 작성된 리뷰</h2>
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
const sessionMember = JSON.parse(sessionStorage.getItem("loginMember"));
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
  console.log("memberCode: ", memberCode);
  if (memberCode) {
    router.push({
      name: "trainerMypageUpdate",
      params: { member_code: memberCode },
    });
  } else {
    // Handle the case where member_code is not available
    console.error("Member code not available");
  }
};
</script>

<style scoped>
.video-card,
.board-card,
.review-card {
  border: 1px solid #ddd; /* Add border to each section */
  border-radius: 8px; /* Optional: Add border-radius for a rounded appearance */
  padding: 20px; /* Add padding for spacing */
  margin-bottom: 20px; /* Add margin for separation between sections */
}

.video-card table,
.board-card table,
.review-card table {
  width: 100%; /* Ensure tables take full width inside their parent div */
  border-collapse: collapse; /* Collapse table borders for a cleaner look */
}

.video-card th,
.board-card th,
.review-card th {
  background-color: peachpuff; /* Header background color */
  padding: 10px; /* Padding for table headers */
}

.video-card td,
.board-card td,
.review-card td {
  padding: 10px; /* Padding for table cells */
}

.trainer-detail {
  padding: 20px;
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

hr {
  border: none;
  border-top: 1px solid #ddd;
  margin: 20px 0;
}

.btn {
  padding: 8px 16px;
  font-size: 14px;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.btn-primary {
  background-color: lightsalmon;
  color: #fff;
  border: none;
}

.btn-primary:hover {
  background-color: salmon;
}

.profile {
  background-color: #f9f9f9;
}

.video {
  background-color: #e8f4f8;
}

.board {
  background-color: lavenderblush;
}

.review {
  background-color: oldlace;
}
/* 추가적인 스타일링이 필요한 경우 여기에 추가하세요 */
</style>
