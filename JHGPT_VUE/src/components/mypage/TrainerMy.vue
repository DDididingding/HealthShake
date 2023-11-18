<template>
    <div class="trainer-mypage">
       <h1>트레이너 마이페이지</h1>
       
        <div v-if="isTrainerLoaded && trainer" class="trainer-info">
      <div class="profile">
        <div class="profile-section">
          <h2>프로필</h2>
          <p><strong>이름:</strong> {{ trainer.name }}</p>
          <p><strong>닉네임:</strong> {{ trainer.nickname }}</p>
          <p><strong>소개:</strong> {{ trainer.readme }}</p>
        </div>
        <!--수정 버튼-->

        <hr>

        <!--비디오리스트-->
        <div class ="videos">
          <h2>비디오리스트</h2>
        

        <!--내가 작성한 글-->
       

        <!--서비스 소개 수정-->


      </div>
        </div>
    </div>
    </div>
  
  </template>
  
  <script setup>
  import { useMemberStore } from "@/stores/memberStore";
  import { ref, onMounted } from "vue";
  import { useRoute } from "vue-router";

  const memberStore = useMemberStore();
  const route = useRoute();
  const trainer = ref(null);
  const isTrainerLoaded = ref(false);  



  </script>
  
  <style scoped>
  .trainer-profile {
    max-width: 600px;
    margin: auto;
    text-align: center;
  }
  
  .profile-header {
    padding: 20px;
  }
  
  .profile-picture {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    object-fit: cover;
    margin-bottom: 10px;
  }
  
  .video-list {
    margin-top: 20px;
  }
  
  ul {
    list-style: none;
    padding: 0;
  }
  
  li {
    border: 1px solid #ddd;
    padding: 10px;
    margin-bottom: 10px;
  }
  </style>
  