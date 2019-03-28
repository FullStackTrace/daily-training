var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'zsy',
  password : 'zhangyu023',
  database : 'test'
});
connection.connect();
var obj; 
exports.getData =  function(res){
    connection.query('SELECT * FROM `t_data_warn` order by warn_time limit 100', function (error, results, fields) {
        if (error) throw error;
        res.writeHead(200, {'Content-Type': 'application/json'}); 
        res.write(JSON.stringify(results));
        res.end();
    });
}

exports.saveData = function(req,res) {
    req.on("data", data => {
        data = JSON.parse(new String(data));
        console.log(data,data.name, data.age, data.sex)
        var  addSql = 'INSERT INTO t_user(name,age,sex) VALUES(?,?,?)';
        var  addSqlParams = [data.name, data.age, data.sex];
        //增
        connection.query(addSql,addSqlParams,function (err, result) {
            if(err){
                res.write('[INSERT ERROR] - '+err.message);
            } else {
                res.write('SUCCESS');
            }        
            res.end();
        });
    })
}