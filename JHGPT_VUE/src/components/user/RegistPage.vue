<template>
    <div class = "container">
      <h2>회원 유형 선택</h2>
      <div class="buttons-container">
        <RouterLink class="btn" :to="{ name: 'TrainerRegist' }">Trainer</RouterLink>
        <RouterLink class="btn" :to="{ name: 'UserRegist' }">User</RouterLink>
        <!--나중에 이미지로 대체하자-->
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
  .container {
  margin-top: 20px;
  max-width: 400px;
  padding: 20px;
  border-radius: 5px;
  background-color: #f9f9f9;
  justify-content: center;
}
  .buttons-container {
    display: flex;
    justify-content: space-around;
    margin-bottom: 15px;
  }
  
  .btn {
    width: 80%; /* 버튼 너비를 80%로 조절 */
    padding: 20px; /* 내부 여백을 조절하여 정사각형으로 만듭니다. */
    border: none;
    background-color: lightcoral;
    color: white;
    border-radius: 5px;
    text-align: center;
    text-decoration: none;
    font-size: 18px;
    transition: background-color 0.3s ease;
    margin: 10%;
  }
  
  .btn:hover {
    background-color: lightcoral; /* 마우스 호버 시 더 어두운 회색으로 변경 */
  }
  </style>
  