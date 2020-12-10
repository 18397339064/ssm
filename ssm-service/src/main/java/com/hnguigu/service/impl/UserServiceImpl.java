package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.UserDao;
import com.hnguigu.service.UserService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    //注册
    @Override
    public int addUser(User user) {

        return 0;//userDao.addUser(user);
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
}
