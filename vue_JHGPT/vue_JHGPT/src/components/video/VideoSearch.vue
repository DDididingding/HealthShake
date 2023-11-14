<template>
  <div class="container">
    <div class="text-center">
      <input
        class="view"
        type="text"
        v-model="search"
        placeholder="이름을 입력하세요."
      />
      <button class="btn" @click="searchVideo">검색</button>
    </div>
    <br />
    <hr />
    <div>
      <h2>검색 결과</h2>
      <div v-if="users.length">
        <table class="user-list">
          <colgroup>
            <col style="width: 5%" />
            <col style="width: 40%" />
            <col style="width: 20%" />
            <col style="width: 20%" />
            <col style="width: 15%" />
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
                <RouterLink class="video-link" :to="`/video/${video.id}`">{{
                  video.vide_id
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
      <div v-else>검색 결과가 없습니다.</div>
    </div>
    <br />
  </div>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";

const search = ref("");
const users = ref([]);

const searchUser = () => {
  const API_URL = `http://localhost:9999/api/video/search`; //수정 필요
  axios({
    url: API_URL,
    method: "GET",
    params: {
      word: search.value,
    },
  })
    .then((res) => {
      if (res.data) {
        const foundVideo = res.data.find((video) => {
          return video.id === search.value;
        });
        if (foundUser) {
          videos.value = [foundVideo];
        } else {
          videos.value = [];
          alert("검색한 영상이 없습니다");
        }
      } else {
        alert("등록된 영상이 없습니다.");
      }
    })
    .catch((err) => {
      console.error(err);
      users.value = [];
      alert("검색 중 오류가 발생했습니다");
    });
};
</script>
