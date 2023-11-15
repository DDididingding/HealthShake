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
    </div>
  </template>
  
  <script setup>
    import { ref } from 'vue';

  const user = ref({
    name: '유나',
    bio: '헬스를 좋아하는 개발자',
    age: 21,
    gender: '여성',
    profilePicture: 'https://cdn.topstarnews.net/news/photo/202308/15381770_1161137_5141.jpg',
    workoutInterests: '요가, 필라테스',
    purchasedPrograms: '다이어트 프로그램',
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
  