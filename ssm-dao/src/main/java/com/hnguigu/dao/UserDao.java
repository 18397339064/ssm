package com.hnguigu.dao;

import com.hnguigu.vo.User;

import java.util.List;

public interface UserDao {
    //通过条件查询
    public List<User> queryUser(User user);

    //通过条件查询记录数量
    public int queryUserCount(User user);

    //批量删除
    public int deletePLUser(String[] userid);

    //删除
    public int deleteUser(int userid);

    //修改
    public int updateUser(User user);


}
