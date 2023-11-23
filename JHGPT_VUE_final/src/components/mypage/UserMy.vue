<template>
  <div class="container w-screen">
    <div class="user-mypage">
      <div class="container-header my-12">
        <h2 class="font-bold text-3xl mb-3">마이페이지에요.</h2>
        <p class="text-slate-600">
          그동안 쓴 게시물과 리뷰를 확인할 수 있어요.
        </p>
      </div>

      <div v-if="isUserLoaded && user" class="user-info">
        <div class="section profile w-screen">
          <div
            class="trainer-card-container flex flex-wrap gap-x-12 gap-y-8 w-screen"
          >
            <div class="flex flex-row gap-12 items-center">
              <img
                :src="user.profileImagePath"
                class="user-profile-image"
                style="width: 300px; height: auto"
              />
              <div class="flex flex-col gap-2">
                <div class="flex flex-row gap-y-4">
                  <div class="w-40 text-slate-400">이름</div>
                  <div class="flex-1 font-medium">{{ user.name }}</div>
                </div>
                <div class="flex flex-row gap-y-4">
                  <div class="w-40 text-slate-400">나이</div>
                  <div class="flex-1 font-medium">{{ user.age }}</div>
                </div>
                <div class="flex flex-row">
                  <div class="w-40 text-slate-400">성별</div>
                  <div class="flex-1 font-medium">{{ user.gender }}</div>
                </div>
                <div class="flex flex-row">
                  <div class="w-40 text-slate-400">운동 관심사</div>
                  <div class="flex-1 font-medium">{{ user.preferPart }}</div>
                </div>
                <div class="flex flex-row">
                  <div class="w-40 text-slate-400">선호하는 트레이너 성별</div>
                  <div class="flex-1 font-medium">{{ user.preferGender }}</div>
                </div>
                <div>
                  <button
                    @click="goToUserMypageUpdate"
                    class="w-full bg-gradient-to-r from-rose-400 via-fuchsia-500 to-indigo-500 w-30 p-3 rounded-xl text-white font-bold mt-4"
                  >
                    수정
                  </button>
                </div>
              </div>
            </div>
          </div>
          <hr />
          <!-- 구매한 비디오 리스트 뜨게 할까..? -->

          <!-- 내가 작성한 글목록, 수정, 삭제 -->
          <h2 class="font-bold text-xl mb-3 ml-3">내가 작성한 게시글이에요</h2>
          <div v-if="isBoardLoaded && boards != null" class="section board">
            <div class="board-card">
              <table class="board-list">
                <colgroup>
                  <col style="width: 10%" />
                  <col style="width: 10%" />
                  <col style="width: 20%" />
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
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <!--각 게시물에 할당되도록 수정 필요-->

          <hr />
          <h2 class="font-bold text-xl my-3 ml-3">내가 작성한 리뷰에요</h2>
          <div v-if="isReviewLoaded && reviews != null" class="section review">
            <div class="review-card">
              <table class="review-list">
                <colgroup>
                  <col style="width: 10%" />
                  <col style="width: 10%" />
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
                    <div class="edit-button">
                      <button
                        @click="goToUpdateReview(review.code)"
                        class="btn btn-secondary"
                      >
                        수정
                      </button>
                    </div>
                  </tr>
                </tbody>
              </table>
            </div>
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
import { computed } from "vue";
import { useRouter } from "vue-router";
import router from "@/router";

const memberStore = useMemberStore();
const boardStore = useBoardStore();
const reviewStore = useReviewStore();
const route = useRoute();
const user = computed(() => memberStore.user);
const isUserLoaded = computed(() => user.value !== null);
const isBoardLoaded = computed(() => boardStore.boardList.length > 0);
const isReviewLoaded = computed(() => reviewStore.reviewList.length > 0);
const boards = computed(() => boardStore.boardList);
const reviews = computed(() => reviewStore.reviewList);

const sessionMember = JSON.parse(sessionStorage.getItem("loginMember"));
const boardCode = computed(() => boards.board_code);

onMounted(() => {
  try {
    const member_code = route.params.member_code;
    //셋 다 프로미스로 됨
    memberStore.selectUserPromise(member_code);

    boardStore.BoardListByMemberPromise(member_code);

    reviewStore.ReviewListByWriter(member_code);

    // isUserLoaded.value = computed(() => user.value !== null);
    // isVideoLoaded.value = computed(() => videos.value !== null);
    // isBoardLoaded.value = computed(() => boards.length > 0);
    // isReviewLoaded.value= computed(() => reviews.length > 0);
  } catch (error) {
    console.error("유저 정보를 불러오는 동안 오류가 발생했습니다:", error);
  }
});

const goToUserMypageUpdate = () => {
  const memberCode = sessionMember ? sessionMember.member_code : null;
  console.log("memberCode: ", memberCode);
  if (memberCode) {
    router.push({
      name: "userMypageUpdate",
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

hr {
  border: none;
  border-top: 1px solid #ddd;
  margin: 20px 0;
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
