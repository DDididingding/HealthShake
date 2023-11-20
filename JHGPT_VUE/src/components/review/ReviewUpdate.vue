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
  import { ref, onMounted } from 'vue';
  import { useReviewStore } from "@/stores/reviewStore";
  
  const reviewStore = useReviewStore();
  const review = ref({});
  const isReviewLoaded = ref(false);

  onMounted(async () => {
    try{
      const review_code = route.params.review_code;
      await reviewStore.selectReview(review_code);
      review.value = { ...reviewStore.review};
      isReviewLoaded.value = true;
    }
    catch(error) {
      console.error("리뷰 정보를 불러오는 동안 오류가 발생했습니다:", error);
    }
  })
  
  const updateReview = () => {
    review.value = {
      title: review.value.title,
      content: review.value.content,
      rating : review.value.rating,
    };
  
    reviewStore.updateReview(review.value);
  };
  </script>