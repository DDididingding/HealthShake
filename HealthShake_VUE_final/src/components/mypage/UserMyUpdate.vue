<template>
  <div class="container">
    <h2 class="mb-4 font-bold text-2xl mb-10">
      유저 프로필 수정 페이지입니다.
    </h2>
    <div class="needs-validation" novalidate>
      <div class="mb-3">
        <label for="name" class="mr-3">이름 :</label>
        <input
          type="text"
          id="name"
          v-model="user.name"
          disabled
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div class="mb-3">
        <label for="email" class="mr-3">이메일 :</label>
        <input
          type="text"
          id="email"
          v-model="user.email"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div class="mb-3">
        <label for="age" class="mr-3">나이 :</label>
        <input
          type="number"
          id="age"
          v-model="user.age"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div>
        <div class="mb-3">
          <label for="gender" class="mr-3">성별</label>
          <select
            id="gender"
            v-model="user.gender"
            class="form-control p-2 rounded-xl border border-slate-200 border-2"
            required
          >
            <option value="" disabled selected hidden>성별을 선택하세요</option>
            <option value="남자">남자</option>
            <option value="여자">여자</option>
          </select>
        </div>
      </div>
      <div class="mb-3">
        <label for="nickname" class="mr-3">닉네임:</label>
        <input
          type="text"
          id="nickname"
          v-model="user.nickname"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div class="mb-3">
        <label for="readme" class="mr-3">소개글 :</label>
        <textarea
          id="readme"
          cols="30"
          rows="10"
          v-model="user.readme"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        ></textarea>
      </div>
      <div class="mb-3">
        <label for="preferPart" class="mr-3">선호하는 부위</label>
        <input
          type="text"
          id="preferPart"
          v-model="user.preferPart"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
          required
        />
      </div>
      <div class="mb-3">
        <label class="mr-3">선호하는 성별</label>
        <div>
          <label>
            <input type="radio" v-model="user.preferGender" value="male" /> 남성
          </label>
          <label>
            <input type="radio" v-model="user.preferGender" value="female" />
            여성
          </label>
        </div>
      </div>
      <div class="mb-3">
        <label for="preferStyle" class="mr-3">선호하는 스타일</label>
        <input
          type="text"
          id="preferStyle"
          v-model="user.preferStyle"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
          required
        />
      </div>
      <div class="mb-3">
        <label for="preferGoal" class="mr-3">목표</label>
        <input
          type="text"
          id="preferGoal"
          v-model="user.preferGoal"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
          required
        />
      </div>
      <div class="text-center">
        <button
          class="bg-gradient-to-r from-rose-400 via-fuchsia-500 to-indigo-500 w-full mt-12 rounded-2xl"
          @click="updateProfile"
        >
          수정
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from "vue";
import { useMemberStore } from "@/stores/memberStore";
import { useRoute } from "vue-router";
import router from "@/router";
import axios from "axios";

const route = useRoute();
const memberStore = useMemberStore();
const user = ref({});
const isUserLoaded = ref(false);

onMounted(() => {
  const member_code = route.params.member_code;
  console.log(member_code);
  memberStore.selectUserPromise(member_code).then(() => {
    user.value = { ...memberStore.user }; // 기존 유저 정보 복사
    console.log(memberStore.user);
    isUserLoaded.value = true;
  });

  console.log(memberStore.user);
  isUserLoaded.value = true;
});

const updateProfile = () => {
  // 사용자가 입력한 내용을 기존 유저 정보에 반영
  const u = {
    member_code: route.params.member_code,
    member_id: user.value.id, // 아이디는 disabled 속성이므로 그대로 유지
    member_name: user.value.name, // 이름은 disabled 속성이므로 그대로 유지
    member_email: user.value.email,
    member_age: user.value.age,
    member_gender: user.value.gender,
    member_nickname: user.value.nickname,
    user_readme: user.value.readme,
    prefer_part: user.value.preferPart,
    prefer_gender: user.value.preferGender,
    prefer_style: user.value.preferStyle,
    prefer_goal: user.value.preferGoal,
  };
  console.log(u);
  console.log("여기에요요요");

  // memberStore의 updateUser 함수를 호출하여 실제 업데이트 수행
  memberStore.updateUserMy(u);
};
</script>

<style scoped>
.container {
  max-width: 500px;
  margin: 30px auto;
  padding: 20px;
}

h2.mb-4 {
  text-align: center;
}

button {
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  color: #fff;
  cursor: pointer;
}
</style>
