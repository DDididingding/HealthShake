<template>
    <div>
      <h4>리뷰 수정</h4>
      <fieldset>
        <legend>수정</legend>
        <div>
          <label for="title">제목 :</label>
          <input type="text" id="title" v-model="review.title">
        </div>
        <div>
          <label for="content">내용 :</label>
          <textarea id="content" cols="30" rows="10" v-model="review.content"></textarea>
        </div>
        <div>
          <label for="rating">평점 :</label>
          <input type="number" id="rating" v-model="review.rating" min="1" max="5">
        </div>
        <div>
          <button @click="updateReview">수정</button>
        </div>
      </fieldset>
    </div>
  </template>
  
  
  <script setup>
  import { ref } from 'vue';
  import { useReviewStore } from "@/stores/reviewStore";
  
  const reviewStore = useReviewStore();
  const review = ref({
    title: '',
    content: '',
    rating: 1 // 기본값 설정
  });
  
  const updateReview = () => {
    if (
      review.value.title === "" ||
      review.value.content === "" ||
      review.value.rating < 1 || review.value.rating > 5
    ) {
      alert("모든 내용을 입력하고 유효한 평점을 입력해주세요 (1부터 5까지)");
      return;
    }
  
    reviewStore.updateReview(review.value);
  };
  </script>