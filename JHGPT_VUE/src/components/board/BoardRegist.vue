<template>
    <div class="board-registration">
      <h1>게시물 등록 페이지</h1>
      <div class="needs-validation" nonvalidate>
        <div class="mb-3">
          <label for="title" class="form-label">제목</label>
          <input
            type="text"
            id="title"
            v-model="title"
            class="form-control"
            placeholder="제목을 입력하세요"
            required
          />
        </div>
        <div class="mb-3">
          <label for="content" class="form-label">내용</label>
          <input
            type="text"
            id="content"
            v-model="content"
            class="form-control"
            placeholder="내용을 입력하세요"
            required
          />
        </div>
        <div>
          <button class="btn btn-primary" @click="submitBoard">등록</button>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import { useBoardStore } from "@/stores/boardStore";
  import { useUserStore } from "@/stores/userStore";
  import { computed } from "vue";
  import { useRoute } from "vue-router";

  const route = useRoute();
  const boardStore = useBoardStore();
  const userStore = useUserStore();
  const title = ref('');
  const content = ref('');
  const loginMember = computed(() => userStore.loginMember);

  //멤버 코드가 string이기 때문에 int로 변환
  const writer = parseInt(route.params.member_code);


  const submitBoard = () => {
    console.log(loginMember.value.member_code);
    console.log(writer);
    const board = {
    member_code: writer,
    board_title: title.value,
    board_content: content.value,
    board_uploader: loginMember.value.member_code,
  };
  
    if (
      title.value ==="" ||
      content.value === ""
    ){
    alert("모든 내용을 입력해주세요");
    return;
     }
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
  