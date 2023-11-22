import { ref } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from 'axios'

//1117 수정

export const useBoardStore = defineStore('board', () => {
    
    const boards = ref([])

    const BoardListByMember = ((member_code) => {
        axios
        .get(`http://localhost:9999/api/board/${member_code}`)
        .then((resp) => {
            console.log("게시물 목록 가져오기 성공");
            const responseData = resp.data

            boards.value = responseData.map(item => ({
                writercode : item.board_uploader,
                code : item.board_code,
                title : item.board_title,
                uploadtime : item.board_uploadtime,
                content : item.board_content,
                viewcnt : item.board_viewcnt,
            }))
        })
        .catch(() => {
            console.log("게시물 목록 가져오기 실패");
        })
    })

    const boardList = ref([])

    const BoardListByMemberPromise = (member_code) => {
        return new Promise((resolve, reject) => {
          axios
            .get(`http://localhost:9999/api/board/writer/${member_code}`)
            .then((resp) => {
              console.log("게시물 목록 가져오기 성공");
              const responseData = resp.data;
      
              boardList.value = responseData.map((item) => ({
                writercode: item.board_uploader,
                code: item.board_code,
                title: item.board_title,
                uploadtime: item.board_uploadtime,
                content: item.board_content,
                viewcnt: item.board_viewcnt,
              }));
      
              resolve();
            })
            .catch((error) => {
              console.log("게시물 목록 가져오기 실패", error);
              reject();
            });
        });
    };
  
    //트레이너별 게시물 목록
    const BoardListByTrainer = ((member_code) => {
        axios
        .get(`http://localhost:9999/api/board/trainer/${member_code}`)
        .then((resp) => {
            console.log("게시물 목록 가져오기 성공");
            const responseData = resp.data

            boardList.value = responseData.map(item => ({
                writercode : item.board_uploader,
                code : item.board_code,
                title : item.board_title,
                uploadtime : item.board_uploadtime,
                content : item.board_content,
                viewcnt : item.board_viewcnt,
            }))
        })
        .catch(() => {
            console.log("게시물 목록 가져오기 실패");
        })
    })

    const BoardListByTrainerPromise = (member_code) => {
        return new Promise((resolve, reject) => {
          axios
            .get(`http://localhost:9999/api/board/trainer/${member_code}`)
            .then((resp) => {
              console.log("게시물 목록 가져오기 성공");
              const responseData = resp.data

            boardList.value = responseData.map(item => ({
                writercode : item.board_uploader,
                code : item.board_code,
                title : item.board_title,
                uploadtime : item.board_uploadtime,
                content : item.board_content,
                viewcnt : item.board_viewcnt,
            }))
      
              resolve();
            })
            .catch((error) => {
              console.log("게시물 목록 가져오기 실패", error);
              reject();
            });
        });
    };

    // //게시물 목록 가져오기
    // const Boardlist = (() => {
    //     axios
    //         .get("https://localhost:9999/api/board")
    //         .then((resp) => {
    //             console.log("보드리스트 불러오기 성공");
    //             boards.value = resp.data
    //             console.log(boards.value);
    //         })
    //         .catch(() => {
    //             console.log("보드리스트 불러오기 실패");
    //         })
    // })

    // //게시물 상세 보기
    // const board = ref(null);

    // const Boarddetail = ((board_code) => {
    //     axios
    //         .get("https://localhost:9999/api/board/${board_code}")
    //         .then((resp) => {
    //             console.log("게시물 디테일 불러오기 성공");
    //             board.value = resp.data;
    //         })
    //         .catch(()=> {
    //             console.log("게시물 디테일 불러오기 실패");
    //         })
    // })

    //게시물 등록
    const registBoard = ((board) => {
        axios
            .post("https://localhost:9999/api/board")
            .then(() => {
                console.log("게시물 등록 성공");
                router.push({name:"Home"})
            })
            .catch(() => {
                console.log("게시물 등록 실패");
        })
    })

    // //게시물 삭제
    const deleteBoard = ((board_code) => {
        axios
            .delete("https://localhost:9999/api/board/${board_code}")
            .then(() => {
                console.log("deleteBoard 성공");
                router.push({ name: "BoardList" })
            })
            .catch(() => {
            console.log("deleteUser 실패");
        })
    })

    // //게시물 수정
    const updateBoard = ((board) => {
        const board_code = trainer.board_code;
        axios
        .put(`http://localhost:9999/api/trainer/${board_code}/update`)//수정 필요함
        .then(() => {
            console.log("updateBoard 성공");
            router.push({ name: "Home" })
        })
        .catch(() => {
                console.log("updateBoard 실패");
            })

    })
    // //추후 추가


    return{
        BoardListByTrainerPromise, BoardListByMember, BoardListByMemberPromise, boardList,registBoard, updateBoard, BoardListByTrainer, deleteBoard, boards
    };

    //  Boardlist, Boarddetail, writeBoard, deleteBoard, boards, board, board_code
}, { persist: true });
