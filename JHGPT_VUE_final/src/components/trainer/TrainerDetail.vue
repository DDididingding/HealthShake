<template>
  <div class="trainer-detail">
    <div class="container w-screen">
      <div class="container-header my-12">
        <h2 class="font-bold text-3xl mb-3">트레이너의 상세페이지에요.</h2>
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
              <div v-if="isLoggedin && userType === 1" class="mt-8">
                <div v-if="tf">
                  <button class="btn btn-primary-grey" @click="cancelBuy">
                    구독중
                  </button>
                </div>
                <div v-else>
                  <button
                    class="bg-gradient-to-r from-rose-400 via-fuchsia-500 to-indigo-500 w-30 p-3 rounded-xl text-white font-bold mt-4"
                    @click="buy"
                  >
                    구독하기
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div></div>
        </div>

        <hr />

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

        <hr />

        <h2 class="font-bold text-xl mb-3 ml-3">트레이너 게시판</h2>
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
                <tr v-for="b in boards" :key="b.code">
                  <td>{{ b.code }}</td>
                  <td>{{ b.writercode }}</td>
                  <td>{{ b.title }}</td>
                  <td>{{ b.content }}</td>
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

        <h2 class="font-bold text-xl mb-3 ml-3">트레이너 리뷰</h2>
        <div v-if="isReviewLoaded && reviews != null" class="section review">
          <div class="review-card">
            <table class="review-list">
              <colgroup>
                <col style="width: 10%" />
                <col style="width: 10%" />
                <col style="width: 55%" />
                <col style="width: 15%" />
                <col style="width: 5%" />
                <col style="width: 5%" />
              </colgroup>
              <thead>
                <tr>
                  <th>번호</th>
                  <th>작성자</th>
                  <th>내용</th>
                  <th>별점</th>
                  <th>좋아</th>
                  <th>싫어</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="review in reviews" :key="review.code">
                  <td>{{ review.code }}</td>
                  <td>{{ review.writer }}</td>
                  <td>{{ review.content }}</td>
                  <td>{{ review.rating }}</td>
                  <td @click="like(review.code)">{{ review.like }}</td>
                  <td @click="dislike(review.code)">{{ review.dislike }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div v-if="isLoggedin && userType === 1">
          <router-link
            :to="{
              name: 'ReviewRegist',
              params: { member_code: route.params.member_code },
            }"
          >
            <button class="btn btn-primary">리뷰 등록</button>
          </router-link>
        </div>
      </div>
    </div>

    <div v-else>데이터 로딩 중...</div>
  </div>
</template>

<script setup>
import { useMemberStore } from "@/stores/memberStore";
import { useVideoStore } from "@/stores/videoStore";
import { useBoardStore } from "@/stores/boardStore";
import { useUserStore } from "@/stores/userStore";
import { useReviewStore } from "@/stores/reviewStore";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import { computed } from "vue";

const userStore = useUserStore();
const memberStore = useMemberStore();
const videoStore = useVideoStore();
const boardStore = useBoardStore();
const reviewStore = useReviewStore();
const route = useRoute();
const trainer = computed(() => memberStore.trainer);
const isTrainerLoaded = computed(() => trainer.value !== null);
const isVideoLoaded = computed(() => videoStore.videoList.length > 0);
const isReviewLoaded = computed(() => reviewStore.reviewList.length > 0);
const isBoardLoaded = computed(() => boardStore.boardList.length > 0);
const reviews = computed(() => reviewStore.reviewList);
const boards = computed(() => boardStore.boardList);
const videos = computed(() => videoStore.videoList);
const loginMember = computed(() => userStore.loginMember);

const tf = ref(false);

const isLoggedin = computed(() => {
  console.log(userStore.loginMember);
  return userStore.loginMember !== null;
});

// const alreadyBuy = false;

const alreadyBuy = () => {
  //리스트 안에 현재 트레이너가 있는지 검사
  const user_code = loginMember.value.member_code;
  const trainer_code = parseInt(route.params.member_code);

  memberStore.isAlreadyBuy(user_code, trainer_code).then((res) => {
    tf.value = res;
  });
};

// userType을 computed 속성으로 정의합니다.
const userType = computed(() => {
  return loginMember.value ? loginMember.value.member_status : "";
});

const like = (review_code) => {
  reviewStore.likeReview(review_code);
};
const dislike = (review_code) => {
  reviewStore.dislikeReview(review_code);
};

const buy = () => {
  const user_code = loginMember.value.member_code;
  const trainer_code = parseInt(route.params.member_code);
  alreadyBuy();

  console.log(user_code, trainer_code);
  memberStore.buyTrainer(user_code, trainer_code);
};

const cancelBuy = () => {
  const user_code = loginMember.value.member_code;
  const trainer_code = parseInt(route.params.member_code);
  alreadyBuy();

  console.log(user_code, trainer_code);
  memberStore.deleteTrainer(user_code, trainer_code);
};

onMounted(async () => {
  try {
    const member_code = route.params.member_code;
    await memberStore.selectTrainerPromise(member_code);

    await videoStore.VideoListByTrainer(member_code);

    await boardStore.BoardListByTrainerPromise(member_code);

    await reviewStore.ReviewListByTrainer(member_code);
    alreadyBuy();
  } catch (error) {
    console.error("트레이너 정보를 불러오는 동안 오류가 발생했습니다:", error);
  }
});

//각각 리스트에 데이터 담기는지 확인
</script>

<style scoped>
.profile-section,
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

.btn-primary-grey {
  background-color: grey;
  color: #fff;
  border: none;
}

.btn-primary-grey:hover {
  color: white;
  background-color: rgb(75, 72, 70);
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
</style>
