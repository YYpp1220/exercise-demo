<template>
    <div>
        <h2>{{user}}</h2>
        <span>参数：{{$route.params}}</span>
        <table border="1" width="50%">
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            <tr v-bind:key="user.id" v-for="user in users">
                <td>{{user.id}}</td>
                <td>{{user.name}}</td>
                <td>{{user.age}}</td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default {
        name: "user",
        //数据模型（函数）
        data : function () {
            return {
                user : '用户信息',
                users:[
                    {id : 1, name : '刁嘉辉', age : 18},
                    {id : 2, name : '傅芸萍', age : 18},
                    {id : 3, name : '刘湘茹', age : 18},
                    {id : 4, name : '杨晓雯', age : 18},
                ]
            }
        }
    }
</script>

<style scoped>
    div{
        background-color: blue;
        font-size: 20px;
        height: 400px;
    }
</style>