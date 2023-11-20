import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

//1117 수정완

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
  

  async(member_code) => {
    try {
      const response = await axios.get(`http://localhost:9999/trainer/${member_code}/review`)
      const responseData = response.data;

      reviewList.value = res

      return reviewList;
      }
      catch (error) {
      console.error('리뷰 목록을 불러오는 데 실패했습니다.', error);
      throw error;
    }
  };

  const ReviewListByWriter = async (review_writer) => {
    try{
      const response = await axios.get('REST_REVIEW_API/${review_writer}')
      reviewList.value = response.data;
      return reviewList;
      }
      catch (error) {
      console.error('리뷰 목록을 불러오는 데 실패했습니다.', error);
      throw error;
    }
  }

  const review = ref({})
  const reviewDetail = (review_code) => {
    axios.get(`${REST_REVIEW_API}/${review_code}`)
      .then((response) => {
        review.value = response.data
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
      .delete(`${REST_REVIEW_API}/${review_code}`)
      .then(() => {
        console.log("삭제 성공");
        router.push({name: 'Home'})
      })
  }


const updateReview = function () {
    axios.put(REST_REVIEW_API, review.value)
      .then(() => {
      router.push({name: 'reviewList'})
    })
  }

  

  return { review,registReview, reviewList, ReviewListByWriter, ReviewListByTrainer, reviewDetail, deleteReview, updateReview }
})