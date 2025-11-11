<script setup lang="ts">
import

{ Layout } from 'ant-design-vue';
import GlobalHeader from './components/GlobalHeader.vue';
import GlobalFooter from './components/GlobalFooter.vue';

const { Content } = Layout;
</script>

<template>
  <Layout class="basic-layout">
    <GlobalHeader />
    <Content class="content">
      <router-view></router-view>
    </Content>
    <GlobalFooter />
  </Layout>
</template>

<style scoped>
.basic-layout {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.content {
  flex: 1;
  margin: 24px;
  padding: 24px;
  background-color: #fff;
  border-radius: 2px;
  min-height: calc(100vh - 200px); /* 为头部和底部留出空间 */
}

@media (max-width: 768px) {
  .content {
    margin: 12px;
    padding: 16px;
    min-height: calc(100vh - 180px);
  }
}
</style>
