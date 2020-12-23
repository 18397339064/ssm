package com.hnguigu.controller;

import com.hnguigu.service.CommodityService;
import com.hnguigu.service.PurchaseService;
import com.hnguigu.service.StockService;
import com.hnguigu.service.WarehouseService;
import com.hnguigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
public class PurchaseController {


    @Autowired
    PurchaseService purchaseService;

    @Autowired
    CommodityService commodityService;

    @Autowired
    StockService stockService;

    @Autowired
    WarehouseService warehouseService;

    @RequestMapping(value = "/addPurchase.action",produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String addPurchase(@RequestBody List<CaiGouUtil> list){

        Purchase purchase=new Purchase();


        purchase.setPurtime(Calendar.getInstance().getTime());
        purchase.setPurstate("未审核");
        for (CaiGouUtil c:list){
            purchase.getSupplier().setSupid(c.getSupid());
            purchase.getCommodity().setComid(c.getComid());
            purchase.getStaff().setStaffid(c.getStaffid());
            purchase.setPurjinprice(c.getJinprice());
            purchase.setPurcount(c.getPurcount());
            purchase.setPurzonprice(c.getJinprice()*c.getPurcount());

            purchaseService.addPurchase(purchase);
        }

        return "申请成功";
    }

    //查询
    @RequestMapping("/querypurcount.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Purchase> queryPurCount(@RequestParam(value = "page", defaultValue = "1") int page,
                                          @RequestParam(value = "rows", defaultValue = "10") int rows){
        return purchaseService.queryPurCount(page,rows);
    }

    //审核成功
    @RequestMapping(value = "/updPurYes.action")
    @ResponseBody
    @CrossOrigin
    public String updPurYes(@RequestParam(value = "purid") int purid,
                            @RequestParam(value = "comid") int comid,
                            @RequestParam(value = "purcount") int purcount){

        /*Warehouse warehouse=warehouseService.queryComCt(comid);
        System.out.println(warehouse);

        System.out.println("purid:"+purid+",comid:"+comid+",purcount:"+purcount);*/
        int num =  purchaseService.updPurYes(purid);
        if(num==1){
            //加到库存里面
            //如果库存里面有该商品就直接加数量，没有该商品就加商品
            Stock stock=stockService.queryCom(comid);
            if(stock!=null){
                Stock stock2=new Stock();
                stock2.getCommodity().setComid(comid);
                stock2.setStockcount(purcount);
                stockService.updateCountJia(stock2);
            }else{
                //查询该商品是什么类型，放入哪个仓库
                Warehouse warehouse=warehouseService.queryComCt(comid);
                Stock stock1=new Stock();
                stock1.getWarehouse().setWhid(warehouse.getWhid());
                stock1.getCommodity().setComid(comid);
                stock1.setStockcount(purcount);
                stockService.add(stock1);
            }

            return "已通过";
        }
        return "通过失败";
    }

    //审核失败
    @RequestMapping(value = "/updPurNo.action")
    @ResponseBody
    @CrossOrigin
    public String updPurNo(@RequestParam(value = "purid") int purid){
        int num =  purchaseService.updPurNo(purid);
        if(num==1){
            return "已驳回";
        }
        return "驳回失败";
    }

}
