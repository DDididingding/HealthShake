<template>
    <div>
        <h4>비디오 수정</h4>
        <fieldset>
            <legend>등록</legend>
            <div>
                <label for="title">비디오 제목 : </label>
                <input type="text" id="title" v-model="boardStore.board.title">
            </div>
            <div>
                <label for="content">비디오 URL : </label>
                <textarea id="content" cols="30" rows="10" v-model="boardStore.board.content"></textarea>
            </div>
            <div>
                <label for="content">가격 : </label>
                <textarea id="content" cols="30" rows="10" v-model="boardStore.board.content"></textarea>
            </div>
            <div>
                <button @click="updateBoard">수정</button>
            </div>
        </fieldset>
    </div>
</template>


<script setup>
import {useVideoStore} from "@/stores/videoStore";
const videoStore = useVideoStore();

const title = ref(videoStore.video.title);
const url = ref(videoStore.video.url);
const price = ref(videoStore.video.price);

const updateVideo = function () {

    const updatedVideo = {
        title : title.value,
        url : url.value,
        price : price.value,
    };

    videoStore.updateVideo(updatedVideo);
};

</script>