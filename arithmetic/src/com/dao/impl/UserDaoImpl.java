package com.dao.impl;

import com.dao.UserDao;
import com.entity.User;
import com.sql.userSql;
import com.util.DbConn;
import com.util.impl.DbConnImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private Connection conn;
    private DbConn dbConn;
    //初始化
    public UserDaoImpl(){
        this.dbConn=new DbConnImpl() ;
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @Override
    public boolean AddUser(User user) {
        boolean flag=false;
        conn=null;
        PreparedStatement pd=null;
        try{
            this.conn=dbConn.getConnection();
            pd=conn.prepareStatement(userSql.addUser);
            pd.setString(1,user.getUsername());
            pd.setString(2,user.getStudentNumber());
            pd.setString(3,user.getPassword());

            if(pd.executeUpdate()>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbConn.closePreparedStatement(pd);
            dbConn.closeConnection(conn);
        }
        return flag;
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Override
    public boolean UpdateUser(User user) {
        boolean flag=false;
        conn=null;
        PreparedStatement pd=null;
        try{
            this.conn=dbConn.getConnection();
            pd=conn.prepareStatement(userSql.editUser);
            pd.setString(1,user.getUsername());
            pd.setString(2,user.getStudentNumber());
            pd.setString(3,user.getPassword());
            pd.setInt(4,user.getId());
            if(pd.executeUpdate()>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            dbConn.closePreparedStatement(pd);
            dbConn.closeConnection(conn);

        }
        return flag;
    }

    /**
     * 通过学号查找用户
     * @param studentNumber
     * @return
     */
    @Override
    public User SelectUserBystudentName(String studentNumber) {
        User user=null;
        conn=null;
        PreparedStatement pd=null;
        try{
            this.conn=dbConn.getConnection();
            pd=conn.prepareStatement(userSql.queryUserBystudentNumber);
            pd.setString(1,studentNumber);
            ResultSet rs=pd.executeQuery();
            while(rs.next()){
                user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setStudentNumber(rs.getString("studentNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            dbConn.closePreparedStatement(pd);
            dbConn.closeConnection(conn);
        }
        return user;
    }
}
