<template>
  <div>
    <div class="popular-trainers" v-if="trainersLoaded">
      <div v-for="trainer in trainers" :key="trainer.code" class="trainer-card">
          <h3>{{ trainer.name }}</h3>
    
        <p>{{ trainer.readme }}</p>
        <p>
          닉네임 : 
          <!-- 트레이너 닉네임을 클릭하여 TrainerDetail 페이지로 이동 -->
          <router-link :to="{ name: 'TrainerDetail', params: { member_code: trainer.code } }">
            {{ trainer.nickname }}
          </router-link>
        </p>
      </div>
    </div>
    <div v-else>
      데이터 로딩 중...
    </div>
  </div>
</template>

<script setup>
import { useMemberStore } from "@/stores/memberStore";
import { ref, onMounted } from "vue";

const memberStore = useMemberStore();//멤버스토어 사용
const trainers = ref([]);//트레이너 리스트 반응형
const trainersLoaded = ref(false); //트레이너 리스트 로딩여부 반응형

onMounted(async () => {
  if (!memberStore.trainers.length) {
    await memberStore.getTrainerList();
  }
  trainers.value = memberStore.trainers;
  trainersLoaded.value = true;
});
</script>

<style scoped>
/* 추가적인 스타일링을 할 수 있습니다 */
.popular-trainers {
  display: flex;
  justify-content: space-around;
}

.trainer-card {
  text-align: center;
  padding: 20px;
  cursor: pointer;
  border: 1px solid #ccc;
  border-radius: 8px;
  width: 300px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* .trainer-card:hover {
  background-color: #f0f0f0;
} */
</style>
