package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.UserDao;
import com.hnguigu.service.UserService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    //注册
    @Override
    public int addUser(User user) {

        return userDao.addUser(user);
    }

    //通过条件查询
    @Override
    public PageVo<User> queryUserCount(User user, int page, int rows) {
        PageVo<User> pageVo = new PageVo<>();
        //放在 查询代码的前面
        PageHelper.startPage(page, rows);
        pageVo.setRows(userDao.queryUser(user));

        pageVo.setTotal(userDao.queryUserCount(user));

        return pageVo;
    }

    //批量删除
    @Override
    public int deletePLUser(String[] userid) {
        return userDao.deletePLUser(userid);
    }

    //删除
    @Override
    public int deleteUser(int userid) {
        return userDao.deleteUser(userid);
    }

    //修改
    @Override
    public int updateUser(User userinfo) {
        return userDao.updateUser(userinfo);
    }

    //登录
    @Override
    public User loginUser(User user) {
        return userDao.loginUser(user);
    }

    //前端注册
    @Override
    public int addUser1(User user) {
        return userDao.addUser1(user);
    }

    //查询用户账号
    @Override
    public User queryUserAccount(String useraccount) {
        return userDao.queryUserAccount(useraccount);
    }

    //查询用户名
    @Override
    public User queryUsername(String username) {
        return userDao.queryUsername(username);
    }

    //把用户修改为商户
    @Override
    public int updateSH(int userid) {
        return userDao.updateSH(userid);
    }


}
