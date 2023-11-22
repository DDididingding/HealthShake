<template>
    
    <div id="container">
      <LoginForm @login="handleLoginSuccess" />
      <header v-if="!isLoggedin"> <!-- 로그인 안된 상태의 헤더 요소 -->
      <router-link to="/home" class="nav-link" :class="{ 'active-link': $route.path === '/home' }">
        <h1>JHGPT</h1>
      </router-link>
      <router-link to="/login" class="nav-link" :class="{ 'active-link': $route.path === '/login' }">Login</router-link>
      <router-link to="/register" class="nav-link" :class="{ 'active-link': $route.path === '/register' }">Register</router-link>
      
      
      </header>

      <header v-else-if="isLoggedin && userType === 1"> <!-- 유저가 로그인 했을 때 -->
      <router-link to="/home" class="nav-link" :class="{ 'active-link': $route.path === '/home' }"><h1>JHGPT</h1></router-link>
      <router-link to="/homeUser" class="nav-link" :class="{ 'active-link': $route.path === '/homeUser' }">트레이너 맞춤 추천</router-link>
      <router-link :to="{ name: 'UserBuylist', params: { member_code: member_code } }" class="nav-link" :class="{ 'active-link': $route.name === 'UserBuylist' }">구매 목록</router-link>
      <router-link :to="{ name: 'userMypage', params: { member_code: member_code } }" class="nav-link" :class="{ 'active-link': $route.name === 'userMypage' }">userMypage</router-link>
      <button @click="handleLogout" class="nav-link">Logout</button>
      </header>

      <header v-else-if="isLoggedin && userType === 2"> <!-- 트레이너가 로그인 했을 때 -->
        <router-link :to="{ name: 'PtDetail', params: { member_code: member_code } }" class="nav-link" :class="{ 'active-link': $route.name === 'PtDetail' }">  <h1>JHGPT</h1></router-link>
        <router-link :to="{ name: 'PtDetail', params: { member_code: member_code } }" class="nav-link" :class="{ 'active-link': $route.name === 'PtDetail' }">운영중인 pt</router-link>
        <router-link :to="{ name: 'trainerMypage', params: { member_code: member_code } }" class="nav-link" :class="{ 'active-link': $route.name === 'trainerMypage' }">trainerMypage</router-link>
        <button @click="handleLogout" class="nav-link">Logout</button>
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
  import { useUserStore } from "@/stores/userStore";
import {useRouter} from "vue-router";

const router = useRouter();


  const userStore = useUserStore();

  // const logout = () => {
  //   userStore.setLogout();
  // };
  const loginMember = computed(()=>userStore.loginMember)
  


  const isLoggedin = computed(() => {
    console.log(userStore.loginMember);
    return userStore.loginMember !== null;
  });

  // userType을 computed 속성으로 정의합니다.
  const userType = computed(() => {
    return loginMember.value ? loginMember.value.member_status : "";
  });

  const member_code = computed(() => {
    return loginMember.value ? loginMember.value.member_code : "";
  });

  const handleLogout = () => {
    sessionStorage.removeItem("loginMember");
    // loginMember.value = null; // ref 값을 갱신하여 반응성을 유도합니다.
    userStore.logout();
    router.push({ name: "Home" });
  };

  //요놈이 안됨
  const handleLoginSuccess = () => {
    loginMember.value = JSON.parse(sessionStorage.getItem("loginMember"));
    console.log("너는 되고잇니?");
  };

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