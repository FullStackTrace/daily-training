
//依赖一个http模块，相当于java中的import，与C#中的using
var http = require('http');
var fs = require('fs');
var url = require('url');
var db = require("./db.js")

//创建一个服务器对象
server = http.createServer(function (req, res) {
    var pathname = url.parse(req.url).pathname;

    console.log("Request for " + pathname + " received.");

    if(pathname.indexOf(".html") != -1) {
        fs.readFile("./" + pathname.substr(1), function (err, data) {
            if (err) {
                // HTTP 状态码: 404 : NOT FOUND
                // Content Type: text/plain
                res.writeHead(404, {'Content-Type': 'text/html'});
            }else{             
                // HTTP 状态码: 200 : OK
                // Content Type: text/plain
                res.writeHead(200, {'Content-Type': 'text/html'});    
                
                // 响应文件内容
                res.write(data);        
            }    
            res.end();
         });   
    } else {
        switch(pathname) {
            case "/getData" : db.getData(res);break;
            case "/saveData" : db.saveData(req,res);break;
        }
    }
});
//让服务器监听本地8000端口开始运行
server.listen(8000,'127.0.0.1');