<template>
  <div class="container">
    <h2>리뷰 등록</h2>
    <fieldset class="text-center">
       <label for="title">리뷰 제목</label>
      <input type="text" id="title" v-model="name" class="view" /><br />
      <label for="content">내용</label>
      <input type="text" id="content" v-model="content" class="view" /><br />
      <label for="rating">평점</label>
      <input type="number" id="rating" v-model="rating" class="view" /><br />
      <button class="btn" @click="regist">등록</button>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const router = useRouter();
const emit = defineEmits(["create-user"]);

const title = ref("");
const content = ref("");
const rating = ref(0);

const getReviewList = () => {
  const API_URL = `http://localhost:9999/userapi/user`; //수정필요
  axios({
    url: API_URL,
    method: "GET",
  })
    .then((res) => {
      users.value = Array.isArray(res.data) ? res.data : [];
    })
    .catch((err) => {
      console.log(err);
    });
};

getReviewList();
</script>
