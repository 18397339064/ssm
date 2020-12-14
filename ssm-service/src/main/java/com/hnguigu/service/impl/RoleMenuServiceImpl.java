package com.hnguigu.service.impl;

import com.hnguigu.dao.RoleMenuDao;
import com.hnguigu.service.RoleMenuService;
import com.hnguigu.vo.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    RoleMenuDao roleMenuDao;

    @Override
    public List<RoleMenu> queryAllRoleMenu(int roleId) {

        return roleMenuDao.queryAllRoleMenu(roleId);
    }

    //添加
    @Override
    public int addRM(RoleMenu roleMenu) {
        return roleMenuDao.addRM(roleMenu);
    }

    //删除
    @Override
    public int deleteRoleid(int roleid) {
        return roleMenuDao.deleteRoleid(roleid);
    }
}
