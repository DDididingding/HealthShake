<template>
    <div class="user-profile">
      <div class="profile-header">
        <img class="profile-picture" :src="user.profilePicture" alt="프로필 이미지" />
        <h1>{{ user.name }}</h1>
        <p>{{ user.bio }}</p>
      </div>
  
      <div class="profile-info">
        <div class="info-item">
          <strong>나이:</strong> {{ user.age }}
        </div>
        <div class="info-item">
          <strong>성별:</strong> {{ user.gender }}
        </div>
        <div class="info-item">
          <strong>운동 관심사:</strong> {{ user.workoutInterests }}
        </div>
        <div class="info-item">
          <strong>구매한 프로그램:</strong> {{ user.purchasedPrograms }}
        </div>
        <!-- 기타 유저 정보 항목들을 추가할 수 있습니다. -->
      </div>
      <button class="btn" @click="updateUser">수정</button>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';

  import axios from "axios";

  const emit = defineEmits();


  const user = ref({
    name: '',
    bio: '',
    age: 0,
    gender: '',
    profilePicture: '',
    workoutInterests: '',
    purchasedPrograms: '',
  });

  const updateUser = () => {
    emit("update-user", user.value);
  };

  onMounted(() => {
  const pathName = new URL(document.location).pathname.split("/");
  const id = pathName[pathName.length - 1];
  const API_URL = `http://localhost:9999/userapi/user/${id}`;
  axios({
    url: API_URL,
    method: "GET",
  })
    .then((res) => {
      user.value.id = res.data.id;
      user.value.password = res.data.password;
      user.value.name = res.data.name;
      user.value.email = res.data.email;
      user.value.age = res.data.age;
    })
    .catch((err) => {
      console.log(err);
    });
});
  </script>
  
  <style scoped>
  .user-profile {
    max-width: 600px;
    margin: auto;
    text-align: center;
  }
  
  .profile-header {
    padding: 20px;
  }
  
  .profile-picture {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    object-fit: cover;
    margin-bottom: 10px;
  }
  
  .profile-info {
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
  
  .info-item {
    font-size: 16px;
  }
  </style>
  