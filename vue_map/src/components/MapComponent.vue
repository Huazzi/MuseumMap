
<template>
  <div id="allmap"></div>
</template>

<script setup>
import { onMounted } from 'vue'

onMounted(() => {
  const script = document.createElement('script')
  script.src = '//api.map.baidu.com/api?v=3.0&ak=Q88PDiiPFVSbyLny7kdd8qZRIK5l3UUM'
  script.onload = () => {
    var map = new BMap.Map('allmap') // 创建Map实例
    map.centerAndZoom('南京', 15) // 初始化地图,用城市名设置地图中心点
  }
  document.body.appendChild(script)
})
</script>

<style scoped>
body,
html,
#allmap {
  width: 100%;
  height: 100%;
  overflow: hidden;
  margin: 0;
  font-family: '微软雅黑', serif;
}
</style>
