package com.hnguigu.controller;

import com.hnguigu.service.ShangHuService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.ShangHuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ShangHuController {
    @Autowired
    ShangHuService shangHuService;

    //查询商户
    @RequestMapping(value = "/selShangHu.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<ShangHuInfo> selShangHu(ShangHuInfo shangHuInfo,
                                          @RequestParam(value = "page", defaultValue = "1") int page,
                                          @RequestParam(value = "rows", defaultValue = "10") int rows){
        return shangHuService.selShangHu(shangHuInfo,page,rows);
    }

    //根据id查询
    @RequestMapping(value = "/selShangHuId.action")
    @ResponseBody
    @CrossOrigin
    public ShangHuInfo selShangHuId(int id){
        return shangHuService.selShangHuId(id);
    }

    //注册商户
    @RequestMapping(value = "/addShangHu.action")
    @ResponseBody
    @CrossOrigin
    public String addShangHu(ShangHuInfo shangHuInfo){
        int num =  shangHuService.addShangHu(shangHuInfo);
        if(num==1){
            return "添加成功";
        }
        return "添加失败";
    }

    //修改商户
    @RequestMapping(value = "/updShangHu.action")
    @ResponseBody
    @CrossOrigin
    public String updShangHu(ShangHuInfo shangHuInfo){
        int num =  shangHuService.updShangHu(shangHuInfo);
        if(num==1){
            return "修改成功";
        }
        return "修改失败";
    }

    //审核成功
    @RequestMapping(value = "/updShangHuYes.action")
    @ResponseBody
    @CrossOrigin
    public String updShangHuYes(int shid){
        int num =  shangHuService.updShangHuYes(shid);
        if(num==1){
            return "已通过";
        }
        return "通过失败";
    }

    //修改商户
    @RequestMapping(value = "/updShangHuNo.action")
    @ResponseBody
    @CrossOrigin
    public String updShangHuNo(int shid){
        int num =  shangHuService.updShangHuNo(shid);
        if(num==1){
            return "已驳回";
        }
        return "驳回失败";
    }

    //批量删除商户
    //批量删除
    @RequestMapping("/delShangHuPL.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> deleteShangHuPL(String ids){
        Map<String,String> map=new HashMap<>();
        String[] idss=ids.split(",");

        int num=shangHuService.delShangHuPL(idss);

        if(num==idss.length){
            map.put("msg","删除成功");
            map.put("code","1");
        }else{
            map.put("msg","删除失败");
            map.put("code","0");
        }

        return map;
    }

    //删除商户
    @RequestMapping(value = "/delShangHu.action")
    @ResponseBody
    @CrossOrigin
    public String delShangHu(int shid){
        int num =  shangHuService.delShangHu(shid);
        if(num==1){
            return "删除成功";
        }
        return "删除失败";
    }
}
