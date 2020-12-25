package com.hnguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnguigu.dao.StockDao;
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
                                @RequestParam(value = "page",defaultValue = "1")int page,
                                @RequestParam(value = "rows",defaultValue = "10")int rows){

        return JSONObject.toJSONString(stockService.queryAll(stock,page,rows));
    }


    @RequestMapping("addStock.action")
    @ResponseBody
    @CrossOrigin
    public String addStock(Stock stock){

        Stock stock1=stockService.queryCom(stock.getCommodity().getComid());

        if(stock1!=null){
            Stock stock2=new Stock();
            stock2.getCommodity().setComid(stock.getCommodity().getComid());
            stock2.setStockcount(stock.getStockcount());
            stockService.updateCountJia(stock2);
        }else{
            stockService.add(stock);
        }

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

    //查询商品库存数量
    @RequestMapping("/querystockcount.action")
    @ResponseBody
    @CrossOrigin
    public int queryStockCount(int comid){

        return stockService.queryStockCount(comid);
    }
}
