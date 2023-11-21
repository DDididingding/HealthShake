<template>
    <div class="board-registration">
      <h1>게시물 등록 페이지</h1>
  
       <form @submit.prevent="submitForm" class="registration-form">
      <label for="title">제목:</label>
      <input type="text" id="title" v-model="board.title" required>

      <label for="content">내용:</label>
      <textarea id="content" v-model="board.content" required></textarea>

      <button @click="createBoard">등록하기</button>
    </form>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import { useBoardStore } from "@/stores/boardStore";

  const boardStore = useBoardStore();

  const submitBoard = () => {
    const board = {
    title: '',
    content: '',
  };
  
    if (
      title.value ==="" ||
      content.value === ""
    ){
    alert("모든 내용을 입력해주세요");
    return;
     }
    emit("create-board", board);
    boardStore.registBoard(board);
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
  