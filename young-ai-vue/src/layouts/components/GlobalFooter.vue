<script setup lang="ts"></script>

<template>
  <footer class="global-footer">
    <div class="footer-content">
      <p>YANG的项目</p>
      <a href="https://blog.csdn.net/weixin_73847538?spm=1000.2115.3001.5343" target="_blank" rel="noopener noreferrer">
        访问我的博客
      </a>
    </div>
  </footer>
</template>

<style scoped>
.global-footer {
  background-color: #f0f2f5;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 16px 0;
  text-align: center;
  border-top: 1px solid #e8e8e8;
}

.footer-content {
  max-width: 1440px;
  margin: 0 auto;
  padding: 0 24px;
}

.footer-content p {
  margin: 0 0 8px 0;
  color: rgba(0, 0, 0, 0.65);
}

.footer-content a {
  color: #1890ff;
  text-decoration: none;
}

.footer-content a:hover {
  text-decoration: underline;
}
</style>
