<template>
  <div>
    <p>
      <!-- 使用 router-link 组件来导航.
             通过传入 'to' 属性指定路由路径path.
             <router-link> 默认会被渲染成一个 '<a>' 标签 -->
      <router-link to="/user/1">{{user}}</router-link> |
      <router-link to="/dept/admin">{{dept}}</router-link>
    </p>
    <!-- 路由出口，路由匹配到的组件将渲染在这里 -->
    <router-view></router-view>
  </div>
</template>

<script>
  export default {
    name: 'app',
    data : function() {
      return {
        user : '用户信息',
        dept : '部门信息'
      }
    }
  }
</script>
<style>
</style>