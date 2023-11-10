<template>
    <div class="container">
        <h2>영상 정보</h2>
        <fieldset class="text-center">
            <label for="video_id">영상 번호</label>
            <input type="number" id="video_id" v-model="video.video_id" class="view"/><br />
            <label for="video_title">제목</label>
            <input type="text" id="video_title" v-model="video.video_title" class="view" /><br />
            <label for="content">내용</label>
            <input type="text" id="content" v-model="video.content" class="view" /><br />
            <label for="video_url">url</label>
            <input type="url" id="video_url" v-model="video.video_url" class="view" /><br />
            <label for="part">부위</label>
            <input type="text" id="part" v-model="video.part" class="view" /><br />
            <label for="view_cnt">조회수</label>
            <input type="number" id="view_cnt" v-model="video.view_cnt" class="view" /><br />
            <button class="btn" @click="updateVideo">수정</button>
            <button class="btn" @click="deleteVideo">삭제</button>
            <button class="btn" @click="registReview">리뷰 등록</button>
        </fieldset>
        <h2>해당 영상의 리뷰</h2>
        <fieldset class="text-center">
            <label for="review_id">리뷰 번호</label>
            <input type="number" id="review_id" v-model="review.review_id" class="view"/><br />
            <label for="title">제목</label>
            <input type="text" id="title" v-model="review.title" class="view" /><br />
            <label for="content">내용</label>
            <input type="text" id="content" v-model="review.content" class="view" /><br />
            <label for="rating">평점</label>
            <input type="number" id="rating" v-model="review.rating" class="view" /><br />
            <button class="btn" @click="updateReview">수정</button>
            <button class="btn" @click="deleteReview">삭제</button>
        </fieldset>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";

const emit = defineEmits();

const video = ref({
  video_id: 0,
  video_title: "",
  content: "",
  video_url: "",
  age: 0,
});

const review = ref({
    review_id: 0,
    title:"",
    content: "",
    rating: 0,
});

const updateVideo = () => {
  emit("update-video", video.value);
};

const deleteVideo = () => {
  emit("delete-video", video.value);
};

const registReview = () => {
  emit("regist-review", review.value);
};

const updateReview = () => {
  emit("update-review", review.value);
};

const deleteReview = () => {
  emit("delete-review", review.value);
};

onMounted(() => {
  const pathName = new URL(document.location).pathname.split("/");
  const id = pathName[pathName.length - 1];
  const API_URL = `http://localhost:9999/userapi/user/${id}`; //수정 필요
  axios({
    url: API_URL,
    method: "GET",
  })
    .then((res) => {
      video.value.video_id = res.data.video_id;
      video.value.video_title = res.data.video_title;
      video.value.content = res.data.content;
      video.value.video_url = res.data.video_url;
      video.value.part = res.data.part;
      video.value.view_cnt = res.dataview_cntt;
    })
    .catch((err) => {
      console.log(err);
    });
});
</script>
