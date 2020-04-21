package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DbConn {

    public Connection getConnection();           //连接数据库

    public void closeConnection(Connection conn); //关闭数据库

    public void closePreparedStatement(PreparedStatement pd); //关闭预处理结果

    public void closeResultSet(ResultSet rs);  //关闭结果集


}
