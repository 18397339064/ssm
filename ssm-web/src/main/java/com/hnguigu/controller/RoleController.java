package com.hnguigu.controller;

import com.hnguigu.service.RoleService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    //通过条件查询所有
    @RequestMapping("/queryrolecount.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Role> queryRoleCount(Role role,
                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "5") int rows){
        return roleService.queryRoleCount(role,page,rows);
    }

    //添加
    @RequestMapping("/addrole.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> addRole(Role role){
        Map<String,String> map=new HashMap<>();

        int num=roleService.addRole(role);

        if(num==1){
            map.put("msg","添加成功");
            map.put("code","1");
        }else{
            map.put("msg","添加失败");
            map.put("code","0");
        }

        return map;
    }

    //修改
    @RequestMapping("/updaterole.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> updateRole(Role role){
        Map<String,String> map=new HashMap<>();

        int num=roleService.updateRole(role);

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
    @RequestMapping("/deleteplrole.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> deletePLRole(String ids){
        Map<String,String> map=new HashMap<>();
        System.out.println(ids);

        String[] idss=ids.split(",");

        int num=roleService.deletePLRole(idss);

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
    @RequestMapping("/deleterole.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> deleteRole(int roleid){
        Map<String,String> map=new HashMap<>();

        int num=roleService.deleteRole(roleid);

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
