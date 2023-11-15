<template>
    <div class="user-registration">
      <h1>유저 회원가입 페이지</h1>
  
      <form @submit.prevent="submitForm" class="registration-form">
        <label for="name">이름:</label>
        <input type="text" id="name" v-model="user.name" required>
  
        <label for="username">아이디:</label>
        <input type="text" id="username" v-model="user.username" required>
  
        <label for="password">패스워드:</label>
        <input type="password" id="password" v-model="user.password" required>
  
        <label for="gender">성별:</label>
        <select id="gender" v-model="user.gender">
          <option value="male">남성</option>
          <option value="female">여성</option>
        </select>
  
        <label for="age">나이:</label>
        <input type="number" id="age" v-model="user.age" required>
  
        <button type="submit">가입하기</button>
      </form>
    </div>
  </template>
  
  <script setup>
  const user = {
    name: '',
    username: '',
    password: '',
    gender: 'male', // 기본값은 남성
    age: 0,
  };
  
  const submitForm = () => {
    console.log('유저 정보:', user);
  };
  </script>
  
  <style scoped>
  .user-registration {
    text-align: center;
    max-width: 600px;
    margin: auto;
  }
  
  .registration-form {
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
  
  label {
    font-weight: bold;
  }
  
  input, select {
    width: 100%;
    padding: 8px;
  }
  
  button {
    background-color: #42b983;
    color: #fff;
    border: none;
    padding: 10px;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #3498db;
  }
  </style>
  