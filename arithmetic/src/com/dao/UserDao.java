package com.dao;

import com.entity.User;

public interface UserDao {

    /**
     * 增加用户
     * @param user
     * @return
     */
    public boolean AddUser(User user);

//    /**
//     * 删除用户
//     * @param studentNumber
//     * @return
//     */
//    public boolean DeleteUser(String studentNumber);

    /**
     * 更新用户。修改密码
     * @param user
     * @return
     */
    public boolean UpdateUser(User user);

    /**
     * 通过学号查找用户
     * @param studentNumber
     * @return
     */
    public User SelectUserBystudentName(String studentNumber);
}
