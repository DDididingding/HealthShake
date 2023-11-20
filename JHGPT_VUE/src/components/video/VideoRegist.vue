<template>
<!--1118구현 완, 근데 테스트는 안해봄-->
  <div>
    <h1>비디오 등록 페이지</h1>

    <form @submit.prevent="registerVideo">
      <div class="form-group">
        <label for="videoTitle">비디오 제목:</label>
        <input type="text" id="videoTitle" v-model="newVideo.video_title" required>
      </div>
      <div class="form-group">
        <label for="videoURL">비디오 URL:</label>
        <input type="text" id="videoURL" v-model="newVideo.video_url" required>
      </div>
      <div class="form-group">
        <label for="videoPrice">가격:</label>
        <input type="number" id="videoPrice" v-model.number="newVideo.price" required>
      </div>
      <div class="form-group">
        <label for="videoViewCnt">조회수:</label>
        <input type="number" id="videoViewCnt" v-model.number="newVideo.view_cnt" required>
      </div>
      <button @click="createVideo">등록</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useVideoStore } from "@/stores/videoStore";

const videoStore = useVideoStore();

// 비디오 등록 함수
// const registerVideo = () => {
//   // 새 비디오를 서버에 등록하는 로직 작성
//   console.log('새 비디오 등록:', newVideo.value);

//   // 등록 후에 폼 초기화
//   newVideo.value = {
//     video_title: '',
//     video_url: '',
//     price: 0,
//     view_cnt: 0,
//   };
// };

const registVideo = () => {
  const newVideo = ref({
  video_title: '',
  video_url: '',
  price: 0,
  view_cnt: 0,
  });

  //유효성 검사 추가하면 좋긴 하겠다..

  if (
    video_title.value === "" ||
    video_url.value === "" ||
    price.value === "" ||
    view_cnt.value === ""
  ) {
    alert("모든 내용을 입력해주세요");
    return;
  }
  emit("create-video", video);
  redirectToTrainerdetail();
  videoStore.registVideo(newVideo);


}

const redirectToTrainerdetail = () => {
  // 회원가입 성공 후 홈 페이지로 이동
  router.push('trainerDetail'); 
};

</script>

<style scoped>
/* 필요한 스타일링 추가 */
.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  font-weight: bold;
}

input[type="text"],
input[type="number"] {
  width: 100%;
  padding: 8px;
  border-radius: 5px;
  border: 1px solid #ccc;
}
</style>
