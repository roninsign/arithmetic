package com.sql;


public class userSql {
    public static String addUser="INSERT INTO t_user(username,studentNumber,password)VALUES(?,?,?)";

    //更改用户
    public static String editUser="UPDATE  t_user SET username=?,studentNumber=?,password=? WHERE id=?";

    //根据姓名查找用户
    public static  String queryUserBystudentNumber=" SELECT * FROM  t_user WHERE studentNumber=?";

}
