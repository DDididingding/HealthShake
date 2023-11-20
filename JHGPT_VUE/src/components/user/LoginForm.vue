<template>
  <div class="container">
    <h2>로그인</h2>
    <fieldset class="form-group">
      <div class="input-group">
        <label for="id">아이디</label>
        <input type="text" id="id" v-model="id" class="form-control" />
      </div>
      <div class="input-group">
        <label for="password">비밀번호</label>
        <input type="password" id="password" v-model="password" class="form-control" />
      </div>
      <button class="btn btn-pink" @click="handleLogin">로그인</button>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useMemberStore } from "@/stores/memberStore";

const memberStore = useMemberStore();

const id = ref("");
const password = ref("");

// memberStore.setLoginMember(member);

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

h2 {
  text-align: center;
  color:  mediumaquamarine; 
}

.form-group {
  margin-bottom: 30px;
  border: none;
}

.input-group {
  margin-bottom: 30px;
  border: none;
}

label {
  display: block;
  margin-bottom: 10px;
}

.form-control {
  width: 100%;
  padding: 8px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.btn {
  display: block;
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: none;
  border-radius: 4px;
  background-color: mediumaquamarine; 
  color: #fff;
  cursor: pointer;
}

.btn:hover {
  background-color: mediumaquamarine;
}
</style>
