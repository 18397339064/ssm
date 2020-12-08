package com.hnguigu.controller;

import com.hnguigu.service.UserService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    //通过条件查询所有
    @RequestMapping("/queryusercount.action")
    @ResponseBody
    public PageVo<User> queryUserCount(User user,
                                    @RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "rows", defaultValue = "10") int rows){
        return userService.queryUserCount(user,page,rows);
    }

    //注册用户
    @RequestMapping("/adduser.action")
    @ResponseBody
    public Map<String,String> addUser(User user){
        Map<String,String> map=new HashMap<>();

        int num=userService.addUser(user);

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
    @RequestMapping("/querybyuserid.action")
    @ResponseBody
    public User queryByUserid(int userid){
        return userService.queryByUserid(userid);
    }

    //修改
    @RequestMapping("/updateuser.action")
    @ResponseBody
    public Map<String,String> updateUserinfo(User user){
        Map<String,String> map=new HashMap<>();

        int num=userService.updateUser(user);

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
    @RequestMapping(value = "/deletepluser.action/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deletePLStaff(@PathVariable String ids){
        String[] idss=ids.split(",");
        int[] ints=new int[idss.length];
        for(int i=0;i<idss.length;i++){
            ints[i]=Integer.parseInt(idss[i]);
        }

        int num=userService.deletePLUser(ints);

        return num>0;
    }

    //删除
    @RequestMapping("/deleteuserinfo.action")
    @ResponseBody
    public Map<String,String> deleteUserinfo(int userid){
        Map<String,String> map=new HashMap<>();

        int num=userService.deleteUser(userid);

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
