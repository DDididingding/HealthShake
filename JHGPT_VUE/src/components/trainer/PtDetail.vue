<template>
  <div>
    <h1>피티 상세 페이지</h1>

    <div v-for="(pt, index) in ptDetails" :key="index" class="pt-details">
      <div>
        <strong>운동 부위:</strong> {{ pt.bodyPart }}
      </div>
      <div>
        <strong>난이도:</strong> {{ pt.difficulty }}
      </div>
      <div>
        <strong>PT 소개:</strong> {{ pt.description }}
      </div>
    </div>
  </div>
</template>

<script setup>
// PT 데이터를 배열로 관리
const ptDetails = [
  {
    bodyPart: '상체',
    difficulty: '초급',
    description: '이 PT는 상체 근력 강화를 위한 운동들로 구성되어 있습니다.',
  },
  {
    bodyPart: '하체',
    difficulty: '중급',
    description: '하체 근력 강화를 위한 PT입니다.',
  },
  {
    bodyPart: '전신',
    difficulty: '고급',
    description: '전신 근력 향상을 위한 고급 PT입니다.',
  },
  // 추가 PT 데이터들
];
</script>

<style scoped>
/* 필요한 스타일링 추가 */
.pt-details {
  margin-top: 20px;
  border: 1px solid #ccc;
  padding: 10px;
  border-radius: 5px;
}
</style>
