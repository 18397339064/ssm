package com.hnguigu.controller;

import com.hnguigu.service.RoleService;
import com.hnguigu.service.StaffRoleService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Role;
import com.hnguigu.vo.User;
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

    @Autowired
    StaffRoleService staffRoleService;

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
        int[] ints=new int[idss.length];

        int count=0;
        for(int i=0;i<idss.length;i++) {
            ints[i] = Integer.parseInt(idss[i]);

            //判断该角色是否被某些用户引用，如果有不能删除，给出提示信息
            count = staffRoleService.querySRRoleid(ints[i]);
        }

        if(count>0){
            map.put("msg","对不起，其中有角色已被引用，不能删除");
            map.put("code","2");
        }else {
            int num=roleService.deletePLRole(idss);

            if(num==idss.length){
                map.put("msg","删除成功");
                map.put("code","1");
            }else{
                map.put("msg","删除失败");
                map.put("code","0");
            }

        }
        return map;
    }

    //删除
    @RequestMapping("/deleterole.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> deleteRole(int roleid){
        Map<String,String> map=new HashMap<>();

        //判断该角色是否被某些用户引用，如果有不能删除，给出提示信息
        int count=staffRoleService.querySRRoleid(roleid);

        if(count>0){
            map.put("msg","对不起，该角色已被引用，不能删除");
            map.put("code","2");
        }else {
            int num=roleService.deleteRole(roleid);

            if(num==1){
                map.put("msg","删除成功");
                map.put("code","1");
            }else{
                map.put("msg","删除失败");
                map.put("code","0");
            }
        }
        return map;
    }

    @RequestMapping("/queryfenpeirole.action")
    @ResponseBody
    @CrossOrigin
    public List<Role> queryFenPeiRole(){
        return roleService.queryFenPeiRole();
    }

    //查询角色名
    @RequestMapping("/queryrolename.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> queryRolename(String rolename){
        Map<String,String> map=new HashMap<>();

        Role role=roleService.queryRolename(rolename);

        if(role==null){
            map.put("msg","角色名可用");
            map.put("code","1");
        }else{
            map.put("msg","角色名已存在");
            map.put("code","0");
        }

        return map;
    }

}
