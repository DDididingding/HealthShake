<template>
  <div class="container w-screen">
    <div class="container-header my-12">
      <h2 class="font-bold text-3xl mb-3">매칭 가능한 유저 목록이에요.</h2>
      <p class="text-slate-600">카드를 클릭하면 아무일도 일어나지 않아요.</p>
    </div>
    <div class="popular-trainres">
      <div class="user-card-container flex flex-wrap gap-x-12 gap-y-8">
        <div
          v-for="user in users"
          :key="user.code"
          class="user-card bg-white shadow-lg flex flex-col py-6 px-12 rounded-2xl box-border cursor-pointer transition-all duration-200 hover:bg-gradient-to-r from-rose-50 to-teal-50"
        >
          <h3 class="text-2xl text-black no-underline font-bold">
            {{ user.name }}
          </h3>
          <p class="text-slate-600 mt-1">{{ user.readme }}</p>
          <div class="flex flex-row gap-12 items-center">
            <div class="image-wrapper flex-shrink-0">
              <img
                :src="user.profileImagePath"
                alt="user Profile"
                class="user-profile-image rounded-full object-cover w-28 h-28 my-6"
              />
            </div>
            <div class="flex flex-col gap-1">
              <div class="flex">
                <div class="w-40 text-slate-400">닉네임</div>
                <div class="flex-1 font-medium">{{ user.nickname }}</div>
              </div>
              <div class="flex">
                <div class="w-40 text-slate-400">여기를 죠지고 싶어요</div>
                <div class="flex-1 font-medium">
                  {{ user.prefer_part }}
                </div>
              </div>
              <div class="flex">
                <div class="w-40 text-slate-400">선호 트레이너 스타일</div>
                <div class="flex-1 font-medium">
                  {{ user.prefer_style }}
                </div>
              </div>
              <div class="flex">
                <div class="w-40 text-slate-400">운동 목표</div>
                <div class="flex-1 font-medium">
                  {{ user.prefer_goal }}
                </div>
              </div>
            </div>
          </div>
        </div>
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
const users = computed(() => memberStore.users);
const usersLoaded = computed(() => users.value.length > 0);

onMounted(() => {
  memberStore.getUserListPromise();
});
</script>
