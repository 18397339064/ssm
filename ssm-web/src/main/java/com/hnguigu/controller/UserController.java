package com.hnguigu.controller;

import com.hnguigu.service.ShangHuService;
import com.hnguigu.service.UserService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.ShangHuInfo;
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

    @Autowired
    ShangHuService shangHuService;


    //通过条件查询所有
    @RequestMapping("/queryusercount.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<User> queryUserCount(User user,
                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "10") int rows){
        return userService.queryUserCount(user,page,rows);
    }

    //注册用户
    @RequestMapping("/adduser.action")
    @ResponseBody
    @CrossOrigin
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

    //修改
    @RequestMapping("/updateuser.action")
    @ResponseBody
    @CrossOrigin
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
    @RequestMapping("/deletepluser.action")
    @ResponseBody
    @CrossOrigin
    public Map<String, String> deletePLStaff(String ids){
        Map<String,String> map=new HashMap<>();

        String[] idss=ids.split(",");

        int num=userService.deletePLUser(idss);

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
    @RequestMapping("/deleteuser.action")
    @ResponseBody
    @CrossOrigin
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

    //登录
    @RequestMapping("/loginuser.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> loginUser(User user, HttpSession session){
        Map<String,String> map=new HashMap<>();
        User user1=userService.loginUser(user);

        if(user1!=null){
            map.put("msg","登录成功");
            map.put("code","1");
            map.put("userid",user1.getUserid().toString());
            map.put("useraccount",user1.getUseraccount());
            map.put("userpwd",user1.getUserpwd());
            map.put("username",user1.getUsername());
            map.put("usersex",user1.getUsersex());
            map.put("userphone",user1.getUserphone());
            map.put("usersh",user1.getUsersh().toString());
        }else{
            map.put("msg","登录失败");
            map.put("code","0");
        }

        return map;
    }

    //前端注册用户
    @RequestMapping("/adduser1.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> addUser1(User user,String zhuceuserpwd2){
        Map<String,String> map=new HashMap<>();

        if(user.getUserpwd().equals(zhuceuserpwd2)){
            int num=userService.addUser1(user);

            if(num==1){
                map.put("msg","注册成功");
                map.put("code","1");
            }else{
                map.put("msg","注册失败");
                map.put("code","0");
            }
        }else{
            map.put("msg","密码不一致");
            map.put("code","2");
        }


        return map;
    }

    //查询用户账号
    @RequestMapping("/queryuseraccount.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> queryUserAccount(String useraccount){
        Map<String,String> map=new HashMap<>();

        User u=userService.queryUserAccount(useraccount);

        if(u==null){
            map.put("msg","账号可用");
            map.put("code","1");
        }else{
            map.put("msg","账号已存在");
            map.put("code","0");
        }

        return map;
    }

    //查询用户名
    @RequestMapping("/queryusername.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> queryUsername(String username){
        Map<String,String> map=new HashMap<>();

        User u=userService.queryUsername(username);

        System.out.println(u);

        if(u!=null){
            ShangHuInfo shangHuInfo=shangHuService.queryuserid(u.getUserid());
            if(shangHuInfo==null){
                map.put("msg","该用户可以注册商户");
                map.put("code","1");
                map.put("userid",u.getUserid().toString());
            }else if(shangHuInfo.getShstate().equals("已通过")){
                map.put("msg","该用户已经是商户，不可重复注册");
                map.put("code","2");
            }else if(shangHuInfo.getShstate().equals("已驳回")){
                map.put("msg","该用户申请注册商户不通过，请重新申请");
                map.put("code","3");
            }else if(shangHuInfo.getShstate().equals("未审核")){
                map.put("msg","该用户待审核中，请稍后。。。");
                map.put("code","4");
            }

        }else{
            map.put("msg","该用户不存在，请先注册");
            map.put("code","0");
        }

        return map;
    }

    //修改
    @RequestMapping("/updatesh.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> updateSH(int userid){
        Map<String,String> map=new HashMap<>();

        int num=userService.updateSH(userid);

        if(num==1){
            map.put("msg","修改成功");
            map.put("code","1");
        }else{
            map.put("msg","修改失败");
            map.put("code","0");
        }

        return map;
    }
}
