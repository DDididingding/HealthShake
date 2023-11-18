<template>
  <div class="container">
    <div class="review-card">
      <table class="review-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 10%" />
          <col style="width: 30%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
          <col style="width: 25%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>작성자 아이디</th>
            <th>내용</th>
            <th>좋아요</th>
            <th>싫어요</th>
            <th>별점</th>
            <th>업로드 시간</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="review in reviews" :key="review.id">
            <td>{{ review.writer }}</td>
            <td>{{ review.writercode }}</td>
            <td>
              <RouterLink :to="`/review/${review.id}`">{{ review.content }}</RouterLink>
            </td>
            <td>{{ review.like }}</td>
            <td>{{ review.dislike }}</td>
            <td>{{ review.rating }}</td>
            <td>{{ review.uploadtime }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { useReviewStore } from "@/stores/reviewStore";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";

const { params } = useRoute();
const reviewStore = useReviewStore();
const reviews = ref([]);
const reviewsLoaded = ref(false);

onMounted(async () => {
  await reviewStore.reviewListByTrainer(params.member_code);
  reviews.value = reviewStore.reviewList;
  reviewsLoaded.value = true;
});
</script>

<style scoped>
.container {
  padding: 20px;
  background-color: #f9f9f9;
}

.review-card {
  overflow-x: auto;
}

.review-list {
  width: 100%;
  border-collapse: collapse;
}

.review-list th, .review-list td {
  border: 1px solid #ccc;
  padding: 8px;
  text-align: center;
}

.review-list th {
  background-color: #f2f2f2;
}

.review-list td {
  background-color: #fff;
}

.review-list a {
  text-decoration: none;
  color: #007bff;
}

.review-list a:hover {
  text-decoration: underline;
}
</style>
