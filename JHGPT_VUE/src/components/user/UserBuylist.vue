<template>
  <div class="container">
    <h2>구매한 트레이너 목록</h2>
    <div class="trainer-list">
      <ul>
        <li v-for="trainer in trainers" :key="trainer.id">
          <h3>{{ trainer.name }}</h3>
          <p>닉네임: {{ trainer.nickname }}</p>
          <p>소개: {{ trainer.description }}</p>
        </li>
        <!--누르면 PtDetail로 넘어가도록-->
      </ul>
    </div>
  </div>
</template>

<script>

</script>

<style scoped>
.container {
  padding: 20px;
}

.trainer-list {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

ul {
  list-style: none;
  padding: 0;
}

li {
  margin-bottom: 20px;
  border: 1px solid #eee;
  padding: 10px;
  border-radius: 5px;
}
</style>
