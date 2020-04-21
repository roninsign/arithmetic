package com.dao;

import com.entity.UserScore;

import java.util.List;

public interface UserScoreDao {

    /**
     * 增加一条
     * @param userScore
     * @return
     */
    public boolean addUserScore(UserScore userScore);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public boolean deleteUserScore(int id);

    /**
     * 通过学号查找所有的记录
     * @param
     * @return
     */
    public List<UserScore> InquiryBystudentNumber(String studentNumber);


    /**
     * 遍历所有用户
     */
    public List<UserScore> ListAll();

}


