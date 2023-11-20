<template>
    <div>
      <h4>유저 프로필 수정</h4>
      <fieldset>
        <legend>수정</legend>
        <div>
          <label for="name">이름 :</label>
          <input type="text" id="name" v-model="user.name" disabled>
        </div>
        <div>
          <label for="email">이메일 :</label>
          <input type="text" id="email" v-model="user.email">
        </div>
        <div>
          <label for="age">나이 :</label>
          <input type="number" id="age" v-model="user.age">
        </div>
        <div>
          <label class="form-label">성별:</label>
          <div>
            <label>
              <input type="radio" v-model="user.gender" value="male"> 남성
            </label>
            <label>
              <input type="radio" v-model="user.gender" value="female"> 여성
            </label>
          </div>
        </div>
        <div>
          <label for="nickname">닉네임:</label>
          <input type="text" id="nickname" v-model="user.nickname">
        </div>
        <div>
          <label for="readme">소개글 :</label>
          <textarea id="readme" cols="30" rows="10" v-model="user.readme"></textarea>
        </div>
        <div class="mb-3">
          <label for="preferPart" class="form-label">선호하는 부위</label>
          <input type="text" id="preferPart" v-model="user.preferPart" class="form-control" required />
        </div>
        <div class="mb-3">
          <label class="form-label">선호하는 성별</label>
          <div>
            <label>
              <input type="radio" v-model="user.preferGender" value="male"> 남성
            </label>
            <label>
              <input type="radio" v-model="user.preferGender" value="female"> 여성
            </label>
          </div>
        </div>
        <div class="mb-3">
          <label for="preferStyle" class="form-label">선호하는 스타일</label>
          <input type="text" id="preferStyle" v-model="user.preferStyle" class="form-control" required />
        </div>
        <div class="mb-3">
          <label for="preferGoal" class="form-label">목표</label>
          <input type="text" id="preferGoal" v-model="user.preferGoal" class="form-control" required />
        </div>
        <div>
          <button @click="updateProfile">수정</button>
        </div>
      </fieldset>
    </div>
  </template>
  
  
<script setup>
import { ref, onMounted } from 'vue';
import { useMemberStore } from "@/stores/memberStore";
import { useRoute } from "vue-router";
import router from "@/router";
import axios from 'axios';

const route = useRoute();
const memberStore = useMemberStore();
const user = ref({});
const isUserLoaded = ref(false);

onMounted(async () => {
  try {
    const member_code = route.params.member_code;
    await memberStore.selectUser(member_code);
    user.value = { ...memberStore.user }; // 기존 유저 정보 복사
    isUserLoaded.value = true;
  } catch (error) {
    console.error("유저 정보를 불러오는 동안 오류가 발생했습니다:", error);
  }
});

const updateProfile = () => {
  // 사용자가 입력한 내용을 기존 유저 정보에 반영
  user.value = {
    id: user.value.id, // 아이디는 disabled 속성이므로 그대로 유지
    member_code: user.value.code,
    name: user.value.name, // 이름은 disabled 속성이므로 그대로 유지
    email: user.value.email,
    age: user.value.age,
    gender: user.value.gender,
    nickname: user.value.nickname,
    readme: user.value.readme,
    preferPart: user.value.preferPart,
    preferGender: user.value.preferGender,
    preferStyle: user.value.preferStyle,
    preferGoal: user.value.preferGoal,
    password: user.value.password,
  };

  // memberStore의 updateUser 함수를 호출하여 실제 업데이트 수행
  memberStore.updateUserMy(user.value);
};

  </script>