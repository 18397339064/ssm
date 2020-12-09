package com.hnguigu.controller;

import com.hnguigu.service.ShangHuService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.ShangHuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShangHuController {
    @Autowired
    ShangHuService shangHuService;

    //查询已审核商户
    @RequestMapping(value = "/selShangHu.action")
    @ResponseBody
    public PageVo<ShangHuInfo> selShangHu(ShangHuInfo shangHuInfo,
                                          @RequestParam("page")int page,
                                          @RequestParam("rows")int rows){
        return shangHuService.selShangHu(shangHuInfo,page,rows);
    }

    //查询未审核商户
    @RequestMapping(value = "/selShangHuSheng.action")
    @ResponseBody
    public PageVo<ShangHuInfo> selShangHuSheng(ShangHuInfo shangHuInfo,
                                          @RequestParam("page")int page,
                                          @RequestParam("rows")int rows){
        return shangHuService.selShangHuSheng(shangHuInfo,page,rows);
    }

    //根据id查询
    @RequestMapping(value = "/selShangHuId.action")
    @ResponseBody
    public ShangHuInfo selShangHuId(int id){
        return shangHuService.selShangHuId(id);
    }

    //注册商户
    @RequestMapping(value = "/addShangHu.action")
    @ResponseBody
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
    public String updShangHuYes(){
        int num =  shangHuService.updShangHuYes();
        if(num==1){
            return "已审核";
        }
        return "修改失败";
    }

    //修改商户
    @RequestMapping(value = "/updShangHuNo.action")
    @ResponseBody
    public String updShangHuNo(){
        int num =  shangHuService.updShangHuNo();
        if(num==1){
            return "已驳回";
        }
        return "修改失败";
    }

    //批量删除商户
    //批量删除
    @RequestMapping(value = "/delShangHuPL.action/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteShangHuPL(@PathVariable String ids){
        String[] idss=ids.split(",");
        int[] ints=new int[idss.length];
        for(int i=0;i<idss.length;i++){
            ints[i]=Integer.parseInt(idss[i]);
        }

        int num=shangHuService.delShangHuPL(ints);

        return num>0;
    }

    //删除商户
    @RequestMapping(value = "/delShangHu.action")
    @ResponseBody
    public String delShangHu(int id){
        int num =  shangHuService.delShangHu(id);
        if(num==1){
            return "删除成功";
        }
        return "删除失败";
    }
}
