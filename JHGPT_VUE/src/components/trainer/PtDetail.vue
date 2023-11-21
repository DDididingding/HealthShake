<template>
  <div>
    <h1>피티 상세 페이지</h1>
    <!--트레이너 본인이 보는 피티 상세 페이지, 수정 기능 넣기--> 

    <div v-if="isTrainerLoaded && trainer!= null" class="trainer-info">
      <div class="profile">
        <div class="profile-section">
          <h2>프로필</h2>
          <p><strong>이름:</strong> {{ trainer.name }}</p>
          <p><strong>닉네임:</strong> {{ trainer.nickname }}</p>
          <p><strong>소개:</strong> {{ trainer.readme }}</p>
        </div>
        <div class="edit-button">
            <button @click="goToTrainerMypageUpdate">수정</button>
          </div>

        <hr>

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
            </table>
          </div>        
        </div>

        <router-link :to="{ name: 'VideoRegist', params: { member_code: route.params.member_code } }">
        <button class="btn btn-primary">비디오 추가 등록</button>
      </router-link>

        <hr>

        <div v-if="isBoardLoaded && boards != null" class="boards">
          <h2>게시판</h2>
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
                  <!-- <router-link :to="{ name: 'BoardUpdate', params: { board_code: board.code } }">
                    <button class="btn btn-primary">수정</button>
                  </router-link> -->
                </tr>
              </tbody>
            </table>
         </div>
        </div>

        <hr>

        <div v-if="isReviewLoaded && reviews != null" class="reviews">
          <h2>리뷰 리스트</h2>
          <div class="review-card">
          <table class="review-list">
            <colgroup>
              <col style="width: 5%" />
              <col style="width: 10%" />
              <col style="width: 70%" />
              <col style="width: 15%" />
            </colgroup>
            <thead>
              <tr>
                <th>번호</th>
                <th>작성자 아이디</th>
                <th>내용</th>
                <th>별점</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="review in reviews" :key="review.code">
                <td>{{ review.code }}</td>
                <td>{{ review.writercode }}</td>
                <td>{{ review.content }}</td>
                <td>{{ review.rating }}</td>
              </tr>
            </tbody>
          </table>
          </div>
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
import { computed } from "vue";
import { useRouter } from "vue-router";
import router from "@/router";

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
const trainer = computed(() => memberStore.trainer);
const reviews = computed(() => reviewStore.reviewList);
const boards = computed(() => boardStore.boardList);
const videos = computed(() => videoStore.videoList);

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