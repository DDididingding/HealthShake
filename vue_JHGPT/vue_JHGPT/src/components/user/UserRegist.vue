<template>
  <div class="container">
    <h2>회원 가입</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input type="text" id="id" v-model="id" class="view" /><br />
      <label for="password">비밀번호</label>
      <input type="password" id="password" v-model="password" class="view" /><br />
      <label for="password2">비밀번호 확인</label>
      <input type="password" id="password2" v-model="password2" class="view" /><br />
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
import { ref, defineProps, defineEmits, onMounted } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const router = useRouter();
const props = defineProps(['users']);
const emit = defineEmits(['create-user']);

const id = ref("");
const password = ref("");
const password2 = ref("");
const name = ref("");
const email = ref("");
const age = ref(0);
const users = ref([]);

// const getUserList = async () => {
//   try {
//     const res = await axios.get(`http://localhost:9999/api/user`);  // GET 요청
//     users.value = Array.isArray(res.data) ? res.data : [];
//   } catch (err) {
//     console.log(err);
//   }
// };

const isPasswordValid = () => {
  if (password.value.length < 8) {
    alert("8자리 이상의 비밀번호를 입력해주세요");
    return false;
  }

  if (password.value !== password2.value) {
    alert("동일한 비밀번호를 입력해주세요");
    return false;
  }

  const specialRule = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
  if (!specialRule.test(password.value)) {
    alert("특수문자가 포함된 비밀번호를 입력해주세요");
    return false;
  }

  return true;
};

const isEmailValid = () => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email.value)) {
    alert("올바른 이메일 형식이 아닙니다.");
    return false;
  }
  return true;
};

const regist = async () => {
  if (!isEmailValid() || !isPasswordValid()) {
    return;
  }

  // id 중복 여부를 확인
  if (users.value.some((u) => u.id === id.value)) {
    alert("이미 사용 중인 아이디입니다.");
    return;
  }

  const user = {
    id: id.value,
    password: password.value,
    name: name.value,
    email: email.value,
    age: age.value,
  };

  // 필수 입력 값 체크
  if (id.value === "" || password.value === "" || name.value === "" || email.value === "") {
    alert("모든 내용을 입력해주세요");
    return;
  }

    try {
    // 등록 성공 시 부모 컴포넌트로 이벤트 emit
    await axios.post(`http://localhost:9999/api/signup`, user);  // POST 요청
    emit("create-user", user);
  } catch (error) {
    console.error(error);
    alert("회원 가입 중 오류가 발생했습니다.");
  }

  // 사용자 목록 다시 불러오기
  await getUserList();
};

regist;
</script>
