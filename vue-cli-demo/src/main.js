import Vue from 'vue';
import App from './App.vue';
import VueRouter from "vue-router";
//导入组件
import User from "./components/User";
import Dept from "./components/Dept";

Vue.config.productionTip = false;

Vue.use(VueRouter);

new Vue({
  // 路由对象
  router: new VueRouter({
    // 路由规则
    routes : [
      // path: 路由路径，component: 路由到的组件
      {
        path : '/user/:id',
        component : User
      },
      {
        path: '/dept/:name',
        component: Dept
      }
    ]
  }),
  // 渲染函数
  render: h => h(App),// App.vue组件
}).$mount('#app');// 挂载到index.html页面
