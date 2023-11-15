<template>
  <div>
    <TheHeaderNav />
    <Home />
    <RouterView/>
    
    
  </div>
</template>

<script setup>
  import TheHeaderNav from "@/components/common/TheHeaderNav.vue"
  import Home from "@/components/common/Home.vue"

  const showHomePage = false; // 처음에는 메인 페이지를 표시

  // 라우터를 클릭하면 메인 페이지를 숨김
  const handleRouterClick = () => {
    showHomePage.value = true;
  };
</script>

<style scoped>

</style>