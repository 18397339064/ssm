package com.hnguigu.controller;

import com.hnguigu.service.SupplierService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    //查询供应商
    @RequestMapping("/selSupplier.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Supplier> selSupplier(Supplier supplier,
                                        @RequestParam("page")int page,
                                        @RequestParam("rows")int rows){
        return supplierService.selSupplier(supplier,page,rows);
    }

    //根据供应商id查询供应商
    @RequestMapping("/selSupplierID.action")
    @ResponseBody
    @CrossOrigin
    public Supplier selSupplierID(int supid){
        return supplierService.selSupplierId(supid);
    }

    //添加供应商
    @RequestMapping("/addSupplier.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> addSupplier(Supplier supplier){
        Map<String,String> map=new HashMap<>();
        int num=supplierService.addSupplier(supplier);

        if(num==1){
            map.put("msg","添加成功");
            map.put("code","1");
        }else{
            map.put("msg","添加失败");
            map.put("code","0");
        }
        return map;
    }

    //修改供应商
    @RequestMapping("/updSupplier.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> updSupplier(Supplier supplier){
        Map<String,String> map=new HashMap<>();
        int num=supplierService.updSupplier(supplier);

        if(num==1){
            map.put("msg","修改成功");
            map.put("code","1");
        }else{
            map.put("msg","修改失败");
            map.put("code","0");
        }
        return map;
    }

    //删除供应商
    @RequestMapping("/delSupplier.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> delSupplier(int supid){
        Map<String,String> map=new HashMap<>();
        int num=supplierService.delSupplier(supid);

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
    @RequestMapping("/delSupplierPL.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> delSupplierPL(String ids){
        Map<String,String> map=new HashMap<>();
        System.out.println(ids);

        String[] idss=ids.split(",");

        int num=supplierService.delSupplierPL(idss);

        if(num==idss.length){
            map.put("msg","删除成功");
            map.put("code","1");
        }else{
            map.put("msg","删除失败");
            map.put("code","0");
        }

        return map;
    }
}
