<template>
  <div class="container">
    <div class="video-card">
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
          <!--전체 비디오리스트를 비디오 코드를 키값으로 가져옴-->
          <tr v-for="video in videos" :key="video.code">
            <td>{{ video.title }}</td>
            <td>{{ video.readme }}</td>
            <td>{{ video.viewcnt }}</td>
            <td>{{ video.url }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { useVideoStore } from "@/stores/videoStore";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";

const { params } = useRoute();
const videoStore = useVideoStore();
const videos = ref([]);
const videosLoaded = ref(false);

onMounted(async () => {
  await videoStore.VideoListByTrainer(params.member_code);
  videos.value = videoStore.videoList;
  videosLoaded.value = true;
});
</script>

<style scoped>
.container {
  padding: 20px;
  background-color: #f9f9f9;
}

.board-card {
  overflow-x: auto;
}

.board-list {
  width: 100%;
  border-collapse: collapse;
}

.board-list th, .board-list td {
  border: 1px solid #ccc;
  padding: 8px;
  text-align: center;
}

.board-list th {
  background-color: #f2f2f2;
}

.board-list td {
  background-color: #fff;
}

.board-list a {
  text-decoration: none;
  color: #007bff;
}

.board-list a:hover {
  text-decoration: underline;
}
</style>

