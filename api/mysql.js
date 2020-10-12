const mysql = require('mysql');

var pool = mysql.createPool({
    "user":"root",
    "password":"",
    "database":"JeCommerce",
    "host":"localhost"

});
exports.pool = pool;