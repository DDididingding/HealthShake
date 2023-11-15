<template>
    <div id="container">
      <header>
        <div class="brand">
          <h1>JHGPT</h1>
        </div>
        <nav>
          <router-link to="/login" class="nav-link" :class="{ 'active-link': $route.path === '/login' }">Login</router-link>
          <router-link to="/register" class="nav-link" :class="{ 'active-link': $route.path === '/register' }">Register</router-link>
          <router-link to="/mypage" class="nav-link" :class="{ 'active-link': $route.path === '/mypage' }">My Page</router-link>
        </nav>
      </header>
    </div>
  </template>
  
  <style scoped>
  #container {
    text-align: center;
  }
  
  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px;
    background-color: #3498db; /* 푸른 계열의 배경 색상 */
    color: #fff; /* 흰색 텍스트 */
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
    color: #1d3ac8; /* 선택된 항목은 다른 색으로 강조 */
  }
  </style>
  