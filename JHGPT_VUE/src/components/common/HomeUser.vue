<template>
<!--로그인 한 상태의 유저 홈화면 -->
<div class="prefer-trainers" v-if="isTrainerLoaded">
<h1>추천 트레이너</h1>
    <div class="trainer-card-container">
      <div v-for="trainer in trainers" :key="trainer.code" class="trainer-card">
        <router-link :to="{ name: 'TrainerDetail', params: { member_code: trainer.code } }"><h3>{{ trainer.name }}</h3>
        </router-link>
        <p>트레이너 소개글 : {{ trainer.readme }}</p>
        <p>
          닉네임 :  {{ trainer.nickname }}
        </p>
        <p>제공 부위(?) : {{ trainer.provide_part }}</p>
        <p>제공 스타일 : {{ trainer.provide_style }}</p>
        <p>제공 목표 : {{ trainer.provide_goal }}</p>
      </div>
    </div>
  </div>
  <div v-else>
    데이터 로딩 중...
  </div>
</template>

<script setup>
import { useMemberStore } from "@/stores/memberStore";
import { useUserStore } from "@/stores/userStore";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import { computed } from "vue";

const route = useRoute();
const memberStore = useMemberStore();
const trainers = computed(() => memberStore.trainers);

const isTrainerLoaded = ref(false);

onMounted(async () => {
    try{
      const sessionMember = JSON.parse(sessionStorage.getItem('loginMember'));
    
    if (sessionMember) {
      const member_code = sessionMember.member_code;
      
      await memberStore.getPreferTrainerListPromise(member_code);
    
      isTrainerLoaded.value = trainers.value !== null;

    } else {
      console.error('로그인된 사용자 정보가 없습니다.');
    }
  } catch (error) {
    console.error("트레이너 정보를 불러오는 동안 오류가 발생했습니다:", error);
  }

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
