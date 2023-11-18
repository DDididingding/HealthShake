<template>
    <div class="review-registration">
      <h1>리뷰 등록 페이지</h1>
  
       <form @submit.prevent="submitForm" class="registration-form">
      <label for="title">제목:</label>
      <input type="text" id="title" v-model="review.title" required>

      <label for="content">내용:</label>
      <textarea id="content" v-model="review.content" required></textarea>

      <button @click="createBoard">등록</button>
    </form>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import { useReviewStore } from "@/stores/reviewStore";

const review = {
  title: '',
  content: '',
};
  
  const submitForm = () => {
    console.log('리뷰 정보:', review);
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
  