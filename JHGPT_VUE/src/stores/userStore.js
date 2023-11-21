import { ref, computed } from 'vue';
import axios from 'axios';
import { defineStore } from "pinia";
import router from "@/router";
import { useRoute } from 'vue-router';



export const useUserStore = defineStore('user', ()=>{
  const loginMember = ref(null);
  const isLoggedIn = computed(()=> loginMember.value !== null);
  const member_code = computed(()=> loginMember.value.member_status);
  const route = useRoute();

  const setLoginMember = (responseMember) => {
    axios
    .post('http://localhost:9999/api/login', responseMember)
    .then((resp)=>{
      console.log('로그인 성공');
      loginMember.value = resp.data;
      member_code.value = loginMember.member_status;
      sessionStorage.setItem('loginMember', JSON.stringify(resp.data));
    })
    .catch(()=>{
      console.log('로그인 실패');
    })
  } 

  const setLoginMemberCode = (responseMember) => {
    axios
    .post('http://localhost:9999/api/login', responseMember)
    .then((resp)=>{
      console.log('로그인 성공');
      member_code.value = resp.data.member_status;
      sessionStorage.setItem('member_code', loginMember.member_status);
    })
    .catch(()=>{
      console.log('로그인 실패');
    })
  }

  const logout = () => {
    loginMember.value = null;
    sessionStorage.removeItem('loginMember');
  }

  return {
    loginMember,
    isLoggedIn,
    member_code,
    setLoginMember,
    setLoginMemberCode,
    logout,
  
  }
});