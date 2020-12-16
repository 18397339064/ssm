package com.hnguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnguigu.service.StockService;
import com.hnguigu.vo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StockContorller {

    @Autowired
    StockService stockService;


    @RequestMapping("/queryAllStock.action")
    @ResponseBody
    @CrossOrigin
    public String queryAllStock(Stock stock,
                                @RequestParam("page")int page,
                                @RequestParam("rows")int rows){

        return JSONObject.toJSONString(stockService.queryAll(stock,page,rows));
    }


    @RequestMapping("addStock.action")
    @ResponseBody
    @CrossOrigin
    public String addStock(Stock stock,
                           @RequestParam("whid")int whid,
                           @RequestParam("comid")int comid){

        stock.getWarehouse().setWhid(whid);

        stock.getCommodity().setComid(comid);
        int num=stockService.add(stock);

        if(num!=0){

            return "添加成功";
        }

        return "添加失败";
    }

    @RequestMapping("/deleteStock.action")
    @ResponseBody
    @CrossOrigin
    public String deleteStock(String id){

        String[] ids=id.split(",");

        int num=0;
        for (int i=0;i<ids.length;i++){

            num+=stockService.delete(Integer.parseInt(ids[i]));

        }

        if(num!=0){
            return "删除成功!";
        }

          return "删除失败!";
    }


    @RequestMapping("/updateStock.action")
    @ResponseBody
    @CrossOrigin
    public String updateStock(Stock stock,
                              @RequestParam("whid")int whid,
                              @RequestParam("comid")int comid){

        stock.getWarehouse().setWhid(whid);

        stock.getCommodity().setComid(comid);
        int num=stockService.update(stock);

        if(num!=0){
            return "添加成功!";
        }

        return "添加失败!";
    }
}
