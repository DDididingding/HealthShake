import { createRouter, createWebHistory } from 'vue-router'
import Login from '@/components/user/LoginForm.vue'
import Register from '@/components/user/RegistPage.vue'
import Mypage from '@/components/mypage/UserMypage.vue'
import TrainerRegist from '@/components/trainer/TrainerRegist.vue'
import UserRegist from '@/components/user/UserRegist.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:'/login',
      name:'Login',
      component: Login
    },
    {
      path:'/register',
      name:'Register',
      component: Register
    },
    {
      path:'/mypage',
      name:'Mypage',
      component: Mypage
    },
    {
      path:'/trainerRegist',
      name:'TrainerRegist',
      component: TrainerRegist
    },
    {
      path:'/userRegist',
      name:'UserRegist',
      component: UserRegist
    }

    
  ]
})

export default router
