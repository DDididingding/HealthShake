<template>
  <div>
    <RouterView
      :videos="videos"
      @create-video="createVideo"
      @update-video="updateVideo"
      @delete-video="deleteVideo"
    />
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import axios from 'axios'

const router = useRouter();
const users = ref([]);

// 영상 목록 조회
const getVideoList = () => {
  const API_URL = `http://localhost:9999/userapi/video`; //수정 필요
  axios({
    url: API_URL,
    method: "get",
  })
    .then((res) => {
      users.value = res.data;
    })
    .catch((err) => {
      console.log(err);
    });
};

// 영상 등록
const createVideo = (video) =>  {
  const API_URL = `http://localhost:9999/userapi/user`; //수정 필요
  axios({
    url: API_URL,
    method: "post",
    params: {
      video_id: video.video_id,
      video_title: video.video_title,
      content: video.content,
      video_url : video.video_url,
    },
  })
    .then(() => {
      alert("등록 완료");
      getVideoList();
      router.push("/user"); //수정 필요
    })
    .catch((err) => {
      console.log(err);
    });
};

// 사용자 수정 (유효성 검토)
const updateVideo = (user) => {
  const API_URL = `http://localhost:9999/userapi/user`;
  // axios 요청 (Spring Boot Rest API 참고)
  axios({
    url: API_URL,
    method: "put",
    params: {
      id: user.id,
      password: user.password,
      name: user.name,
      email: user.email,
      age: user.age,
    },
  })
    .then(() => {
      alert("수정 완료");
      getUserList();
      router.push("/user");
    })
    .catch((err) => {
      console.log(err);
    });
};

// 사용자 삭제
const deleteVideo = (user) => {
  const API_URL = `http://localhost:9999/userapi/user/${user.id}`;
  // axios 요청 (Spring Boot Rest API 참고)
  axios({
    url: API_URL,
    method: "delete",
  })
    .then(() => {
      alert("삭제 완료");
      getUserList();
      router.push("/user");
    })
    .catch((err) => {
      console.log(err);
    });
};

onMounted(() => {
  getUserList();
});
</script>

<style>
.user-link {
  color: black;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 130px;
}

.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}

/* 테이블 CSS */
.user-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.user-list td,
.user-list th {
  border: 1px solid black;
}
</style>
