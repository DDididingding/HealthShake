<template>
    <div class="trainer-registration">
      <h1>트레이너 가입 페이지</h1>
  
      <form @submit.prevent="submitForm" class="registration-form">
        <table>
          <tbody>
            <tr>
              <td>이름:</td>
              <td><input type="text" v-model="trainer.name" required></td>
            </tr>
  
            <tr>
              <td>아이디:</td>
              <td><input type="text" v-model="trainer.username" required></td>
            </tr>
  
            <tr>
              <td>패스워드:</td>
              <td><input type="password" v-model="trainer.password" required></td>
            </tr>
  
            <tr>
              <td>피티 프로그램 제목:</td>
              <td><input type="text" v-model="trainer.programTitle" required></td>
            </tr>
  
            <tr>
              <td>피티 프로그램 설명:</td>
              <td><textarea v-model="trainer.programDescription" required></textarea></td>
            </tr>
  
            <tr v-for="(video, index) in trainer.videos" :key="index" class="video-group">
              <td>유튜브 비디오 링크:</td>
              <td>
                <input type="text" v-model="video.link" required>
                <button type="button" @click="removeVideoRow(index)" v-if="index === trainer.videos.length - 1">-</button>
                <button type="button" @click="addVideoRow" v-if="index === trainer.videos.length - 1">+</button>
              </td>
            </tr>
          </tbody>
        </table>
  
        <button type="submit">가입하기</button>
      </form>
    </div>
  </template>
  
  <script setup>
  const trainer = {
    name: '',
    username: '',
    password: '',
    programTitle: '',
    programDescription: '',
    videos: [{ link: '' }],
  };
  
  const addVideoRow = () => {
    trainer.videos.push({ link: '' });
  };
  
  const removeVideoRow = (index) => {
    trainer.videos.splice(index, 1);
  };
  
  const submitForm = () => {
    console.log('트레이너 정보:', trainer);
  };
  </script>
  
  <style scoped>
  .trainer-registration {
    text-align: center;
    max-width: 600px;
    margin: auto;
  }
  
  .registration-form {
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
  
  table {
    width: 100%;
  }
  
  td {
    padding: 5px;
  }
  
  textarea {
    resize: vertical;
  }
  
  .video-group {
    display: flex;
    align-items: center;
  }
  
  button {
    background-color: #42b983;
    color: #fff;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #3498db;
  }
  </style>
  