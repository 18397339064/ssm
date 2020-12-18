package com.hnguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnguigu.service.SupComService;
import com.hnguigu.vo.SupCom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SupComController {

    @Autowired
    SupComService supComService;

    //查询
    @RequestMapping("/selsupcom.action")
    @ResponseBody
    @CrossOrigin
    public String selSupCom(SupCom supCom,
                            @RequestParam(value = "page",defaultValue = "1")int page,
                            @RequestParam(value = "rows",defaultValue = "10")int rows){

        return JSONObject.toJSONString(supComService.selSupCom(supCom,page,rows));
    }

    //添加
    @RequestMapping("/addsupcom.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> addSupCom(SupCom supCom){
        Map<String,String> map=new HashMap<>();
        int num=supComService.addSupCom(supCom);

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
    @RequestMapping("/updsupcom.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> updSupCom(SupCom supCom){
        Map<String,String> map=new HashMap<>();
        int num=supComService.updSupCom(supCom);

        if(num==1){
            map.put("msg","修改成功");
            map.put("code","1");
        }else{
            map.put("msg","修改失败");
            map.put("code","0");
        }
        return map;
    }

    //删除
    @RequestMapping("/delsupcom.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> delSupCom(int supcomid){
        Map<String,String> map=new HashMap<>();
        int num=supComService.delSupCom(supcomid);

        if(num==1){
            map.put("msg","删除成功");
            map.put("code","1");
        }else{
            map.put("msg","删除失败");
            map.put("code","0");
        }
        return map;
    }

    //批量删除
    @RequestMapping("/delsupcompl.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> delSupComPL(String ids){
        Map<String,String> map=new HashMap<>();
        System.out.println(ids);

        String[] idss=ids.split(",");

        int num=supComService.delSupComPL(idss);

        if(num==idss.length){
            map.put("msg","删除成功");
            map.put("code","1");
        }else{
            map.put("msg","删除失败");
            map.put("code","0");
        }

        return map;
    }

    //查询
    @RequestMapping(value = "/querynocom.action",produces = "text/json;charset=utf-8")
    @ResponseBody
    @CrossOrigin
    public String queryNoCom(int supid){

        return JSONObject.toJSONString(supComService.queryNoCom(supid));
    }
}
