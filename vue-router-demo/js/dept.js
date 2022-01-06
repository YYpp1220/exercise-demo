// 定义Vue组件
var dept = Vue.extend({
    //html模板
    template : `<div style="background-color: blue; height: 400px">
                    <h3 @click="test()">{{msg}}</h3>
                    <h3>参数：{{$route.params}}</h3>
                </div>`,
    //数据模型，data必须为函数
    data : function(){
        return {
            msg : '==部门信息=='
        }
    },
    //方法
    methods : {
        test : function(){
            alert(this.$route.params.id);
        }
    }
});