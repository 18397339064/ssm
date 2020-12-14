package com.hnguigu.controller;

import com.hnguigu.service.StaffService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class StaffController {

    @Autowired
    StaffService staffService;


    //查询
    @RequestMapping("/querystaff.action")
    @ResponseBody
    @CrossOrigin
    public List<Staff>  queryStaff(Staff staff){
        return null;//staffService.queryStaff(staff);
    }

    //通过条件查询所有
    @RequestMapping("/querystaffcount.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Staff> queryStaffCount(Staff staff,
                                    @RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "rows", defaultValue = "10") int rows){
        return staffService.queryStaffCount(staff,page,rows);
    }

    //注册员工
    @RequestMapping("/addstaff.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> addStaff(Staff staff){
        Map<String,String> map=new HashMap<>();

        int num=staffService.addStaff(staff);

        if(num==1){
            map.put("msg","注册成功");
            map.put("code","1");
        }else{
            map.put("msg","注册失败");
            map.put("code","0");
        }

        return map;
    }

    //通过id查询数据
    @RequestMapping("/querybystaid.action")
    @ResponseBody
    @CrossOrigin
    public Staff queryByStaid(int staid){
        return staffService.queryByStaid(staid);
    }

    //修改
    @RequestMapping("/updatestaff.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> updateStaff(Staff staff){
        Map<String,String> map=new HashMap<>();

        int num=staffService.updateStaff(staff);

        if(num==1){
            map.put("msg","修改成功");
            map.put("code","1");
        }else{
            map.put("msg","修改失败");
            map.put("code","0");
        }

        return map;
    }

    //批量删除
    @RequestMapping("/deleteplstaff.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> deletePLStaff(String ids){
        Map<String,String> map=new HashMap<>();
        String[] idss=ids.split(",");

        int num=staffService.deletePLStaff(idss);

        if(num==idss.length){
            map.put("msg","删除成功");
            map.put("code","1");
        }else{
            map.put("msg","删除失败");
            map.put("code","0");
        }

        return map;
    }

    //删除
    @RequestMapping("/deletestaff.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> deleteStaff(@RequestParam(defaultValue = "0") int staffid){
        Map<String,String> map=new HashMap<>();

        int num=staffService.deleteStaff(staffid);

        if(num==1){
            map.put("msg","删除成功");
            map.put("code","1");
        }else{
            map.put("msg","删除失败");
            map.put("code","0");
        }

        return map;
    }
}
