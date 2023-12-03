<template>
  <div>
    <TheHeaderNav />
    <RouterView />
  </div>
</template>

<script setup>
import TheHeaderNav from "@/components/common/TheHeaderNav.vue";

import { onMounted } from "vue";

import { useUserStore } from "@/stores/userStore";

const userStore = useUserStore();

onMounted(()=>{
  // session Storage 검사
  if (sessionStorage.getItem("loginMember") === null) {
    // 로그인 안된 상태

  } else {
    // 로그인 정보가 있는 상황
    userStore.setLoginMember(JSON.parse(sessionStorage.getItem("loginMember")));


  }



})


</script>


<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
  font-family: "Pretendard Variable"
}

.text-center {
  text-align: center;
}
.container {
  margin: 0px 30px;
}
a {
  text-decoration: none;
}

</style>
