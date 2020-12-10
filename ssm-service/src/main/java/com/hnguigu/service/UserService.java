package com.hnguigu.service;

import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.User;

import java.util.List;

public interface UserService {

    //通过条件查询
    public PageVo<User> queryUserCount(User user, int page, int rows);

    //注册
    public int addUser(User user);

    //批量删除
    public int deletePLUser(String[] userid);

    //删除
    public int deleteUser(int userid);

    //修改
    public int updateUser(User user);

}
