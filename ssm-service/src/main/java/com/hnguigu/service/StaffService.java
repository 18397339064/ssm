package com.hnguigu.service;

import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Staff;

import java.util.List;

public interface StaffService {


    //注册
    public int addStaff(Staff staff);


    //通过条件查询
    public PageVo<Staff> queryStaffCount(Staff staff, int page, int rows);

    //批量删除
    public int deletePLStaff(int[] staffid);

    //删除
    public int deleteStaff(int staffid);

    //通过id查询数据
    public Staff queryByStaid(int staffid);

    //修改
    public int updateStaff(Staff staff);
}
