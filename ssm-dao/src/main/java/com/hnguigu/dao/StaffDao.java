package com.hnguigu.dao;

import com.hnguigu.vo.Staff;

import java.util.List;

public interface StaffDao {

    //注册
    public int addStaff(Staff staff);

    //通过条件查询
    public List<Staff> queryStaff(Staff staff);

    //通过条件查询记录数量
    public int queryStaffCount(Staff staff);

    //批量删除
    public int deletePLStaff(int[] staffid);

    //删除
    public int deleteStaff(int staffid);

    //通过id查询数据
    public Staff queryByStaid(int staffid);

    //修改
    public int updateStaff(Staff staff);

}
