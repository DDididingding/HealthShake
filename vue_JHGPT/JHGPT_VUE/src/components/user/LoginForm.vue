<template>
    <div class="login-container">
      <h2 class="login-title">로그인</h2>
      <fieldset class="login-fieldset">
        <label for="id">아이디</label>
        <input type="text" id="id" v-model="id" class="login-input" /><br />
        <label for="password">비밀번호</label>
        <input type="password" id="password" v-model="password" class="login-input" /><br />
        <button class="login-btn" @click="login">로그인</button>
      </fieldset>
    </div>
  </template>
  
  <script setup>
  import { ref } from "vue";
  import { defineEmits } from "vue";
  
  const id = ref("");
  const password = ref("");
  
  const emit = defineEmits(["login"]);
  
  const login = () => {
    let user = {
      id: id.value,
      password: password.value,
    };
    emit("login", user);
  };
  </script>
  
  <style scoped>
  .login-container {
    max-width: 400px;
    margin: auto;
    text-align: center;
  }
  
  .login-title {
    font-size: 24px;
    margin-bottom: 20px;
  }
  
  .login-fieldset {
    border: 1px solid #ddd;
    padding: 20px;
    border-radius: 5px;
  }
  
  .login-input {
    width: 100%;
    padding: 8px;
    margin-bottom: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  .login-btn {
    background-color: #42b983;
    color: white;
    border: none;
    padding: 10px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease;
  }
  
  .login-btn:hover {
    background-color: #3498db;
  }
  </style>
  