package com.hnguigu.service;

import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.User;

import java.util.List;

public interface UserService {


    //注册
    public int addUser(User user);

    //通过条件查询
    public PageVo<User> queryUserCount(User user, int page, int rows);

    //批量删除
    public int deletePLUser(int[] userid);

    //删除
    public int deleteUser(int userid);

    //通过id查询数据
    public User queryByUserid(int userid);

    //修改
    public int updateUser(User user);

}
