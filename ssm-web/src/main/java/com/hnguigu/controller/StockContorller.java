package com.hnguigu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hnguigu.dao.StockDao;
import com.hnguigu.service.StockService;
import com.hnguigu.vo.Stock;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StockContorller {

    @Autowired
    StockService stockService;


    @RequestMapping("/queryAllStock.action")
    @ResponseBody
    @CrossOrigin
    public String queryAllStock(Stock stock,
                                @RequestParam(value = "page",defaultValue = "1")int page,
                                @RequestParam(value = "rows",defaultValue = "10")int rows){

        return JSONObject.toJSONString(stockService.queryAll(stock,page,rows));
    }


    @RequestMapping("addStock.action")
    @ResponseBody
    @CrossOrigin
    public String addStock(Stock stock){

       /* Stock stock1=stockService.queryCom(stock.getCommodity().getComid());*/

      /*  if(stock1!=null){
            Stock stock2=new Stock();
            stock2.getCommodity().setComid(stock.getCommodity().getComid());
            stock2.setStockcount(stock.getStockcount());
            stockService.updateCountJia(stock2);
        }else{
            stockService.add(stock);
        }*/

        return "添加成功!";
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
    public String updateStock(Stock stock){
        int num=stockService.update(stock);

        if(num!=0){
            return "修改成功!";
        }

        return "修改失败!";
    }

    @Autowired
    StockDao stockDao;


    @RequestMapping("/queryStockId.action")
    @ResponseBody
    @CrossOrigin
    public String queryStockId(int id){

        return JSONObject.toJSONString(stockDao.queryAllId(id));
    }

    //查询一个仓库  的库存容量 的占用
    @RequestMapping("/queryStockCapacity.action")
    @ResponseBody
    @CrossOrigin
    public String queryStockCapacity(int whid){

        return stockDao.queryStockCapacity(whid);
    }

    //查询所有 仓库的 当前 已占用的库存
    @RequestMapping("/queryAllStockCapacity.action")
    @ResponseBody
    @CrossOrigin
    public String queryAllStockCapacity(){

        return JSONObject.toJSONString(stockService.queryAllStockCapacity());
    }

    //查询商品库存数量
    @RequestMapping("/querystockcount.action")
    @ResponseBody
    @CrossOrigin
    public int queryStockCount(int comid){

        return stockService.queryStockCount(comid);
    }


    //<!--查询当前仓库 这个商品的 库存数量-->
    @RequestMapping("/queryWarehouseStockCount.action")
    @ResponseBody
    @CrossOrigin
    public String queryWarehouseStockCount(@RequestParam("comid")int comid, @RequestParam("whid")int whid){


        return stockService.queryWarehouseStockCount(comid,whid);
    }

    //查询不同仓库 商品 的库存数量
    @RequestMapping("/queryAllWarehouseStockCount.action")
    @ResponseBody
    @CrossOrigin
    public String queryAllWarehouseStockCount(@RequestParam("comid")int comid){

        return JSONObject.toJSONString(stockService.queryAllWarehouseStockCount(comid));
    }
}
