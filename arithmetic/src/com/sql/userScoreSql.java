package com.sql;


public class userScoreSql {

    private int id;
    private String username;
    private String studentNumber;
    private String score;
    //正确率
    private double accuracy;
    //做一次题所需时间
    private String allTime;

    //做题时的日期
    private String currentDate;
    public static String addUserScore="INSERT INTO t_score(username,studentNumber,score,accuracy,allTime,currentDate)VALUES(?,?,?,?,?,?)";

    //更改用户
    public static String editUser="UPDATE t_score SET username=?,studentNumber=?,password=? WHERE id=?";

    //根据姓名查找用户

    public static String queryUserBystudentNumber = "SELECT * FROM  t_score WHERE studentNumber=?";

    public static  String listUser="SELECT * FROM t_score";
}
