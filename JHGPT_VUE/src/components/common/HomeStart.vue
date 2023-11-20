<template>
<!--로그인 안한상태의 홈화면-->
  <div class="popular-trainers" v-if="trainersLoaded">
    <div class="trainer-card-container">
      <!-- 트레이너 목록에 대하여 반복-->
      <div v-for="trainer in trainers" :key="trainer.code" class="trainer-card">
        <router-link :to="{ name: 'TrainerDetail', params: { member_code: trainer.code } }"><h3>{{ trainer.name }}</h3>
        </router-link>
        <p>{{ trainer.readme }}</p>
        <p>
          닉네임 :  {{ trainer.nickname }}
        </p>
      </div>
    </div>
  </div>
  <div v-else>
    데이터 로딩 중...
  </div>
</template>

<script setup>
import { useMemberStore } from "@/stores/memberStore";
import { ref, onMounted } from "vue";

const memberStore = useMemberStore();
const trainers = ref([]);
const trainersLoaded = ref(false);

//지금은 일단 모든 트레이너 리스트 나오는중..,. 걍 일케 할까...?
onMounted(async () => {
  if (!memberStore.trainers.length) {
    await memberStore.getTrainerList();
  }
  trainers.value = memberStore.trainers;
  trainersLoaded.value = true;
});
</script>

<style scoped>
/* 수정된 스타일 */
.popular-trainers {
  display: flex;
  justify-content: center;
}

.trainer-card-container {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  justify-content: center;
  margin-top: 20px;
}

.trainer-card {
  text-align: center;
  padding: 20px;
  cursor: pointer;
  border: 1px solid #ccc;
  border-radius: 8px;
  width: 300px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  background-color: lemonchiffon;
}
</style>
