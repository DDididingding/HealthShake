<template>
    <div class="trainer-profile">
      <div class="profile-header">
        <img class="profile-picture" :src="trainer.profilePicture" alt="프로필 이미지" />
        <h1>{{ trainer.name }}</h1>
        <p>{{ trainer.gender }}</p>
        <p>{{ trainer.bio }}</p>
      </div>
  
      <div class="video-list">
        <h2>업로드한 비디오 목록</h2>
        <ul>
          <li v-for="(video, index) in trainer.videos" :key="index">
            <strong>{{ video.title }}</strong>
            <p>{{ video.description }}</p>
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script setup>
    import { ref } from 'vue';
    
  const trainer = ref({
    name: '트레이너1',
    gender: '남성',
    bio: '헬스 트레이너',
    profilePicture: 'https://placekitten.com/200/200', // Replace with the actual profile picture URL
    videos: [
      {
        title: '운동 기초',
        description: '운동의 기본 원리에 대한 강의',
      },
      {
        title: '다이어트 팁',
        description: '효과적인 다이어트 방법 소개',
      },
      {
        title: '근력 강화 프로그램',
        description: '근육을 강화하는 효과적인 운동 프로그램',
      },
    ],
  });
  </script>
  
  <style scoped>
  .trainer-profile {
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
  
  .video-list {
    margin-top: 20px;
  }
  
  ul {
    list-style: none;
    padding: 0;
  }
  
  li {
    border: 1px solid #ddd;
    padding: 10px;
    margin-bottom: 10px;
  }
  </style>
  