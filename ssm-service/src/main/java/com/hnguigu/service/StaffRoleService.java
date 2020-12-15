package com.hnguigu.service;

import com.hnguigu.vo.StaffRole;

import java.util.List;

public interface StaffRoleService {

    //通过员工id查询拥有的 角色 选中的角色
    public List<StaffRole> queryAllStaffRole(int staffid);

    //添加
    public int addSR(StaffRole staffRole);

    //删除
    public int deleteStaffid(int staffid);
}
