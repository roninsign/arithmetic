package com.util.impl;

import com.util.DbConn;

import java.sql.*;


public class DbConnImpl implements DbConn {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/lxsb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";//写成自己数据库的名称
    private final String USERNAME = "root";
    private final String PASSWORD = "1725030127";
    private Connection conn = null;


    public DbConnImpl() {
        try {
            Class.forName(DRIVER);//在Java程序中加载驱动程序。
            this.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {//创建数据连接对象：通过DriverManager类创建数据库连接对象Connection
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *  连接数据库
     */
    public Connection getConnection(){

        return this.conn;
    }

    /**
     * 关闭数据库
     * @param conn
     */
    public void closeConnection(Connection conn)
    {
        if(conn!=null)
        {
            try{
                conn.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    /**
     *  关闭预处理结果
     */
    public void closePreparedStatement(PreparedStatement pd)
    {
        if(pd!=null)
        {
            try{
                pd.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    /**
     * 关闭结果集
     */
    public void closeResultSet(ResultSet rs)
    {
        if(rs!=null)
        {
            try{
                rs.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

}

