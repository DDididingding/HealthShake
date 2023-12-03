<template>
  <div class="container">
    <div class="board-card">
      <table class="board-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 10%" />
          <col style="width: 20%" />
          <col style="width: 30%" />
          <col style="width: 15%" />
          <col style="width: 20%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>작성자 아이디</th>
            <th>카테고리</th>
            <th>내용</th>
            <th>업로드 시간</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="board in boards" :key="board.code">
            <td>{{ board.code }}</td>
            <td>{{ board.writercode }}</td>
            <td>{{ board.category }}</td>
            <td>
              <RouterLink :to="`/board/${board.code}`">{{ board.content }}</RouterLink>
            </td>
            <td>{{ board.uploadtime }}</td>
            <td>{{ board.viewcnt }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { useBoardStore } from "@/stores/boardStore";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";

const { params } = useRoute();
const boardStore = useBoardStore();
const boards = computed(() => boardStore.boards);
const boardsLoaded = ref(false);

// store에 들어있는 정보를 꺼낼 때는
// computed(())

// onMounted(async () => {
//   await boardStore.BoardListByTrainer(params.member_code);
//   boards.value = boardStore.boards;
//   boardsLoaded.value = true;
// });
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

</style>
