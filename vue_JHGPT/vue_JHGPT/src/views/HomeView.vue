<template>
  <div class="container">
    <br />
    <div class="text-center">
      <h1>{{ message }}</h1>
    </div>
    <br />
    <VideoSearch />
  </div>
</template>

<script setup>
import VideoSearch from "@/components/video/VideoSearch.vue";

const message = "JHGPT 환영합니다아";
</script>

<style>
.text-center {
  text-align: center;
}
</style>
