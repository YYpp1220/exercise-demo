//引入http模块(http是内置模块)
var http = require("http");

// 创建web服务
var server = http.createServer(function (request, response) {
    // 发送 HTTP 头部
    // HTTP 状态值: 200 : OK
    // 内容类型: text/plain
    response.writeHead(200, {
        "Content-Type" : "text/plain;charset=UTF-8"
    });

    // 循环往浏览器写多行字符串
    for (var i = 0; i < 10; i++) {
        response.write("我学会nodejs了吗？\n");
    }

    // 关闭响应对象
    response.end("");
});

// 监听端口
server.listen(8080);

// 终端提示信息
console.log("亲，web服务跑起来了.......");