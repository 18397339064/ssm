package com.hnguigu.controller;

import com.hnguigu.dao.WarehouseDao;
import com.hnguigu.service.WarehouseService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Supplier;
import com.hnguigu.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    //查询仓库
    @RequestMapping("/selWarehouse.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Warehouse> selWarehouse(Warehouse warehouse,
                                          @RequestParam(value = "page",defaultValue = "1")int page,
                                          @RequestParam(value = "rows",defaultValue = "10")int rows){
        return warehouseService.selWarehouse(warehouse,page,rows);
    }

    //根据仓库id查询仓库
    @RequestMapping("/selWarehouseID.action")
    @ResponseBody
    @CrossOrigin
    public Warehouse selWarehouseID(int whid){
        return warehouseService.selWarehouseId(whid);
    }

    //添加仓库
    @RequestMapping("/addWarehouse.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> addWarehouse(Warehouse warehouse){
        Map<String,String> map=new HashMap<>();
        int num=warehouseService.addWarehouse(warehouse);

        if(num==1){
            map.put("msg","添加成功");
            map.put("code","1");
        }else{
            map.put("msg","添加失败");
            map.put("code","0");
        }
        return map;
    }

    //修改仓库
    @RequestMapping("/updWarehouse.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> updWarehouse(Warehouse warehouse){
        Map<String,String> map=new HashMap<>();
        int num=warehouseService.updWarehouse(warehouse);

        if(num==1){
            map.put("msg","修改成功");
            map.put("code","1");
        }else{
            map.put("msg","修改失败");
            map.put("code","0");
        }
        return map;
    }

    //删除仓库
    @RequestMapping("/delWarehouse.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> delWarehouse(int whid){
        Map<String,String> map=new HashMap<>();
        int num=warehouseService.delWarehouse(whid);

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
    @RequestMapping("/delWarehousePL.action")
    @ResponseBody
    @CrossOrigin
    public Map<String,String> delWarehousePL(String ids){
        Map<String,String> map=new HashMap<>();
        System.out.println(ids);

        String[] idss=ids.split(",");

        int num=warehouseService.delWarehousePL(idss);

        if(num==idss.length){
            map.put("msg","删除成功");
            map.put("code","1");
        }else{
            map.put("msg","删除失败");
            map.put("code","0");
        }

        return map;
    }

    @Autowired
    WarehouseDao warehouseDao;


    @RequestMapping("/queryAllWarehouse.action")
    @ResponseBody
    @CrossOrigin
    public List<Warehouse> queryAllWarehouse(){

        return warehouseDao.selWarehouse(new Warehouse());
    }

}
