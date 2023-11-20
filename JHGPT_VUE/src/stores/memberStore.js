// stores/userStore.js
import { ref } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from 'axios';

export const useMemberStore = defineStore("member", () => {
  
  const members = ref([]);

  const getMemberList = (() => {
    axios
      .get("http://localhost:9999/api/member")
      .then((resp) => {
        console.log("멤버 목록 가져오기 성공");
        members.value = resp.data
        console.log(members.value);
      })
      .catch(() => {
        console.log("멤버 목록 가져오기 실패");
      })
  })

  const users = ref([]);

  const getUserList = (() => {
    axios
      .get("http://localhost:9999/api/user")
      .then((resp) => {
        console.log("유저 목록 가져오기 성공");
        users.value = resp.data
        console.log(users.value);
      })
      .catch(() => {
        console.log("유저 목록 가져오기 실패");
      })
  })

  const trainers = ref([]);

  const getTrainerList = (() => {
    axios
      .get("http://localhost:9999/api/trainer")
      .then((resp) => {
        console.log("트레이너 목록 가져오기 성공");
        const responseData = resp.data;

        trainers.value = responseData.map(item => ({
          code : item.member_code,
          id : item.member_id,
          name : item.member_name,
          nickname : item.member_nickname,
          readme : item.trainer_readme,
        }))

        console.log(trainers.value);
      })
      .catch(() => {
        console.log("트레이너 목록 가져오기 실패");
      })
  })

  const user = ref(null);

  const selectUser = ((member_code) => {
    axios
      .get(`http://localhost:9999/api/member/${member_code}`)
      .then((resp) => {
        console.log("유저 선택 성공")
        user.value = resp.data
      })
      .catch(() => {
        console.log("유저 선택 실패");
      })
  })

  const trainer = ref(null);

  const selectTrainer = ((member_code) => {
    axios
      .get(`http://localhost:9999/api/trainer/${member_code}`)
      .then((resp) => {
        console.log("트레이너 선택 성공")
        const responseData = resp.data;

        trainer.value = {
        code: responseData.member_code,
        id: responseData.member_id,
        name: responseData.member_name,
        nickname: responseData.member_nickname,
        readme: responseData.trainer_readme,
        };
      })
      .catch(() => {
        console.log("트레이너 선택 실패");
      })
  })

  //회원가입
  const userSignup = ((user) => {
    axios
      .post(`http://localhost:9999/api/signup/user`)
      .then(() => {
            console.log("createUser 성공");
            router.push({ name: "Home" })
        })
        .catch(() => {
            console.log("createUser 실패");
        })
  })

  const trainerSignup = ((trainer) => {
    axios
      .post("http://localhost:9999/api/signup/trainer")
      .then(() => {
            console.log("createTrainer 성공");
            router.push({ name: "Home" })
        })
        .catch(() => {
            console.log("createTrainer 실패");
        })
  })

  const updateTrainerMy = (() => {
    axios
      .put("")//수정 링크
      .then(() => {
        router.push({name: 'trainerMy'})
      })

  })

  const updateUserMy = (() => {
    axios
      .put("")//수정 링크
      .then(() => {
        router.push({name: 'trainerMy'})
      })
  })

  // 로그인
  const setLoginMember = async (inputMember) => {
    console.log("로그인 시도", inputMember);
    try {
      const resp = await axios.post("http://localhost:9999/api/login/", inputMember);
  
      const responseMember = resp.data;

      if (responseMember !== null) {
        if (responseMember.member_password === inputMember.member_password) {
          console.log("로그인 성공");
          // loginMember.value = responseMember;
          router.push({ name: "Home" });
          return true; // 로그인 성공을 나타냄
        } else {
          alert("비밀번호가 올바르지 않습니다");
        }
      } else {
        alert("존재하지 않는 아이디입니다");
      }
    } catch (error) {
      console.log("로그인 실패", error);
    }
  
    return false; // 로그인 실패를 나타냄
  };
  


  //로그아웃 추후 구현

  //수정 추후 구현

  //멤버 삭제

  return {users, user, setLoginMember, getMemberList, getTrainerList, getUserList, updateTrainerMy, updateUserMy, trainerSignup, trainers, trainer, userSignup, selectTrainer, selectUser}
}, { persist: true });
