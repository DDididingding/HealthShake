<template>
  <div class="container">
    <h2>구독한 트레이너 목록</h2>
    <div class="trainer-card-container">
      <div v-for="trainer in trainers" :key="trainer.code" class="trainer-card" @mouseover="onMouseOver(trainer)" @mouseleave="onMouseLeave(trainer)" :class="{ 'selected-card': selectedTrainer === trainer }">
        <router-link :to="{ name: 'TrainerDetail', params: { member_code: trainer.code } }"><h3>{{ trainer.name }}</h3>
        </router-link>
        <img :src="trainer.profileImagePath" alt="Trainer Profile" class="trainer-profile-image">
        <table class="trainer-table">
            <tbody>
              <tr>
                <td>트레이너 소개글</td>
                <td>{{ trainer.readme }}</td>
              </tr>
              <tr>
                <td>닉네임</td>
                <td>{{ trainer.nickname }}</td>
              </tr>
              <tr>
                <td>제공 부위(?)</td>
                <td>{{ trainer.provide_part }}</td>
              </tr>
              <tr>
                <td>제공 스타일</td>
                <td>{{ trainer.provide_style }}</td>
              </tr>
              <tr>
                <td>제공 목표</td>
                <td>{{ trainer.provide_goal }}</td>
              </tr>
            </tbody>
          </table>
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

.trainer-card:hover {
  transform: scale(1.1); /* 호버 상태에서 카드 크기를 조정합니다. */
  background-color: lightblue; /* 호버 상태에서 카드 배경 색상을 변경합니다. */
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2); /* 호버 상태에서 그림자 효과를 추가합니다. */
  z-index: 1; /* 호버 상태에서 다른 카드 위에 표시합니다. */
  transition: transform 0.3s ease, background-color 0.3s ease, box-shadow 0.3s ease; /* 애니메이션 속성을 추가합니다. */
}

.trainer-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 10px;
}

.trainer-table td {
  border: 1px solid #ccc;
  padding: 8px;
}
</style>
