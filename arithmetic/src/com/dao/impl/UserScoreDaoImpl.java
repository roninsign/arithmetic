package com.dao.impl;

import com.dao.UserScoreDao;
import com.entity.UserScore;
import com.sql.userScoreSql;
import com.util.DbConn;
import com.util.impl.DbConnImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserScoreDaoImpl implements UserScoreDao {
    private Connection conn;
    private DbConn dbConn;
    //初始化
    public  UserScoreDaoImpl(){
        this.dbConn=new DbConnImpl() ;
    }


    @Override
    public boolean addUserScore(UserScore userScore) {
        boolean flag=false;
        conn=null;
        PreparedStatement pd=null;
        try{
            this.conn=dbConn.getConnection();
            pd=conn.prepareStatement(userScoreSql.addUserScore);
            pd.setString(1,userScore.getUsername());
            pd.setString(2,userScore.getStudentNumber());
            pd.setString(3,userScore.getScore());
            pd.setDouble(4,userScore.getAccuracy());
            pd.setString(5,userScore.getAllTime());
            pd.setString(6,userScore.getCurrentDate());

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

    @Override
    public boolean deleteUserScore(int id) {
        boolean flag=false;
        return flag;
    }

    @Override
    public List<UserScore> InquiryBystudentNumber(String studentNumber) {
        UserScore userScore =null;
        List<UserScore> list=new ArrayList<>();
        conn=null;
        PreparedStatement pd=null;
        try{
            this.conn=dbConn.getConnection();
            pd=conn.prepareStatement(userScoreSql.queryUserBystudentNumber);
            pd.setString(1,studentNumber);
            ResultSet rs=pd.executeQuery();
            while(rs.next()){
                userScore = new UserScore();
                userScore.setId(rs.getInt("id"));
                userScore.setUsername(rs.getString("username"));
                userScore.setStudentNumber(rs.getString("studentNumber"));
                userScore.setScore(rs.getString("score"));
                userScore.setAccuracy(rs.getDouble("accuracy"));
                userScore.setAllTime(rs.getString("allTime"));
                userScore.setCurrentDate(rs.getString("currentDate"));
                list.add(userScore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            dbConn.closePreparedStatement(pd);
            dbConn.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<UserScore> ListAll() {
        UserScore userScore = null;
        List<UserScore> list=new ArrayList<>();
        conn=null;
        PreparedStatement pd=null;
        ResultSet rs=null;//ResultSet，数据库结果集的数据表，通常通过执行查询数据库的语句生成。ResultSet 对象具有指向其当前数据行的指针。
        // 最初，指针被置于第一行之前。next 方法将指针移动到下一行；
        // 因为该方法在 ResultSet 对象中没有下一行时返回 false，所以可以在 while 循环中使用它来迭代结果集。
        try{
            this.conn=dbConn.getConnection();
            pd=conn.prepareStatement(userScoreSql.listUser);
            rs=pd.executeQuery();
            while(rs.next()){
                userScore=new UserScore();
                userScore.setId(rs.getInt("id"));
                userScore.setUsername(rs.getString("username"));
                userScore.setStudentNumber(rs.getString("studentNumber"));
                userScore.setScore(rs.getString("score"));
                userScore.setAccuracy(rs.getDouble("accuracy"));
                userScore.setAllTime(rs.getString("allTime"));
                userScore.setCurrentDate(rs.getString("currentDate"));
                list.add(userScore);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConn.closePreparedStatement(pd);
            dbConn.closeConnection(conn);
        }
        return list;
    }
}
