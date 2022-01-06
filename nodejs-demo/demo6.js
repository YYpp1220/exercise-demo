// 引入http模块 (内置模块)
var http = require('http');
// 引入url模块 (内置模块)
var url = require('url');

// 创建web服务
var server = http.createServer(function(request,response){
    // 获取请求地址
    var urlStr = request.url;
    // 解析参数
    // 参数1：请求地址；
    // 参数2：true时query解析参数为一个json对象，默认false
    var json = url.parse(urlStr,true).query;

    // 写HTTP 头部
    // HTTP 状态值: 200 : OK
    // 内容类型: text/plain
    response.writeHead(200,{
        'Content-Type': 'text/plain;charset=UTF-8'
    })
    // 发送响应数据,关闭响应对象
    response.end("name=" + json.name + ",age=" + json.age)

});
// 监听端口
server.listen(8888);
// 终端提示信息
console.log("亲，web服务跑起来了.......");