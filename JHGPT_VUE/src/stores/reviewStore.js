import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

//1121 다시 싹 수정

const REST_REVIEW_API = `http://localhost:9999/api/review`//수정필요

export const useReviewStore = defineStore('review', () => {

  const review = ref(null);
  const reviewList = ref([]);

  const ReviewListByTrainer = (member_code) => {
    return new Promise((resolve, reject) => {
      axios
        .get(`http://localhost:9999/api/trainer/${member_code}/review`)
        .then((resp) => {
          console.log("리뷰 목록 가져오기 성공");
          const responseData = resp.data;

          reviewList.value = responseData.map((item) => ({
            writercode: item.member_code,
            code: item.review_code,
            content: item.content,
            dislike: item.dislike,
            like: item.like,
            rating: item.rating,
            uploadtime: item.uploadtime,
            writer: item.writer,
          }));

          resolve();
        })
        .catch((error) => {
          console.log("리뷰 목록 가져오기 실패", error);
          reject();
        });
    });
  };

  const ReviewListByWriter = (review_writer) => {
    return new Promise((resolve, reject) => {
      axios
        .get(`http://localhost:9999/api/review/${review_writer}`)
        .then((resp) => {
          console.log("리뷰 목록 가져오기 성공");
          const responseData = resp.data;

          reviewList.value = responseData.map((item) => ({
            writercode: item.member_code,
            code: item.review_code,
            content: item.content,
            dislike: item.dislike,
            like: item.like,
            rating: item.rating,
            uploadtime: item.uploadtime,
            writer: item.writer,
          }));

          resolve();
        })
        .catch((error) => {
          console.log("리뷰 목록 가져오기 실패", error);
          reject();
        });
    });
  };

  const registReview = (review) => {
    return new Promise((resolve, reject) => {
      axios
        .post("https://localhost:9999/api/review", review)
        .then(() => {
          console.log("registReview 성공");
          router.push({ name: "Home" });
          resolve();
        })
        .catch((error) => {
          console.log("registReview 실패", error);
          reject();
        });
    });
  };

  const deleteReview = (review_code) => {
    return new Promise((resolve, reject) => {
      axios
        .delete(`https://localhost:9999/api/review/${review_code}`)
        .then(() => {
          console.log("삭제 성공");
          router.push({ name: "Home" });
          resolve();
        })
        .catch((error) => {
          console.log("삭제 실패", error);
          reject();
        });
    });
  };

  const updateReview = (review_code, review) => {
    return new Promise((resolve, reject) => {
      axios
        .put(`http://localhost:9999/api/review/${review_code}`, review)
        .then(() => {
          console.log("updateReview 성공");
          router.push({ name: "reviewList" });
          resolve();
        })
        .catch((error) => {
          console.log("updateReview 실패", error);
          reject();
        });
    });
  };

  return { review, registReview, reviewList, ReviewListByWriter, ReviewListByTrainer, deleteReview, updateReview };
});
