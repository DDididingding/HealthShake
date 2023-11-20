<template>
    <div id="container">
      <header v-if="!getUser"> <!-- 로그인 안된 상태의 헤더 요소 -->
      <router-link to="/home" class="nav-link" :class="{ 'active-link': $route.path === '/home' }">
        <h1>JHGPT</h1>
      </router-link>
       <router-link to="/reviewregist" class="nav-link" :class="{ 'active-link': $route.path === '/review_regist' }">테스트용리뷰등록</router-link>
      <router-link to="/login" class="nav-link" :class="{ 'active-link': $route.path === '/login' }">Login</router-link>
      <router-link to="/register" class="nav-link" :class="{ 'active-link': $route.path === '/register' }">Register</router-link>
      <router-link to="/reviewList" class="nav-link" :class="{ 'active-link': $route.path === '/reviewList' }">reviewList</router-link>
      <router-link to="/trainerMypage" class="nav-link" :class="{ 'active-link': $route.path === '/trainerMypage' }">trainerMypage</router-link>
      <router-link to="/userMypage" class="nav-link" :class="{ 'active-link': $route.path === '/userMypage' }">userMypage</router-link>
      </header>

    <header v-else-if="getUser && userType === 'user'"> <!-- 유저가 로그인 했을 때 -->
      <router-link to="/homeUser" class="nav-link" :class="{ 'active-link': $route.path === '/homeUser' }">
        <h1>JHGPT</h1>
      </router-link>
      <router-link to="/userBuylist" class="nav-link" :class="{ 'active-link': $route.path === '/userBuylist' }">구매 목록</router-link>
      <router-link to="/userMypage" class="nav-link" :class="{ 'active-link': $route.path === '/userMypage' }">My Page</router-link>
    </header>

    <header v-else-if="getUser && userType === 'trainer'"> <!-- 트레이너가 로그인 했을 때 -->
      <router-link to="/ptDetail" class="nav-link" :class="{ 'active-link': $route.path === '/ptDetail' }">
        <h1>JHGPT</h1>
      </router-link>
      <router-link to="/trainerMypage" class="nav-link" :class="{ 'active-link': $route.path === '/trainerMypage' }">My Page</router-link>
      <router-link to="/ptDetail" class="nav-link" :class="{ 'active-link': $route.path === '/ptDetail' }">운영중인 pt</router-link>
        <!--이 밑으로는 테스트 용-->
        <!-- <nav> -->
          <!-- <router-link to="/boardregist" class="nav-link" :class="{ 'active-link': $route.path === '/board_regist' }">테스트용임보드등록</router-link>
           <router-link to="/reviewregist" class="nav-link" :class="{ 'active-link': $route.path === '/review_regist' }">테스트용리뷰등록</router-link>
          <router-link to="/reviewregist" class="nav-link" :class="{ 'active-link': $route.path === '/review_regist' }">테스트용리뷰등록</router-link>
          <router-link to="/trainerRegist" class="nav-link" :class="{ 'active-link': $route.path === '/trainer_regist' }">트레이너등록</router-link>
          <router-link to="/trainerMypage" class="nav-link" :class="{ 'active-link': $route.path === '/trainer_mypage' }">트레이너마이페이지</router-link>
          <router-link to="/trainerDetail" class="nav-link" :class="{ 'active-link': $route.path === '/trainer_Detail' }">트레이너디테일</router-link>
          <router-link to="/ptDetail" class="nav-link" :class="{ 'active-link': $route.path === '/ptDetail' }">피티디테일</router-link>
          <router-link to="/videoDetail" class="nav-link" :class="{ 'active-link': $route.path === '/videoDetail' }">비디오디테일</router-link>
          <router-link to="/videoList" class="nav-link" :class="{ 'active-link': $route.path === '/videoList' }">비디오리스트</router-link> -->
       <!-- </nav> -->
      </header>
    </div>
  </template>
  
  <script setup>
  import { ref, computed } from "vue";
  // import { useUserStore } from "@/stores/userStore";

  // const userStore = useUserStore();

  // const logout = () => {
  //   userStore.setLogout();
  // };

  // const getUser = computed(() => (userStore.loginUser ? true : false));
</script>

  <style scoped>
  #container {
    text-align: center;
  }

  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px;
    background-color: mediumaquamarine; 
    color: #fff; /*흰색 텍스트*/
  }

  .brand h1 {
    margin: 0;
    font-size: 24px;
  }

  nav {
    display: flex;
  }

  .nav-link {
    font-weight: bold;
    text-decoration: none;
    color: #fff; /* 흰색 텍스트 */
    margin-left: 20px; /* 링크 간격 조절 */
    font-size: 18px;
    transition: color 0.3s ease;
  }

  .nav-link:hover {
    color: #a4a4a4; /* 마우스 호버 시 더 연한 색으로 변경 */
  }

  .active-link {
    color: yellow; /* 선택된 항목은 다른 색으로 강조 */
  }
  </style>