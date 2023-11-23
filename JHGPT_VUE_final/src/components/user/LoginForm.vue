<template>
  <div class="container text-center flex flex-col items-center my-12 gap-6">
    <h2 class="font-bold text-xl">로그인</h2>
    <fieldset class="form-group flex flex-col gap-4">
      <div class="input-group">
        <label for="id" class="w-24 inline-block">아이디</label>
        <input type="text" id="id" v-model="id" class="form-control p-2 rounded-xl border border-slate-200 border-2" />
      </div>
      <div class="input-group">
        <label for="password" class="w-24 inline-block">비밀번호</label>
        <input type="password" id="password" v-model="password" class="form-control p-2 rounded-xl border border-slate-200 border-2" />
      </div>
      <button class="bg-gradient-to-r from-rose-400 via-fuchsia-500 to-indigo-500 p-3 rounded-xl text-white font-bold mt-4" @click="handleLogin">로그인</button>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useMemberStore } from "@/stores/memberStore";
import { useUserStore } from "@/stores/userStore";
import { onMounted } from "vue";
import { useRouter } from "vue-router";

const memberStore = useMemberStore();
const userStore = useUserStore();
const router = useRouter();

const id = ref("");
const password = ref("");

const handleLogin = async () => {
  console.log("id: ", id.value);
  console.log("password: ", password.value);

  try {
    const loginResult = await memberStore.setLoginMember({
      member_id: id.value,
      member_password: password.value,
    });

    // Check the result and handle accordingly
    if (loginResult) {
      console.log("로그인 성공");
      sessionStorage.setItem("loginMember", JSON.stringify(loginResult));
      userStore.setLoginMember(loginResult);

      alert("환영합니다!");
    } else {
      // Login failed, you can display an error message or perform other actions
      console.log("로그인 실패!");
    }
  } catch (error) {
    console.error("로그인 에러:", error);
  }
};
</script>
