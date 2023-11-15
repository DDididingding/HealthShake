<template>
    <div>
      <h1>회원가입 멀로할지 정하는 페이지임</h1>
      <div class="buttons-container">
        <RouterLink class="btn" :to="{ name: 'TrainerRegist' }">트레이너 회원가입</RouterLink>
        <RouterLink class="btn" :to="{ name: 'UserRegist' }">유저 회원가입</RouterLink>
      </div>
      <RouterView/>
    </div>
  </template>
  
  <script setup>
  import { RouterLink, RouterView } from "vue-router";
  import TrainerRegist from "@/components/trainer/TrainerRegist.vue";
  import UserRegist from "@/components/user/UserRegist.vue";
  </script>
  
  <style scoped>
  .buttons-container {
    display: flex;
    justify-content: space-around;
    margin-bottom: 15px;
  }
  
  .btn {
    width: 80%; /* 버튼 너비를 80%로 조절 */
    padding: 20px; /* 내부 여백을 조절하여 정사각형으로 만듭니다. */
    border: none;
    background-color: #808080; /* 회색 배경색 */
    color: white;
    border-radius: 5px;
    text-align: center;
    text-decoration: none;
    font-size: 18px;
    transition: background-color 0.3s ease;
    margin: 10%;
  }
  
  .btn:hover {
    background-color: #606060; /* 마우스 호버 시 더 어두운 회색으로 변경 */
  }
  </style>
  