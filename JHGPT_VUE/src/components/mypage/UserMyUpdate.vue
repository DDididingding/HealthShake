<template>
    <div>
      <h4>유저 프로필 수정</h4>
      <fieldset>
        <legend>수정</legend>
        <div>
          <label for="id">아이디 :</label>
          <input type="text" id="id" v-model="memberStore.user.member_id" disabled>
        </div>
        <div>
          <label for="password">비밀번호 :</label>
          <input type="password" id="password" v-model="memberStore.user.member_password">
        </div>
        <div class="mb-3">
          <label for="password2">비밀번호 확인:</label>
          <input type="password" id="password2" v-model="password2" class="form-control" required />
        </div>
        <div>
          <label for="name">이름 :</label>
          <input type="text" id="name" v-model="memberStore.user.member_name">
        </div>
        <div>
          <label for="email">이메일 :</label>
          <input type="text" id="email" v-model="memberStore.user.member_email">
        </div>
        <div>
          <label for="age">나이 :</label>
          <input type="number" id="age" v-model="memberStore.user.member_age">
        </div>
        <div>
          <label class="form-label">성별:</label>
          <div>
            <label>
              <input type="radio" v-model="memberStore.user.gender" value="male"> 남성
            </label>
            <label>
              <input type="radio" v-model="memberStore.user.gender" value="female"> 여성
            </label>
          </div>
        </div>
        <div>
          <label for="nickname">닉네임:</label>
          <input type="text" id="nickname" readonly v-model="memberStore.user.member_nickname">
        </div>
        <div>
          <label for="readme">소개글 :</label>
          <textarea id="readme" cols="30" rows="10" v-model="memberStore.user.user_readme"></textarea>
        </div>
        <div>
          <label for="interest">운동 관심사 :</label>
          <textarea id="interest" cols="30" rows="10" v-model="memberStore.user.interest"></textarea>
        </div>
        <div class="mb-3">
          <label for="preferPart" class="form-label">선호하는 부위</label>
          <input type="text" id="preferPart" v-model="preferPart" class="form-control" required />
        </div>
        <div class="mb-3">
          <label class="form-label">선호하는 성별</label>
          <div>
            <label>
              <input type="radio" v-model="preferGender" value="male"> 남성
            </label>
            <label>
              <input type="radio" v-model="preferGender" value="female"> 여성
            </label>
          </div>
        </div>
        <div class="mb-3">
          <label for="preferStyle" class="form-label">선호하는 스타일</label>
          <input type="text" id="preferStyle" v-model="preferStyle" class="form-control" required />
        </div>
        <div class="mb-3">
          <label for="preferGoal" class="form-label">목표</label>
          <input type="text" id="preferGoal" v-model="preferGoal" class="form-control" required />
        </div>
        <div>
          <button @click="updateProfile">수정</button>
        </div>
      </fieldset>
    </div>
  </template>
  
  
  <script setup>
  import { ref } from "vue";
  import { useMemberStore } from "@/stores/memberStore";
  
  const memberStore = useMemberStore();
  
  const password2 = ref("");
  const preferPart = ref(memberStore.user.preferPart);
  const preferGender = ref(memberStore.user.preferGender);
  const preferStyle = ref(memberStore.user.preferStyle);
  const preferGoal = ref(memberStore.user.preferGoal);
  const userReadme = ref(memberStore.user.userReadme);
  const age = ref(memberStore.user.member_age);
  const gender = ref(memberStore.user.gender);
  const email = ref(memberStore.user.member_email);
  const name = ref(memberStore.user.member_name);
  const id = ref(memberStore.user.member_id);
  const password = ref(memberStore.user.member_password);
  
  const updateProfile = () => {
    if (memberStore.user.member_password !== password2.value) {
      alert("비밀번호가 일치하지 않습니다.");
      return;
    }
  
    const updatedUserProfile = {
      preferPart: preferPart.value,
      preferGender: preferGender.value,
      preferStyle: preferStyle.value,
      preferGoal: preferGoal.value,
      userReadme: userReadme.value,
      member_age: age.value,
      gender: gender.value,
      member_email: email.value,
      member_name: name.value,
      member_id: id.value,
      member_password: password.value
    };
  
    memberStore.updateUser(updatedUserProfile);
  };
  </script>