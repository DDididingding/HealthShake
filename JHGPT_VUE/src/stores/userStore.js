import { defineStore } from "pinia";


export const useUserStore = defineStore({
    id: 'user',
    state: () => ({
      loginMember: null,
    }),
    getters: {
      isLoggedIn: (state) => !!state.loginMember,
      userType: (state) => (state.loginMember ? state.loginMember.member_status : null),
    },
    actions: {
      setLoginMember(responseMember) {
        this.loginMember = responseMember;
      },
      logout() {
        this.loginMember = null;
        sessionStorage.removeItem('loginMember');
      },
    },
  });