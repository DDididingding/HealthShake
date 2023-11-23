<template>
  <div>
    <h4>트레이너 프로필 수정</h4>
    <fieldset>
      <legend>수정</legend>
     <!-- 변수 설정 잘 하면 됨-->
      <div>
          <label for="name">이름 :</label>
          <input type="text" id="name" v-model="trainer.name" disabled>
        </div>
        <div>
          <label for="email">이메일 :</label>
          <input type="text" id="email" v-model="trainer.email">
        </div>
        <div>
          <label for="age">나이 :</label>
          <input type="number" id="age" v-model="trainer.age">
        </div>
        <div>
          <label class="form-label">성별:</label>
          <div>
            <label>
              <input type="radio" v-model="trainer.gender" value="male"> 남성
            </label>
            <label>
              <input type="radio" v-model="trainer.gender" value="female"> 여성
            </label>
          </div>
        </div>
        <div>
          <label for="nickname">닉네임:</label>
          <input type="text" id="nickname" v-model="trainer.nickname">
        </div>
      <div>
        <label for="providePart">제공하는 부위 :</label>
        <input type="text" id="providePart" v-model="providePart" />
      </div>
      <div>
        <label for="provideStyle">제공하는 스타일 :</label>
        <input type="text" id="provideStyle" v-model="provideStyle" />
      </div>
      <div>
        <label for="provideGoal">제공하는 목표 :</label>
        <input type="text" id="provideGoal" v-model="provideGoal" />
      </div>
      <div>
        <label for="trainerReadme">트레이너 소개 :</label>
        <textarea
          id="trainerReadme"
          v-model="trainerReadme"
          rows="4"
        ></textarea>
      </div>
      <div>
        <button @click="updateTrainer">수정</button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useMemberStore } from "@/stores/memberStore";
import { useRoute } from "vue-router";
import router from "@/router";
import axios from 'axios';
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
