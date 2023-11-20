import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_VIDEO_API = `http://localhost:9999/api/video`//수정필요

export const useVideoStore = defineStore('video', () => {
  
  const videoList = ref([])
  //등록된 모든 비디오 정보 반환
  const getVideoList = function () {
    axios.get(REST_VIDEO_API)
      .then((response) => {
      videoList.value = response.data
      })
  }

  const VideoListByTrainer = ((member_code) => {
    axios
        .get(`http://localhost:9999/api/video/trainer/${member_code}`)
        .then((resp) => {
            console.log("비디오 목록 가져오기 성공");
            const responseData = resp.data

            videoList.value = responseData.map(item => ({
                uploadercode : item.video_uploader,
                code : item.video_code,
                title : item.video_title,
                readme : item.video_readme,
                url : item.video_url,
                viewcnt : item.video_viewcnt,
            }))
        })
        .catch(() => {
            console.log("비디오 목록 가져오기 실패");
        })
  })


  //비디오 객체 저장
  const registVideo = ((video) => {
    axios
        .post("https://localhost:9999/api/video")
        .then(() => {
            console.log("registVideo 성공");
            router.push({ name: "Home" })
        })
        .catch(() => {
            console.log("registVideo 실패");
        })
  })


  //비디오 코드로 비디오 한개 가져오기
  const video = ref(null);

  const selectVideo = function (video_code) {
    axios.get(`${REST_VIDEO_API}/${video_code}`)
      .then((response) => {
      video.value = response.data
    })
  }

  //비디오 삭제하기
  const deleteVideo = ((video_code) => {
    axios
      .delete(`${REST_VIDEO_API}/${video_code}`)
      .then(() => {
          console.log("deleteVideo 성공");
          router.push({ name: "Home" })
      })
  })

  const updateVideo = ((video) => {
    const video_code = video.video_code;
    axios
      .put(`http://localhost:9999/api/video/${video_code}`)//수정 링크
      .then(() => {
          console.log("updateVideo 성공");
          router.push({ name: "trainerMypage" })
      })
      .catch(() => {
            console.log("updateVideo 실패");
        })
  })

   return { VideoListByTrainer, videoList, video, registVideo, selectVideo, deleteVideo, getVideoList, updateVideo }
})