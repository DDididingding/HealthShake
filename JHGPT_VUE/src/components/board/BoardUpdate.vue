<template>
    <div>
        <h4>게시물 수정</h4>
        <!-- 여기도 유저 정보 수정과 비슷하게 구현하면 되겠구만-->
        <fieldset>
            <legend>등록</legend>
            <div>
                <label for="title">제목 : </label>
                <input type="text" id="title" v-model="boardStore.board.title">
            </div>
            <div>
                <label for="content">내용 : </label>
                <textarea id="content" cols="30" rows="10" v-model="boardStore.board.content"></textarea>
            </div>
            <div>
                <button @click="updateBoard">수정</button>
            </div>
        </fieldset>
    </div>
</template>


<script setup>
import { ref, onMounted } from 'vue';
import {useBoardStore} from "@/stores/boardStore";
const boardStore = useBoardStore();

const route = useRoute();
const board = ref({});
const isBoardLoaded = ref(false);

onMounted(async () =>  {//페이지로 처음 접근하면
    try {
        const board_code = route.params.board_code;//파라미터로 받은 board_code
        await boardStore.selectUser(board_code);
        board.value = { ...boardStore.video }; // 기존 유저 정보 복사
        isBoardLoaded.value = true;
  } catch (error) {
    console.error("게시물 정보를 불러오는 동안 오류가 발생했습니다:", error);
  }
});

const updateBoard = () => {

    board.value = {
        title: board.value.title,
        content : board.value.content,
    };
    boardStore.updateBoard(board.value);
};


</script>