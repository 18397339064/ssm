package com.hnguigu.service;

import com.hnguigu.vo.Menu;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Role;

import java.util.List;

public interface RoleService {

    //通过条件查询
    public PageVo<Role> queryRoleCount(Role role, int page, int rows);

    //添加
    public int addRole(Role role);

    //修改
    public int updateRole(Role role);

    //批量删除
    public int deletePLRole( String[] roleid);

    //删除
    public int deleteRole(int roleid);

    //分配角色插叙
    public List<Role> queryFenPeiRole();

    //查询角色名
    public Role queryRolename(String rolename);
}
