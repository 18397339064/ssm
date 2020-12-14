package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.StaffDao;
import com.hnguigu.service.StaffService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffDao staffDao;



    //注册
    @Override
    public int addStaff(Staff staff) {
        return staffDao.addStaff(staff);
    }


    //通过条件查询
    @Override
    public PageVo<Staff> queryStaffCount(Staff staff, int page, int rows) {
        PageVo<Staff> pageVo = new PageVo<>();
        //放在 查询代码的前面
        PageHelper.startPage(page,rows);
        pageVo.setRows(staffDao.queryStaff(staff));

        pageVo.setTotal(staffDao.queryStaffCount(staff));

        return pageVo;
    }

    //批量删除
    @Override
    public int deletePLStaff(String[] staffid) {
        return staffDao.deletePLStaff(staffid);
    }

    //删除
    @Override
    public int deleteStaff(int staffid) {
        return staffDao.deleteStaff(staffid);
    }

    //通过id查询
    @Override
    public Staff queryByStaid(int staid) {
        return staffDao.queryByStaid(staid);
    }

    //修改
    @Override
    public int updateStaff(Staff staff) {
        return staffDao.updateStaff(staff);
    }
}
