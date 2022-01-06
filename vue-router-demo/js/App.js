// 定义Vue组件
var app = Vue.extend({
    // html模板
    template : `
    <div>
        <h1>路由-测试四</h1>
            <p>
                <!-- 1. 使用 router-link 组件来导航.
                  通过传入 'to' 属性指定路由路径path.
                  <router-link> 默认会被渲染成一个 '<a>' 标签 -->
                <router-link to="/user/1">{{user}}</router-link>
                <router-link to="/dept/admin">{{dept}}</router-link>
            </p>
            <!-- 2. 路由出口，路由匹配到的组件将渲染在这里 -->
            <router-view></router-view>
    </div>`
    ,
    // 数据模型，data必须为函数
    data : function () {
        return {
            user : '用户管理',
            dept : '部门管理'
        }
    }
});