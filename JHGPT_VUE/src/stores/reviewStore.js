import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

//1121 다시 싹 수정

const REST_REVIEW_API = `http://localhost:9999/api/review`//수정필요

export const useReviewStore = defineStore('review', () => {
  const reviewList = ref([])

  const ReviewListByTrainer = ((member_code) => {
    axios
      .get(`http://localhost:9999/api/trainer/${member_code}/review`)
      .then((resp) => {
        console.log("리뷰 목록 가져오기 성공");
        const responseData = resp.data

        reviewList.value = responseData.map(item => ({
          writercode : item.member_code,
          code : item.review_code,
          content : item.content,
          dislike : item.dislike,
          like : item.like,
          rating : item.rating,
          uploadtime : item.uploadtime,
          writer : item.writer,
        }))
      })
      .catch(() => {
        console.log("리뷰 목록 가져오기 실패");
      })
  })
  

  const ReviewListByWriter = async (review_writer) => {
    axios
      .get(`http://localhost:9999/api/review/${review_writer}`)
      .then((resp) => {
        console.log("리뷰 목록 가져오기 성공");
        const responseData = resp.data

        reviewList.value = responseData.map(item => ({
          writercode : item.member_code,
          code : item.review_code,
          content : item.content,
          dislike : item.dislike,
          like : item.like,
          rating : item.rating,
          uploadtime : item.uploadtime,
          writer : item.writer,
        }))
      })
      .catch(() => {
        console.log("리뷰 목록 가져오기 실패");
      })
  }

  //리뷰 등록
  const registReview = ((review) => {
    axios
        .post("https://localhost:9999/api/review")
        .then(() => {
            console.log("registReview 성공");
            router.push({ name: "Home" })
        })
        .catch(() => {
            console.log("registReview 실패");
        })
  })

  //리뷰 삭제
  const deleteReview = (review_code) => {
    axios 
      .delete(`https://localhost:9999/api/review/${review_code}`)
      .then(() => {
        console.log("삭제 성공");
        router.push({name: 'Home'})
      })
  }


const updateReview = ( (review) => {
    axios.put(`http://localhost:9999/api/review/${review_code}`)
      .then(() => {
        console.log("updateReview 성공");
        router.push({name: 'reviewList'})
    })
    .catch(() => {
            console.log("updateReview 실패");
        })
  })

  

  return { review,registReview, reviewList, ReviewListByWriter, ReviewListByTrainer, reviewDetail, deleteReview, updateReview }
})