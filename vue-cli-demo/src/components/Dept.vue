<template>
    <div>
        <h3>{{dept}}</h3>
        <span>参数：{{$route.params}}</span>
        <ul>
            <li :key="dept.id" v-for="dept in depth">{{dept.name}}</li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "dept",
        data : function () {
            return {
                dept : '部门管理',
                depth : [
                    {id : 1, name : '人事部'},
                    {id : 2, name : '研发部'},
                    {id : 3, name : '市场部'},
                ]
            }
        }
    }
</script>

<style scoped>
    div{
        background-color: red;
        font-size: 20px;
        height: 400px;
    }
</style>