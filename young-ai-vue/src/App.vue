<script setup lang="ts">
import BasicLayout from './layouts/BasicLayout.vue';
import { test } from '@/api/tesstController.ts'
test().then(res => {
  console.log(res)
})
</script>

<template>
  <BasicLayout />
</template>

<style scoped></style>
