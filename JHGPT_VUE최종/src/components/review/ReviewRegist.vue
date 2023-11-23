<template>
  <div class="review-registration">
    <h1>리뷰 등록 페이지</h1>
    <div class="mb-3">
      <label for="content">내용</label>
      <textarea
        id="content"
        v-model="content"
        class="form-control"
        required
      ></textarea>
    </div>

    <div class="mb-3">
      <label for="rating">평점 (1~5점)</label>
      <input
        type="number"
        id="rating"
        v-model="rating"
        min="1"
        max="5"
        step="1"
        class="form-control"
        required
      />
    </div>

    <button class="btn btn-primary" @click="submitReview">등록</button>
  </div>
</template>

<script setup>
import { useReviewStore } from "@/stores/reviewStore";
import { useUserStore } from "@/stores/userStore";
import { useRoute } from "vue-router";
import { computed } from "vue";
const route = useRoute();
const userStore = useUserStore();
const reviewStore = useReviewStore();

const loginMember = computed(() => userStore.loginMember);
const trainer = parseInt(route.params.member_code);

const submitReview = () => {
  const review = {
    review_content: content.value,
    review_rating: parseInt(rating.value),
    review_writer: loginMember.value.member_code,
    member_code: trainer,
  };
  console.log(review);
  if (content.value === "" || rating.value < 1 || rating.value > 5) {
    alert("모든 내용을 입력하고 유효한 평점을 입력해주세요 (1부터 5까지)");
    return;
  }

  reviewStore.registReview(review);
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
