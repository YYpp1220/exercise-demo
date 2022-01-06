//引入path模块（path为内置模块）
var path = require("path");

/*exports 就是 module.exports，
但是这里直接是赋值，所以不能直接使用exports，
否则exports就不是module.exports了*/
module.exports = {
    // 入口文件
    entry : './src/import2.js',

    // 输出路径与文件名
    output : {
        // __dirname 是node的一个全局变量，获得当前文件所在目录的完整目录名
        path : path.resolve(__dirname, "./dist"),
        filename : "myMath.js"
    }
};