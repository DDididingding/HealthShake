<template>
    <div class="board-registration">
      <h1>게시물 등록 페이지</h1>
  
       <form @submit.prevent="submitForm" class="registration-form">
      <label for="title">제목:</label>
      <input type="text" id="title" v-model="board.title" required>

      <label for="content">내용:</label>
      <textarea id="content" v-model="board.content" required></textarea>
      <!--submit 하면 board에 title과 content보냄-->
      <!--여기 원래 다른 메서드였는데 일단 submit Board로 바꿈-->
      <button @click="submitBoard">등록하기</button>
    </form>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  //피니아 보드스토어 사용
  import { useBoardStore } from "@/stores/boardStore";

  const boardStore = useBoardStore();


  //보드 제출 함수 아직 구현안됨
  const submitBoard = () => {
    //보드를 만들어서
    const board = {
    title: '',
    content: '',
  };
  
    if ( //내용이 비어있으면
      title.value ==="" ||
      content.value === ""
    ){
    alert("모든 내용을 입력해주세요");
    return;
     }
     //emit해서 보드를 만들어서 보내줌
     //이를 감지해서 다른곳에서 보드를 받아서 사용할 수 있도록 함
    emit("create-board", board);
    boardStore.registBoard(board);
     //제출 완료되면 다른 페이지로 이동할 수 있도록 해야함
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
  