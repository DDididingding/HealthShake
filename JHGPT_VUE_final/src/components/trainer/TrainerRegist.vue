<template>
  <!--1119구현 완, 근데 테스트는 안해봄-->
  <div class="container">
    <h2 class="mb-4">트레이너 회원 가입</h2>
    <div class="needs-validation" novalidate>
      <div class="mb-3">
        <label for="id" class="form-label">아이디</label>
        <input
          type="text"
          id="id"
          v-model="id"
          class="form-control"
          placeholder="아이디를 입력하세요"
          required
        />
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">비밀번호</label>
        <input
          type="password"
          id="password"
          v-model="password"
          class="form-control"
          placeholder="특수문자 포함 8자리 이상"
          required
        />
      </div>
      <div class="mb-3">
        <label for="password2" class="form-label">비밀번호 확인</label>
        <input
          type="password"
          id="password2"
          v-model="password2"
          class="form-control"
          placeholder="비밀번호 확인"
          required
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">이름</label>
        <input
          type="text"
          id="name"
          v-model="name"
          class="form-control"
          placeholder="이름을 입력하세요"
          required
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">별명</label>
        <input
          type="text"
          id="nickname"
          v-model="nickname"
          class="form-control"
          placeholder="닉네임을 입력하세요"
          required
        />
      </div>
      <div class="mb-3">
        <label for="gender" class="form-label">성별</label>
        <select id="gender" v-model="gender" class="form-control" required>
          <option value="" disabled selected hidden>성별을 선택하세요</option>
          <option value="남자">남자</option>
          <option value="여자">여자</option>
        </select>
      </div>
      <div class="mb-3">
        <label for="email" class="form-label">이메일</label>
        <input
          type="email"
          id="email"
          v-model="email"
          class="form-control"
          required
        />
      </div>
      <div class="mb-3">
        <label for="age" class="form-label">나이</label>
        <input
          type="number"
          id="age"
          v-model="age"
          class="form-control"
          required
        />
      </div>
      <div class="mb-3">
        <label for="providePart" class="form-label">제공하는 부위</label>
        <select
          id="providePart"
          v-model="providePart"
          class="form-control"
          required
        >
          <option value="" disabled selected>부위를 선택하세요</option>
          <option value="상체">상체</option>
          <option value="하체">하체</option>
          <option value="코어">코어</option>
          <!-- Add more options as needed -->
        </select>
      </div>
      <div class="mb-3">
        <label for="provideStyle" class="form-label">제공하는 스타일</label>
        <select
          id="provideStyle"
          v-model="provideStyle"
          class="form-control"
          required
        >
          <option value="" disabled selected>스타일을 선택하세요</option>
          <option value="빡센 트레이너">빡센 트레이너</option>
          <option value="착한 트레이너">착한 트레이너</option>
          <option value="파워리프팅">파워리프팅</option>
          <option value="바디빌딩">바디빌딩</option>
          <!-- Add more options as needed -->
        </select>
      </div>
      <div class="mb-3">
        <label for="provideGoal" class="form-label">목표</label>
        <select
          id="provideGoal"
          v-model="provideGoal"
          class="form-control"
          required
        >
        <option value="" disabled selected>목표를 선택하세요</option>
          <option value="체중 감량">체중 감량</option>
          <option value="근육 증가">근육 증가</option>
          <option value="체력 향상">체력 향상</option>
          <option value="유연성 향상">유연성 향상</option>
          <!-- Add more options as needed -->
        </select>
      </div>
      <div class="mb-3">
        <label for="trainerReadme" class="form-label">트레이너 소개</label>
        <textarea
          id="trainerReadme"
          v-model="trainerReadme"
          class="form-control"
          rows="4"
          required
        ></textarea>
      </div>
      <div class="mb-3">
        <label for="trainerPrice" class="form-label">가격</label>
        <input
          type="number"
          id="trainerPrice"
          v-model="trainerPrice"
          class="form-control"
          required
        />
      </div>
      <div class="text-center">
        <button class="btn btn-primary" @click="regist">등록</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
import { useMemberStore } from "@/stores/memberStore";

const router = useRouter();
const emit = defineEmits(["create-user"]);
const memberStore = useMemberStore();

const id = ref("");
const password = ref("");
const password2 = ref("");
const name = ref("");
const nickname = ref("");
const email = ref("");
const age = ref(0);
const gender = ref("");
const trainers = computed(() => memberStore.trainers);
const providePart = ref("");
const provideStyle = ref("");
const provideGoal = ref("");
const trainerReadme = ref("");
const trainerPrice = ref(0);

onMounted(() => {
  memberStore.getTrainerListPromise();
});

// email에 @의 포함 여부
// 비밀번호가 8자리 이상이며 특수문자를 포함했는지 여부
// password와 password2의 일치 여부
// id 중복 여부를 확인해 유효성을 검토하고, 이상이 있을 시 alert로 경고한다.
const regist = () => {
  // id 중복 여부를 확인해 유효성을 검토하고, 이상이 있을 시 alert로 경고한다.

  const trainer = {
    member_id: id.value,
    member_password: password.value,
    member_name: name.value,
    member_email: email.value,
    member_age: age.value,
    member_nickname: nickname.value,
    member_gender: gender.value,
    provide_goal: provideGoal.value,
    provide_part: providePart.value,
    provide_style: provideStyle.value,
    trainer_price: trainerPrice.value,
    trainer_readme: trainerReadme.value,
  };

  if (trainers.value.find((t) => t.member_id === trainer.member_id)) {
    alert("이미 사용 중인 아이디입니다.");
    return;
  }
  if (!email.value.includes("@")) {
    alert("올바른 이메일 형식이 아닙니다.");
    return;
  }
  if (password.value.length < 8) {
    alert("8자리 이상의 비밀번호를 입력해주세요");
    return;
  }

  if (password.value != password2.value) {
    alert("동일한 비밀번호를 입력해주세요");
    return;
  }

  var specialRule = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
  if (!specialRule.test(password.value)) {
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
  memberStore.trainerSignup(trainer);
  redirectToHome();
};

const redirectToHome = () => {
  // 회원가입 성공 후 홈 페이지로 이동
  router.push("home");
};
</script>

<style scoped>
/* Add custom styles to improve the appearance */
.container {
  max-width: 500px;
  margin: 30px auto;
  padding: 20px;
  background-color: #fff8dc; 
  border-radius: 10px; 
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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

h2.mb-4 {
  text-align: center;
}

/* Additional styles or modifications can be added based on preference */
</style>
