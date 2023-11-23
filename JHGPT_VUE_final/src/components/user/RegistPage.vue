<template>
  <div class="center-container">
    <h2 class="font-bold text-xl">회원 유형을 선택하세요</h2>
    <div class="buttons-container">
      <RouterLink
        class="btn user-btn shadow-xl hover:bg-gradient-to-r from-rose-400 via-fuchsia-500 to-indigo-500 hover:text-white"
        :to="{ name: 'UserRegist' }"
        >User</RouterLink
      >
      <RouterLink
        class="btn trainer-btn shadow-xl hover:bg-gradient-to-r from-rose-400 via-fuchsia-500 to-indigo-500 hover:text-white"
        :to="{ name: 'TrainerRegist' }"
        >Trainer</RouterLink
      >
    </div>
    <RouterView />
  </div>
</template>

<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<style scoped>
.center-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 20px;
  max-width: 400px;
  width: 80%; /* Centered container */
  padding: 20px;
  border-radius: 5px;
  margin: auto; /* Center the container horizontally */
}

.buttons-container {
  display: flex;
  justify-content: space-between;
  margin-top: 15px;
  align-items: center;
}

.btn {
  width: 150px; /* Increased button size */
  height: 150px; /* Increased button size */
  border: none;
  border-radius: 20%;
  background-color: white;
  color: black;
  text-align: center;
  text-decoration: none;
  font-size: 18px;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: background-color 0.3s ease;
  margin: 20px;
}

.user-btn:hover,
.trainer-btn:hover {
  transform: scale(1.1); /* Slightly increase size on hover */
  font-weight: 600;
}

h2.mb-4 {
  text-align: center;
}
</style>
