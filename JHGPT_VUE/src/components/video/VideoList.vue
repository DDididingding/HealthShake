<template>
  <div class="container">
    <h2>비디오 목록</h2>
    <h4>등록된 비디오의 수 {{ videoCnt }}</h4>
    <div v-if="videos.length">
      <table class="video-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 45%" />
          <col style="width: 25%" />
          <col style="width: 25%" />
        </colgroup>
        <thead>
          <tr>
            <th>제목</th>
            <th>소개글</th>
            <th>조회수</th>
            <th>url</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="video in store.videoList" :key="video.id">
                <td>{{ video.id }}</td>
                <td>
                    <RouterLink :to="`/video/${video.id}`">{{ video.title }}</RouterLink>
                </td>
                <td>{{ video.readme }}</td>
                <td>{{ video.viewcnt }}</td>
                <td>{{ video.url }}</td>
            </tr>
        </tbody>
      </table>
    </div>
    <div v-else>등록된 리뷰가 없습니다.</div>
  </div>

</template>

<script setup>
import { ref } from 'vue';
import { useVideoStore } from "@/stores/videoStore";
import { onMounted } from "vue";
const store = useVideoStore()

onMounted(() => {
    store.getVideoList()
})


const video = {
    post_content:'',
};
</script>

<style scoped>
/* 필요한 스타일링 추가 */
.video-box {
  border: 1px solid #ccc;
  padding: 20px;
  margin-bottom: 20px;
  border-radius: 5px;
}
</style>
