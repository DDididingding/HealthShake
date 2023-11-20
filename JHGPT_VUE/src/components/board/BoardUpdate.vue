<template>
    <div>
        <h4>게시물 수정</h4>
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
import {useBoardStore} from "@/stores/boardStore";
const boardStore = useBoardStore();

const title = ref(boardStore.board.title);
const content = ref(boardStore.board.content);

const updateBoard = function () {

    const updatedBoard = {
        title : title.value,
        content : content.value,
    };

    boardStore.updateBoard(updatedBoard);
};

</script>