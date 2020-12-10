package com.hnguigu.controller;

import com.hnguigu.service.StaffService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StaffController {

    @Autowired
    StaffService staffService;


    //查询
    @RequestMapping("/querystaff.action")
    @ResponseBody
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
    @RequestMapping(value = "/deleteplstaff.action/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public boolean deletePLStaff(@PathVariable String ids){
        String[] idss=ids.split(",");
        int[] ints=new int[idss.length];
        for(int i=0;i<idss.length;i++){
            ints[i]=Integer.parseInt(idss[i]);
        }

        int num=staffService.deletePLStaff(ints);

        return num>0;
    }

    //删除
    @RequestMapping("/deletestaff.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> deleteStaff(int staid){
        Map<String,String> map=new HashMap<>();

        int num=staffService.deleteStaff(staid);

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
