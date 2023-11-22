// stores/userStore.js
import { ref } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from 'axios';
import { useUserStore } from "@/stores/userStore";

import { useRoute } from "vue-router";

export const useMemberStore = defineStore("member", () => {
  
  const members = ref([]);
  const route = useRoute();

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

  const getMemberListPromise = () => {
    return new Promise((resolve, reject) => {
      axios
        .get("http://localhost:9999/api/member")
        .then((resp) => {
          console.log("멤버 목록 가져오기 성공");
          members.value = resp.data;
          console.log(members.value);
          resolve();
        })
        .catch((error) => {
          console.log("멤버 목록 가져오기 실패", error);
          reject();
        });
    });
  };

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
        trainers.value = resp.data;

        // trainers.value = responseData.map(item => ({
        //   code : item.member_code,
        //   id : item.member_id,
        //   name : item.member_name,
        //   nickname : item.member_nickname,
        //   readme : item.trainer_readme,
        // }))

        console.log(trainers.value);
      })
      .catch(() => {
        console.log("트레이너 목록 가져오기 실패");
      })
  })

  const getTrainerListPromise = () => {
    return new Promise((resolve, reject) => {
      trainers.value = [];
      axios
        .get("http://localhost:9999/api/trainer")
        .then((resp) => {
          console.log("트레이너 목록 가져오기 성공");
          const responseData = resp.data;
  
          trainers.value = responseData.map((item) => ({
            code: item.member_code,
            id: item.member_id,
            name: item.member_name,
            nickname: item.member_nickname,
            readme: item.trainer_readme,
          }));
  
          console.log(trainers.value);
          resolve();
        })
        .catch(() => {
          console.log("트레이너 목록 가져오기 실패");
          reject();
        });
    });
  };

  const getPreferTrainerListPromise = (member_code) => {
    return new Promise((resolve, reject) => {
      trainers.value = [];
      axios
        .get(`http://localhost:9999/api/prefer/${member_code}`)
        .then((resp) => {
          console.log("트레이너 목록 가져오기 성공");
          const responseData = resp.data;
  
          trainers.value = responseData.map((item) => ({
            code: item.member_code,
            id: item.member_id,
            name: item.member_name,
            nickname: item.member_nickname,
            readme: item.trainer_readme,
            provide_part : item.provide_part,
            provide_style : item.provide_style,
            provide_goal : item.provide_goal,
          }));
  
          console.log(trainers.value);
          resolve();
        })
        .catch(() => {
          console.log("트레이너 목록 가져오기 실패");
          reject();
        });

    });
  };

  //멤버가 구매한 트레이너리스트
  const getBuyList = ((member_code) => {
    axios
      .get(`http://localhost:9999/api/userbuylist/${member_code}`)
      .then((resp) => {
          console.log("구매 목록 가져오기 성공");
          const responseData = resp.data

          trainers.value = responseData.map(item => ({
          code : item.member_code,
          id : item.member_id,
          name : item.member_name,
          nickname : item.member_nickname,
          readme : item.trainer_readme,
          provide_part : item.provide_part,
          provide_style : item.provide_style,
          provide_goal : item.provide_goal,
        }))
        })
        .catch(() => {
            console.log("구매 목록 가져오기 실패");
        })
  })

  const getBuyListPromise = (member_code) => {
    return new Promise((resolve, reject) => {
      axios
        .get(`http://localhost:9999/api/userbuylist/${member_code}`)
        .then((resp) => {
          console.log("구매 목록 가져오기 성공");
          const responseData = resp.data;
  
          trainers.value = responseData.map((item) => ({
            code: item.member_code,
            id: item.member_id,
            name: item.member_name,
            nickname: item.member_nickname,
            readme: item.trainer_readme,
            provide_part: item.provide_part,
            provide_style: item.provide_style,
            provide_goal: item.provide_goal,
          }));
  
          resolve();
        })
        .catch((error) => {
          console.log("구매 목록 가져오기 실패", error);
          reject();
        });
    });
  };

  const user = ref(null);

  const selectUser = ((member_code) => {
    axios
      .get(`http://localhost:9999/api/user/${member_code}`)
      .then((resp) => {
        console.log("유저 선택 성공")
        const responseData = resp.data;
        
        user.value = {
          code: responseData.member_code,
          id: responseData.member_id,
          name: responseData.member_name,
          nickname: responseData.member_nickname,
          readme: responseData.user_readme,
          age : responseData.member_age,
          password : responseData.member_password,
          preferPart: responseData.prefer_part,
          preferGoal: responseData.prefer_goal,
          preferGender: responseData.prefer_gender,
          preferStyle: responseData.prefer_style,

          };

        

      })
      .catch(() => {
        console.log("유저 선택 실패");
        
      })
  })

  const selectUserPromise = ((member_code) => {
    return new Promise((resolve, reject)=>{
      axios
      .get(`http://localhost:9999/api/user/${member_code}`)
      .then((resp) => {
        console.log("유저 선택 성공")
        const responseData = resp.data;
        
        user.value = {
          code: responseData.member_code,
          id: responseData.member_id,
          name: responseData.member_name,
          nickname: responseData.member_nickname,
          readme: responseData.user_readme,
          age : responseData.member_age,
          gender : responseData.member_gender,
          password : responseData.member_password,
          preferPart: responseData.prefer_part,
          preferGoal: responseData.prefer_goal,
          preferGender: responseData.prefer_gender,
          preferStyle: responseData.prefer_style,

          };
          resolve();

      })
      .catch(() => {
        console.log("유저 선택 실패");
        reject();
      })
      
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

  const selectTrainerPromise = (member_code) => {
    return new Promise((resolve, reject) => {
      axios
        .get(`http://localhost:9999/api/trainer/${member_code}`)
        .then((resp) => {
          console.log("트레이너 선택 성공");
          const responseData = resp.data;
  
          trainer.value = {
            code: responseData.member_code,
            id: responseData.member_id,
            name: responseData.member_name,
            nickname: responseData.member_nickname,
            readme: responseData.trainer_readme,
          };
  
          resolve();
        })
        .catch(() => {
          console.log("트레이너 선택 실패");
          reject();
        });
    });
  };


  //회원가입
  const userSignup = ((user) => {
    console.log(user);

    axios
      //유저를 json형식으로 보내기
      .post(`http://localhost:9999/api/signup/user`, user)
      .then(() => {
            console.log("createUser 성공");
            alert("회원가입이 완료되었습니다.");
            router.push({ name: "Home"});
        })
        .catch(() => {
            console.log("createUser 실패");
        })
  })

  const trainerSignup = ((trainer) => {
    axios
      .post("http://localhost:9999/api/signup/trainer", trainer)
      .then(() => {
            alert("회원가입이 완료되었습니다.");
            console.log("createTrainer 성공");
            router.push({ name: "Home" })
        })
        .catch(() => {
            console.log("createTrainer 실패");
        })
  })

  const updateTrainerMy = ((trainer) => {
    const member_code = trainer.member_code;
    axios
      .put(`http://localhost:9999/api/trainer/${member_code}/update`)//수정 링크
      .then(() => {
          console.log("updateTrainer 성공");
          router.push({ name: "trainerMypage" })
      })
      .catch(() => {
            console.log("updateUser 실패");
        })

  })

  const updateUserMy = ((user) => {
    console.log('update user my')
    console.log(user);
    const member_code = route.params.member_code;
    console.log(member_code)

    axios
      .put(`http://localhost:9999/api/user/${member_code}/update`, user)//수정 링크
      .then(() => {
          console.log("updateUser 성공");
          router.push({ name: "userMypage" })
      })
      .catch(() => {
            console.log("updateUser 실패");
        })
  })

  // 로그인
  const setLoginMember = async (inputMember) => {
    console.log("로그인 시도", inputMember);
    try {
        const userStore = useUserStore();
        const resp = await axios.post("http://localhost:9999/api/login/", inputMember);

        const responseMember = resp.data;

        return new Promise((resolve, reject) => {
            if (responseMember !== null) {
                if (responseMember.member_password === inputMember.member_password) {
                    userStore.setLoginMember(responseMember);
                    userStore.setLoginMemberCode(responseMember);

                    sessionStorage.setItem("loginMember", JSON.stringify(responseMember));

                    const memberStatus = responseMember.member_status;

                    if (memberStatus === 1) {
                        router.push({ name: "Home" });
                    } else if (memberStatus === 2) {
                        router.push({ name: "PtDetail", params: { member_code: responseMember.member_code } });
                    }

                    resolve(true); // Resolve with true indicating successful login
                } else {
                    reject("비밀번호가 올바르지 않습니다");
                }
            } else {
                reject("존재하지 않는 아이디입니다");
            }
        });
    } catch (error) {
        console.log("로그인 실패", error);
        return Promise.reject("로그인 실패"); // Reject with an error message
    }
};
  

  return {getPreferTrainerListPromise, users, user, setLoginMember, getMemberList, getMemberListPromise, getTrainerList, getTrainerListPromise, getUserList, updateTrainerMy, updateUserMy, trainerSignup, selectTrainerPromise, trainers, trainer, userSignup, selectTrainer, selectUser, selectUserPromise, getBuyList, getBuyListPromise}
}, { persist: true });
