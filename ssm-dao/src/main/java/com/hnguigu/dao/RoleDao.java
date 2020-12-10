package com.hnguigu.dao;


import com.hnguigu.vo.Role;

import java.util.List;

public interface RoleDao {

    //通过条件查询
    public List<Role> queryRole(Role role);

    //通过条件查询记录
    public int queryRoleCount(Role role);

    //添加
    public int addRole(Role role);

    //修改
    public int updateRole(Role role);

    //批量删除
    public int deletePLRole( String[] roleid);

    //删除
    public int deleteRole(int roleid);

}
