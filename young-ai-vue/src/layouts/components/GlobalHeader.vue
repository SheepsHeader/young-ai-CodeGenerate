<script setup lang="ts">
import { Menu } from 'ant-design-vue';

// 菜单项配置
const menuItems = [
  {
    key: '1',
    label: '首页',
  },
  {
    key: '2',
    label: '产品',
  },
  {
    key: '3',
    label: '文档',
  },
  {
    key: '4',
    label: '关于我们',
  },
];
</script>

<template>
  <header class="global-header">
    <div class="header-content">
      <div class="header-left">
        <img src="@/assets/logo.png" alt="Logo" class="logo" />
        <span class="site-title">Young AI</span>
        <Menu mode="horizontal" :items="menuItems" class="menu" />
      </div>
      <div class="header-right">
        <a-button type="primary"  size="large">
          登录
        </a-button>
      </div>
    </div>
  </header>
</template>

<style scoped>
.global-header {
  background-color: #fff;
  border-bottom: 1px solid #f0f0f0;
  box-shadow: 0 1px 4px rgba(0, 0, 0, 0.08);
}

.header-content {
  max-width: 1440px;
  margin: 0 auto;
  padding: 0 24px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 64px;
}

.header-left {
  display: flex;
  align-items: center;
  gap: 16px;
}

.logo {
  width: 32px;
  height: 32px;
}

.site-title {
  font-size: 20px;
  font-weight: 600;
  color: #1890ff;
}

.menu {
  border: none;
}

.header-right {
  display: flex;
  align-items: center;
}

@media (max-width: 768px) {
  .header-content {
    padding: 0 12px;
  }

  .menu {
    display: none;
  }
}
</style>
