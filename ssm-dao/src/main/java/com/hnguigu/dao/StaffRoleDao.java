package com.hnguigu.dao;

import com.hnguigu.vo.RoleMenu;
import com.hnguigu.vo.StaffRole;

import java.util.List;

public interface StaffRoleDao {

    //通过员工id查询拥有的 角色 选中的角色
    public List<StaffRole> queryAllStaffRole(int staffid);

    //添加
    public int addSR(StaffRole staffRole);

    //删除
    public int deleteStaffid(int staffid);
}
