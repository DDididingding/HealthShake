<template>
<!--1119구현 완, 근데 테스트는 안해봄-->
  <div class="container">
    <h2 class="mb-4">트레이너 회원 가입</h2>
    <form @submit.prevent="regist" class="needs-validation" novalidate>
      <div class="mb-3">
        <label for="id" class="form-label">아이디</label>
        <input type="text" id="id" v-model="id" class="form-control" required />
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">비밀번호</label>
        <input type="password" id="password" v-model="password" class="form-control" required />
      </div>
      <div class="mb-3">
        <label for="password2" class="form-label">비밀번호 확인</label>
        <input type="password" id="password2" v-model="password2" class="form-control" required />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">이름</label>
        <input type="text" id="name" v-model="name" class="form-control" required />
      </div>
      <div class="mb-3">
        <label for="email" class="form-label">이메일</label>
        <input type="email" id="email" v-model="email" class="form-control" required />
      </div>
      <div class="mb-3">
        <label for="age" class="form-label">나이</label>
        <input type="number" id="age" v-model="age" class="form-control" required />
      </div>
      <div class="mb-3">
        <label for="providePart" class="form-label">제공하는 부위</label>
        <input type="text" id="providePart" v-model="providePart" class="form-control" required />
      </div>
      <div class="mb-3">
        <label for="provideStyle" class="form-label">제공하는 스타일</label>
        <input type="text" id="provideStyle" v-model="provideStyle" class="form-control" required />
      </div>
      <div class="mb-3">
        <label for="provideGoal" class="form-label">목표</label>
        <input type="text" id="provideGoal" v-model="provideGoal" class="form-control" required />
      </div>
      <div class="mb-3">
        <label for="trainerReadme" class="form-label">트레이너 소개</label>
        <textarea id="trainerReadme" v-model="trainerReadme" class="form-control" rows="4" required></textarea>
      </div>
      <div class="mb-3">
        <label for="trainerPrice" class="form-label">가격</label>
        <input type="number" id="trainerPrice" v-model="trainerPrice" class="form-control" required />
      </div>
      <div class="text-center">
        <button type="submit" class="btn btn-primary">등록</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
import { useMemberStore } from "@/stores/memberStore";

const router = useRouter();
const emit = defineEmits(["create-user"]);
const memberStore = useMemberStore;

const id = ref("");
const password = ref("");
const password2 = ref("");
const name = ref("");
const email = ref("");
const age = ref(0);
const trainers = computed(() => memberStore.trainers);
const providePart = ref("");
const provideStyle = ref("");
const provideGoal = ref("");
const trainerReadme = ref("");
const trainerPrice = ref(0);

onMounted(() => {
  memberStore.getTrainerList();
});

// email에 @의 포함 여부
// 비밀번호가 8자리 이상이며 특수문자를 포함했는지 여부
// password와 password2의 일치 여부
// id 중복 여부를 확인해 유효성을 검토하고, 이상이 있을 시 alert로 경고한다.
const regist = () => {
  // id 중복 여부를 확인해 유효성을 검토하고, 이상이 있을 시 alert로 경고한다.

  const trainer = {
    id: id.value,
    password: password.value,
    name: name.value,
    email: email.value,
    age: age.value,
    provideGoal: provideGoal.value,
    providePart: providePart.value,
    provideStyle: provideStyle.value,
    trainerPrice: trainerPrice.value,
    trainerReadme: trainerReadme.value,
  };


  if(
    trainers.value.some((u) => u.id === user.id)
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

  //특수문자검사
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
    email.value === "" ||
    provideGoal.value === "" ||
    providePart.value === "" ||
    provideStyle.value === "" ||
    trainerPrice.value === "" ||
    trainerReadme.value === "" 
  ) {
    alert("모든 내용을 입력해주세요");
    return;
  }
  emit("create-trainer", trainer);
  redirectToHome();
  memberStore.trainerSignup(trainer);
};

const redirectToHome = () => {
  // 회원가입 성공 후 홈 페이지로 이동
  router.push('home'); 
};

</script>

<style scoped>
/* Add custom styles to improve the appearance */
.container {
  max-width: 500px;
  margin: auto;
  padding: 20px;
}

form {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

input[type="text"],
input[type="password"],
input[type="email"],
input[type="number"] {
  width: 100%;
  padding: 10px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: #fff;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

/* Additional styles or modifications can be added based on preference */
</style>
