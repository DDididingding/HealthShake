<template>
  <div class="review-registration">
    <h1>리뷰 등록 페이지</h1>

    <form @submit.prevent="submitReview" class="registration-form">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" id="title" v-model="review.title" class="form-control" required>
      </div>

      <div class="form-group">
        <label for="content">내용</label>
        <textarea id="content" v-model="review.content" class="form-control" required></textarea>
      </div>

      <div class="form-group">
        <label for="rating">평점 (1~5점)</label>
        <input type="number" id="rating" v-model="review.rating" min="1" max="5" class="form-control" required>
      </div>

      <button type="submit" class="btn btn-primary">등록</button>
    </form>
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

const submitReview = () => {
  if (
    review.value.title === "" ||
    review.value.content === "" ||
    review.value.rating < 1 || review.value.rating > 5
  ) {
    alert("모든 내용을 입력하고 유효한 평점을 입력해주세요 (1부터 5까지)");
    return;
  }

  reviewStore.registReview(review.value);
};
</script>

<style scoped>
/* 기존 스타일에 추가된 부분 */
.review-registration {
  max-width: 600px;
  margin: auto;
  text-align: center;
}

.registration-form {
  display: flex;
  flex-direction: column;
  gap: 20px;
  margin-top: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  font-weight: bold;
}

input[type="text"],
textarea,
input[type="number"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  background-color: mediumaquamarine;
  color: #fff;
  cursor: pointer;
}

button:hover {
  background-color: #3498db;
}
</style>
