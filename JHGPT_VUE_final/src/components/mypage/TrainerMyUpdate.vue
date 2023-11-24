<template>
  <div class="container">
    <h2 class="mb-4 font-bold text-2xl mb-10">
      트레이너 프로필 수정 페이지입니다.
    </h2>
    <div>
      <div class="mb-3">
        <label for="name" class="mr-3">이름 :</label>
        <input
          type="text"
          id="name"
          v-model="trainer.name"
          disabled
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div class="mb-3">
        <label for="email" class="mr-3">이메일 :</label>
        <input
          type="text"
          id="email"
          v-model="trainer.email"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div class="mb-3">
        <label for="age" class="mr-3">나이 :</label>
        <input
          type="number"
          id="age"
          v-model="trainer.age"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div class="mb-3">
        <label class="mr-3">성별:</label>
        <select
          id="gender"
          v-model="trainer.gender"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
          required
        >
          <option value="" disabled selected hidden>성별을 선택하세요</option>
          <option value="남자">남자</option>
          <option value="여자">여자</option>
        </select>
      </div>
      <div class="mb-3">
        <label for="nickname" class="mr-3">닉네임:</label>
        <input
          type="text"
          id="nickname"
          v-model="trainer.nickname"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div class="mb-3">
        <label for="providePart" class="mr-3">제공하는 부위 :</label>
        <input
          type="text"
          id="providePart"
          v-model="providePart"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div class="mb-3">
        <label for="provideStyle" class="mr-3">제공하는 스타일 :</label>
        <input
          type="text"
          id="provideStyle"
          v-model="provideStyle"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div class="mb-3">
        <label for="provideGoal" class="mr-3">제공하는 목표 :</label>
        <input
          type="text"
          id="provideGoal"
          v-model="provideGoal"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        />
      </div>
      <div class="mb-3">
        <label for="trainerReadme" class="mr-3">트레이너 소개 :</label>
        <textarea
          id="trainerReadme"
          v-model="trainerReadme"
          rows="4"
          class="form-control p-2 rounded-xl border border-slate-200 border-2"
        ></textarea>
      </div>
      <div>
        <button
          class="bg-gradient-to-r from-rose-400 via-fuchsia-500 to-indigo-500 w-full mt-12 rounded-2xl"
          @click="updateTrainer"
        >
          수정
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useMemberStore } from "@/stores/memberStore";
import { useRoute } from "vue-router";
import router from "@/router";
import axios from "axios";
import { computed } from "vue";

const route = useRoute();
const memberStore = useMemberStore();
const trainer = computed(() => memberStore.trainer);
const isTrainerLoaded = computed(() => trainer.value !== null);

onMounted(async () => {
  try {
    const member_code = route.params.member_code;
    await memberStore.selectTrainer(member_code);
    trainer.value = { ...memberStore.trainer }; // 기존 유저 정보 복사
    isTrainerLoaded.value = true;
  } catch (error) {
    console.error("트레이너 정보를 불러오는 동안 오류가 발생했습니다:", error);
  }
});

const updateProfile = () => {
  // 사용자가 입력한 내용을 기존 유저 정보에 반영
  trainer.value = {
    id: trainer.value.id, // 아이디는 disabled 속성이므로 그대로 유지
    member_code: trainer.value.code,
    name: trainer.value.name, // 이름은 disabled 속성이므로 그대로 유지
    email: trainer.value.email,
    age: trainer.value.age,
    gender: trainer.value.gender,
    nickname: trainer.value.nickname,
    readme: trainer.value.readme,
    providePart: trainer.value.providePart,
    provideStyle: trainer.value.provideStyle,
    provideGoal: trainer.value.provideGoal,
    password: trainer.value.password,
  };

  // memberStore의 updateUser 함수를 호출하여 실제 업데이트 수행
  memberStore.updateTrainerMy(trainer.value);
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
