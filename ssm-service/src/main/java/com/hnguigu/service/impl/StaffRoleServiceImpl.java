package com.hnguigu.service.impl;

import com.hnguigu.dao.StaffRoleDao;
import com.hnguigu.service.StaffRoleService;
import com.hnguigu.vo.StaffRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffRoleServiceImpl implements StaffRoleService {

    @Autowired
    StaffRoleDao staffRoleDao;

    //通过员工id查询拥有的 角色 选中的角色
    @Override
    public List<StaffRole> queryAllStaffRole(int staffid) {
        return staffRoleDao.queryAllStaffRole(staffid);
    }

    //添加
    @Override
    public int addSR(StaffRole staffRole) {
        return staffRoleDao.addSR(staffRole);
    }

    //删除
    @Override
    public int deleteStaffid(int staffid) {
        return staffRoleDao.deleteStaffid(staffid);
    }
}
