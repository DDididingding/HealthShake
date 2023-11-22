<template>
  <div class="container">
    <h2>구매한 트레이너 목록</h2>
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
</template>

<script setup>
import { useMemberStore } from "@/stores/memberStore";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import { computed } from "vue";

const route = useRoute();
const memberStore = useMemberStore();
const trainers = computed(() => memberStore.trainers);
const trainersLoaded = computed(() =>{
  console.log(trainers.value.length);
  return trainers.value.length > 0;
});

onMounted( () => {
  const member_code = route.params.member_code;

  try {
    memberStore.getBuyListPromise(member_code);
  } catch (error) {
    console.error("Failed to fetch trainer list:", error);
  }
});

</script>

<style scoped>
.container {
  padding: 20px;
}

.trainer-list {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

ul {
  list-style: none;
  padding: 0;
}

li {
  margin-bottom: 20px;
  border: 1px solid #eee;
  padding: 10px;
  border-radius: 5px;
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
