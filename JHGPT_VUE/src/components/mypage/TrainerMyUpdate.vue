<template>
  <div>
    <h4>트레이너 프로필 수정</h4>
    <fieldset>
      <legend>수정</legend>
      <div>
        <label for="id">아이디 :</label>
        <input
          type="text"
          id="id"
          v-model="memberStore.trainer.member_id"
          disabled
        />
      </div>
      <!-- <div>
          <label for="password">비밀번호 :</label>
          <input type="password" id="password" v-model="memberStore.user.member_password">
        </div>
        <div class="mb-3">
          <label for="password2">비밀번호 확인:</label>
          <input type="password" id="password2" v-model="password2" class="form-control" required />
        </div> -->
      <!-- ... 이전의 나머지 코드들 ... -->
      <!-- 추가된 부분 -->
      <div>
        <label class="form-label">성별:</label>
        <div>
          <label>
            <input
              type="radio"
              v-model="memberStore.user.gender"
              value="male"
            />
            남성
          </label>
          <label>
            <input
              type="radio"
              v-model="memberStore.user.gender"
              value="female"
            />
            여성
          </label>
        </div>
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
        <label for="trainerPrice">트레이너 비용 :</label>
        <input type="number" id="trainerPrice" v-model="trainerPrice" />
      </div>
      <div>
        <button @click="updateTrainer">수정</button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useMemberStore } from "@/stores/memberStore";

const memberStore = useMemberStore();

// 추가된 변수들
const trainer = ref(null);
const member_code = route.params.member_code;
await memberStore.selectTrainer(member_code);

const password2 = ref("");
const providePart = ref("");
const provideStyle = ref("");
const provideGoal = ref("");
const trainerReadme = ref("");
const trainerPrice = ref(0);
const gender = ref("");
// 아이디, 비밀번호 추가
const id = ref("");
const password = ref("");

trainer.value = memberStore.trainer;
providePart.value = trainer.providePart;
provideStyle.value = trainer.provideStyle;
provideGoal.value = trainer.provideGoal;
trainerReadme.value = trainer.trainerReadme;
trainerPrice.value = trainer.trainerPrice;

const updateTrainer = () => {
  if (memberStore.user.member_password !== password2.value) {
    alert("비밀번호가 일치하지 않습니다.");
    return;
  }

  const updatedTrainerProfile = {
    id: id.value,
    password: password.value,
    providePart: providePart.value,
    provideStyle: provideStyle.value,
    provideGoal: provideGoal.value,
    trainerReadme: trainerReadme.value,
    trainerPrice: trainerPrice.value,
    gender: gender.value,
  };

  memberStore.updateTrainer(updatedTrainerProfile);
};
</script>
