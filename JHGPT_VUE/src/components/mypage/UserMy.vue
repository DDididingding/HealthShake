<template>
  <div class="user-mypage">
    <h1>유저 마이페이지</h1>
    
    <div v-if="isUserLoaded && user" class="user-info">
      <div class="profile">
        <div class="profile-section">
          <h2>프로필</h2>
          <div class="profile-details">
            <p><strong>나이:</strong> {{ user.age }}</p>
            <p><strong>성별:</strong> {{ user.gender }}</p>
            <p><strong>운동 관심사:</strong> {{ user.workoutInterests }}</p>
            <p><strong>구매한 프로그램:</strong> {{ user.purchasedPrograms }}</p>
          </div>
          <div class="edit-button">
            <button @click="goToUserMypageUpdate">수정</button>
          </div>
        </div>
        <hr>
        <!-- 구매한 비디오 리스트 뜨게 할까..? -->

        <!-- 내가 작성한 글목록, 수정, 삭제 -->
        <div class="boards">
          <h2>내가 작성한 게시물</h2>
          <VideoList :memberCode="route.params.member_code" v-if="isBoardLoaded" />
          <p v-else>게시물을 로딩 중입니다...</p>
        </div>
        <div class="edit-button">
            <button @click="$router.push('/boardUpdate')">수정</button>
        </div>

      </div>
    </div>
  </div>
</template>
  

  <script setup>
  import { useMemberStore } from "@/stores/memberStore";
  import { useVideoStore } from "@/stores/videoStore";
  import { useBoardStore } from "@/stores/boardStore";
  import { ref, onMounted } from "vue";
  import { useRoute } from "vue-router";
  import VideoList from "@/components/video/VideoList.vue";
  import router from "@/router";

  const memberStore = useMemberStore();
  const videoStore = useVideoStore();
  const boardStore = useBoardStore();
  const route = useRoute();
  const user = ref(null);
  const isUserLoaded = ref(false);  
  const isVideoLoaded = ref(false);  
  const isReviewLoaded = ref(false);  
  const isBoardLoaded = ref(false);  
  const boards = ref([null]);
  const sessionMember = JSON.parse(sessionStorage.getItem('loginMember'));

  onMounted(async () => {
    try {
      //유저 관련으로 수정
      const member_code = route.params.member_code;
      await memberStore.selectUser(member_code);
      user.value = memberStore.user;
      isUserLoaded.value = true;
      console.log(isUserLoaded.value);
      console.log(user.value);

      // await videoStore.VideoListBy(member_code);
      // videos.value = videoStore.videoList;
      // isVideoLoaded.value = true;

      await boardStore.BoardListByMember(member_code);
      boards.value = boardStore.boardList;
      isBoardLoaded.value = true;

      // await reviewStore.ReviewListByUser(member_code);
      // reviews.value = reviewStore.reviewList;
      // isReviewLoaded.value = true;

    } catch (error) {
      console.error("유저 정보를 불러오는 동안 오류가 발생했습니다:", error);
    }
  });

  const goToUserMypageUpdate = () => {
    const memberCode = sessionMember ? sessionMember.member_code : null;
    console.log('memberCode: ', memberCode);
    if (memberCode) {
      router.push({ name: 'userMypageUpdate', params: { member_code: memberCode } });
    } else {
      // Handle the case where member_code is not available
      console.error('Member code not available');
    }
  };


  </script>
  
  <style scoped>
.user-mypage {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  font-family: 'Arial', sans-serif;
}

.user-info {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  margin-top: 20px;
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

/* 추가적인 스타일링이 필요한 경우 여기에 추가하세요 */

</style>
  