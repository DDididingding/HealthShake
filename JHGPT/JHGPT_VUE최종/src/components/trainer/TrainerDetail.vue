<template>
  <div class="trainer-detail">
    <div style="display: flex; justify-content: space-between;">
      <h1>트레이너 상세페이지</h1>
      <div v-if="isLoggedin && userType === 1"> 
        <div v-if="tf">
          <button class="btn btn-primary-grey" @click="cancelBuy"> 구독중</button>
        </div>
        <div v-else>
          <button class="btn btn-primary" @click="buy">구독하기</button>
        </div>
        <!-- <div v-else>
        </div> -->
      </div>

    </div>

    <div v-if="isTrainerLoaded && trainer" class="trainer-info">
      <div class="section profile">
        <div class="profile-section">
          <h2>프로필</h2>
<<<<<<< HEAD
          <div class="profile-details" style="display: flex; justify-content: flex-start;" >
            <div class="profile-image">
              <img :src="trainer.profileImagePath" alt="Trainer Profile" class="trainer-profile-image">
            </div>
            <div class="information" style="margin-left: 30px;">
              <p><strong>이름:</strong> {{ trainer.name }}</p>
              <p><strong>닉네임:</strong> {{ trainer.nickname }}</p>
              <p><strong>소개:</strong> {{ trainer.readme }}</p>
            </div>
          </div>
=======
          <p><strong>이름:</strong> {{ trainer.name }}</p>
          <p><strong>닉네임:</strong> {{ trainer.nickname }}</p>
          <p><strong>소개:</strong> {{ trainer.readme }}</p>
>>>>>>> c2bc9f092dce33a30b633406c74b20e4d9159b08
        </div>

        <hr>

        <div v-if="isVideoLoaded && videos != null" class="section video">
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
               
            </table>
          </div>
        </div>

        <hr>

        <div v-if="isBoardLoaded && boards != null" class="section board">
          <h2>트레이너 게시판</h2>
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
                  <td>{{ b.content}}</td>
                   <!-- <router-link :to="{ name: 'UpdateBoard', params: { board_code: board.code } }">
                    <button class="btn btn-primary">수정</button>
                  </router-link> -->
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div>
          <router-link :to="{ name: 'BoardRegist', params: { member_code: route.params.member_code } }">
            <button class="btn btn-primary">게시물 등록</button>
          </router-link>
        </div>

        <hr>

        <div v-if="isReviewLoaded && reviews != null" class="section review">
          <h2>트레이너 리뷰</h2>
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
          <router-link :to="{ name: 'ReviewRegist', params: { member_code: route.params.member_code } }">
            <button class="btn btn-primary">리뷰 등록</button>
          </router-link>
        </div>
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
const isVideoLoaded = computed(() => videoStore.videoList.length>0);
const isReviewLoaded = computed(() => reviewStore.reviewList.length>0);
const isBoardLoaded = computed(() => boardStore.boardList.length>0);
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

  memberStore.isAlreadyBuy(user_code, trainer_code)
  .then((res)=>{
    tf.value = res;
  })
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

.profile-section table,
.video-card table,
.board-card table,
.review-card table {
  width: 100%; /* Ensure tables take full width inside their parent div */
  border-collapse: collapse; /* Collapse table borders for a cleaner look */
}

.profile-section th,
.video-card th,
.board-card th,
.review-card th {
  background-color: peachpuff; /* Header background color */
  padding: 10px; /* Padding for table headers */
}
.profile-section td,
.video-card td,
.board-card td,
.review-card td {
  padding: 10px; /* Padding for table cells */
}

.trainer-detail {
  padding: 20px;
  font-family: Arial, sans-serif;
}

.section {
  padding: 20px;
  border-radius: 8px;
  margin-bottom: 20px;
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
  color : white;
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
