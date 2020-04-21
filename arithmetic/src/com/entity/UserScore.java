package com.entity;

public class UserScore {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public String getAllTime() {
        return allTime;
    }

    public void setAllTime(String allTime) {
        this.allTime = allTime;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public String toString() {
        return "UserScore{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", score='" + score + '\'' +
                ", accuracy=" + accuracy +
                ", allTime='" + allTime + '\'' +
                ", currentDate=" + currentDate +
                '}';
    }
}
