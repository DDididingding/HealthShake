<template>
  <div class="container w-screen">
    <div class="container-header my-12">
      <h2 class="font-bold text-3xl mb-3">
        구독하고 있는 트레이너 목록이에요.
      </h2>
      <p class="text-slate-600">카드를 클릭하면 상세 페이지로 이동해요.</p>
    </div>
    <div class="trainer-card-container flex flex-wrap gap-x-12 gap-y-8">
      <div
        v-for="trainer in trainers"
        :key="trainer.code"
        class="trainer-card bg-white shadow-lg flex flex-col py-6 px-12 rounded-2xl box-border cursor-pointer transition-all duration-200 hover:bg-gradient-to-r from-rose-50 to-teal-50"
        @mouseover="onMouseOver(trainer)"
        @mouseleave="onMouseLeave(trainer)"
        :class="{ 'selected-card': selectedTrainer === trainer }"
      >
        <router-link
          :to="{ name: 'TrainerDetail', params: { member_code: trainer.code } }"
          ><h3 class="text-2xl text-black no-underline font-bold">
            {{ trainer.name }}
          </h3>

          <p class="text-slate-600 mt-1">{{ trainer.readme }}</p>
          <div class="flex flex-row gap-12 items-center">
            <div class="image-wrapper flex-shrink-0">
              <img
                :src="trainer.profileImagePath"
                alt="Trainer Profile"
                class="trainer-profile-image rounded-full object-cover w-28 h-28 my-6"
              />
            </div>
            <div class="flex flex-col gap-1">
              <div class="flex">
                <div class="w-40 text-slate-400">닉네임</div>
                <div class="flex-1 font-medium">{{ trainer.nickname }}</div>
              </div>
              <div class="flex">
                <div class="w-40 text-slate-400">여기를 죠져드릴게요</div>
                <div class="flex-1 font-medium">{{ trainer.provide_part }}</div>
              </div>
              <div class="flex">
                <div class="w-40 text-slate-400">트레이너 스타일</div>
                <div class="flex-1 font-medium">
                  {{ trainer.provide_style }}
                </div>
              </div>
              <div class="flex">
                <div class="w-40 text-slate-400">운동 목표</div>
                <div class="flex-1 font-medium">{{ trainer.provide_goal }}</div>
              </div>
            </div>
          </div>
        </router-link>
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
const trainersLoaded = computed(() => {
  console.log(trainers.value.length);
  return trainers.value.length > 0;
});

onMounted(() => {
  const member_code = route.params.member_code;

  try {
    memberStore.getBuyListPromise(member_code);
  } catch (error) {
    console.error("Failed to fetch trainer list:", error);
  }
});
</script>
