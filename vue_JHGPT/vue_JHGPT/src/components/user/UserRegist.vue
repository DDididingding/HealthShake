<template>
  <div class="container">
    <h2>회원 가입</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input type="text" id="id" v-model="id" class="view" /><br />
      <label for="password">비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="password"
        class="view"
      /><br />
      <label for="password2">비밀번호 확인</label>
      <input
        type="password"
        id="password2"
        v-model="password2"
        class="view"
      /><br />
      <label for="name">이름</label>
      <input type="text" id="name" v-model="name" class="view" /><br />
      <label for="email">이메일</label>
      <input type="email" id="email" v-model="email" class="view" /><br />
      <label for="age">나이</label>
      <input type="number" id="age" v-model="age" class="view" /><br />
      <button class="btn" @click="regist">등록</button>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const router = useRouter();
const emit = defineEmits(["create-user"]);

const id = ref("");
const password = ref("");
const password2 = ref("");
const name = ref("");
const email = ref("");
const age = ref(0);
const users = ref([]);

const getUserList = () => {
  const API_URL = `http://localhost:9999/userapi/user`;
  axios({
    url: API_URL,
    method: "GET",
  })
    .then((res) => {
      users.value = Array.isArray(res.data) ? res.data : [];
    })
    .catch((err) => {
      console.log(err);
    });
};

// email에 @의 포함 여부
// 비밀번호가 8자리 이상이며 특수문자를 포함했는지 여부
// password와 password2의 일치 여부
// id 중복 여부를 확인해 유효성을 검토하고, 이상이 있을 시 alert로 경고한다.
const regist = () => {
  // id 중복 여부를 확인해 유효성을 검토하고, 이상이 있을 시 alert로 경고한다.

  const user = {
    id: id.value,
    password: password.value,
    name: name.value,
    email: email.value,
    age: age.value,
  };


  if(
    users.value.some((u) => u.id === user.id)
    )
    {
      alert("이미 사용 중인 아이디입니다.");
      return;
    }
  if(
    !email.value.includes('@') 
  ){
    alert("올바른 이메일 형식이 아닙니다.");
    return;
  }
  if(
    password.value.length <8
  ){
    alert("8자리 이상의 비밀번호를 입력해주세요");
    return;
  }

  if(
    password.value != password2.value
  ){
    alert("동일한 비밀번호를 입력해주세요");
    return;
  }

  var specialRule = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
  if(
    !specialRule.test(password.value)
  ){
    alert("특수문자가 포함된 비밀번호를 입력해주세요");
    return;
  }

  if (
    id.value === "" ||
    password.value === "" ||
    name.value === "" ||
    email.value === ""
  ) {
    alert("모든 내용을 입력해주세요");
    return;
  }
  emit("create-user", user);
};

getUserList();
</script>
