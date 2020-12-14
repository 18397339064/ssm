package com.hnguigu.service;

import com.hnguigu.vo.RoleMenu;

import java.util.List;

public interface RoleMenuService {

    //通过角色id查询拥有的 菜单  选中的菜单
    public List<RoleMenu> queryAllRoleMenu(int roleId);

    //添加
    public int addRM(RoleMenu roleMenu);

    //删除
    public int deleteRoleid(int roleid);

}
