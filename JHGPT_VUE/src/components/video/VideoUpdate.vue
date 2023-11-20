<template>
    <div>
        <h4>비디오 수정</h4>
        <fieldset>
            <legend>등록</legend>
            <div>
                <label for="title">비디오 제목 : </label>
                <input type="text" id="title" v-model="board.title">
            </div>
            <div>
                <label for="content">비디오 URL : </label>
                <textarea id="content" cols="30" rows="10" v-model="board.content"></textarea>
            </div>
            <div>
                <button @click="updateVideo">수정</button>
            </div>
        </fieldset>
    </div>
</template>


<script setup>
import { ref, onMounted } from 'vue';
import {useVideoStore} from "@/stores/videoStore";
const videoStore = useVideoStore();

const route = useRoute();
const video = ref({});
const isVideoLoaded = ref(false);

onMounted(async () => {
  try {
    const video_code = route.params.video_code;
    await videoStore.selectVideo(video_code);
    video.value = { ...videoStore.video }; // 기존 유저 정보 복사
    isVideoLoaded.value = true;
  } catch (error) {
    console.error("비디오 정보를 불러오는 동안 오류가 발생했습니다:", error);
  }
});

const updateVideo = () => {

    video.value = {
        video_code: video.value.code,
        title: video.value.title,
        url : video.value.url,
    };
    videoStore.updateVideo(video.value);
};

</script>