<template>
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

// 새 비디오를 추가하기 위한 객체
const newVideo = ref({
  video_title: '',
  video_url: '',
  price: 0,
  view_cnt: 0,
});

// 비디오 등록 함수
const registerVideo = () => {
  // 새 비디오를 서버에 등록하는 로직 작성
  console.log('새 비디오 등록:', newVideo.value);

  // 등록 후에 폼 초기화
  newVideo.value = {
    video_title: '',
    video_url: '',
    price: 0,
    view_cnt: 0,
  };
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
