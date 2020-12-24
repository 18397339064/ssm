package com.hnguigu.controller;

import com.hnguigu.service.MenuService;
import com.hnguigu.service.RoleMenuService;
import com.hnguigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;

    @Autowired
    RoleMenuService roleMenuService;

    //通过条件查询所有
    @RequestMapping("/querymenucount.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Menu> queryMenuCount(Menu menu,
                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "10") int rows){
        return menuService.queryMenuCount(menu,page,rows);
    }

    //添加
    @RequestMapping("/addmenu.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> addMenu(Menu menu){
        Map<String,String> map=new HashMap<>();

        int num=menuService.addMenu(menu);

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
    @RequestMapping("/updatemenu.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> updateMenu(Menu menu){
        Map<String,String> map=new HashMap<>();

        int num=menuService.updateMenu(menu);

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
    @RequestMapping("/deleteplmenu.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> deletePLMenu(String ids){
        Map<String,String> map=new HashMap<>();

        String[] idss=ids.split(",");

        int[] ints=new int[idss.length];

        int count=0;
        for(int i=0;i<idss.length;i++) {
            ints[i] = Integer.parseInt(idss[i]);

            //判断是否有某个菜单被角色引用，如果有不能删除
            count = roleMenuService.queryRMMid(ints[i]);

        }

        if(count>0){
            map.put("msg","对不起，其中有菜单已被引用，不能删除");
            map.put("code","2");
        }else {
            int num=menuService.deletePLMenu(idss);

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
    @RequestMapping("/deletemenu.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> deleteMenu(int id){
        Map<String,String> map=new HashMap<>();

        //判断是否有某个菜单被角色引用，如果有不能删除
        int count=roleMenuService.queryRMMid(id);

        if(count>0){
            map.put("msg","对不起，该菜单已被引用，不能删除");
            map.put("code","2");
        }else {
            int num=menuService.deleteMenu(id);

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

    //通过父id查询数据
    @RequestMapping("/querybypid.action")
    @ResponseBody
    @CrossOrigin
    public List<Menu> queryByPid(){
        return menuService.queryByPid();
    }


    //查询左边菜单
    @RequestMapping("/queryAllLeftMenu.action")
    @ResponseBody
    @CrossOrigin
    public List<Menu> queryAllLeftMenu(int sid){

        return menuService.queryAllLeftMenu(sid);
    }

    //查询授权菜单
    @RequestMapping("/queryAuthorMenu.action")
    @ResponseBody
    @CrossOrigin
    public List<Menu> queryAuthorMenu(int staid){

        return menuService.queryAuthorMenu(staid);
    }
}
