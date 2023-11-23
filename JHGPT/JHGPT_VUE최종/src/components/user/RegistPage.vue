<template>
  <div class="center-container">
    <h2>회원 유형을 선택하세요 </h2>
    <div class="buttons-container">
      <RouterLink class="btn user-btn" :to="{ name: 'UserRegist' }">User</RouterLink>
      <RouterLink class="btn trainer-btn" :to="{ name: 'TrainerRegist' }">Trainer</RouterLink>
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
  background-color: #f9f9f9;
  margin: auto; /* Center the container horizontally */
}

.buttons-container {
  display: flex;
  justify-content:space-between;
  margin-top: 15px;
  align-items: center;
}

.btn {
  width: 150px; /* Increased button size */
  height: 150px; /* Increased button size */
  border: none;
  border-radius: 20%;
  background-color: mediumaquamarine;
  color: white;
  text-align: center;
  text-decoration: none;
  font-size: 18px;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: background-color 0.3s ease;
  margin : 20px;
}

.user-btn:hover,
.trainer-btn:hover {
  background-color: darkcyan;
  transform: scale(1.1); /* Slightly increase size on hover */
}

h2.mb-4{
  text-align: center;
}
</style>
