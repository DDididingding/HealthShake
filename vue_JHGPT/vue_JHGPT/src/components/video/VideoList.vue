<template>
  <div class="container">
    <h2>영상 목록</h2>
    <h4>등록된 영상의 수 : {{ videoCnt }}</h4>
    <div v-if="videos.length">
      <table class="video-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 30%" />
          <col style="width: 20%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
          <col style="width: 10%" />
        </colgroup>
        <thead>
          <tr>
            <th>영상 번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>url</th>
            <th>부위</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(video, index) in videos" :key="index">
            <td>{{ index + 1 }}</td>
            <td>
              <RouterLink class="video-link" :to="`/video/${video.video_id}`">{{
                video.video_id
              }}</RouterLink>
            </td>
            <td>{{ video.video_title }}</td>
            <td>{{ video.content }}</td>
            <td>{{ video.video_url }} </td>
            <td>{{ video.part }} </td>
            <td>{{ video.view_cnt}} </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else>등록된 영상이 없습니다.</div>
  </div>
</template>

<script setup>
import { computed, defineProps } from "vue";

const props = defineProps({
  videos: {
    type: Array,
    default: () => [],
  },
});

const videoCnt = computed(() => props.videos.length);
</script>
