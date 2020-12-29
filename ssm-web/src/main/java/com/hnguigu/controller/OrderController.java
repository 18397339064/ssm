package com.hnguigu.controller;

import com.hnguigu.service.OrderService;
import com.hnguigu.service.StockService;
import com.hnguigu.vo.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    StockService stockService;

    //订单状态查询
    @RequestMapping("/queryordercount.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Orders> queryOrderCount(Orders orders,
                                          @RequestParam(value = "page", defaultValue = "1") int page,
                                          @RequestParam(value = "rows", defaultValue = "10") int rows){
        return orderService.queryOrderCount(orders,page,rows);
    }

    //根据月份查询商品出库统计
    @RequestMapping("/chukutongji.action")
    @ResponseBody
    @CrossOrigin
    public List<TongJi> queryChuKuTotalByMonth(@RequestParam("month") String month){
        return orderService.queryChuKuTotalByMonth(month);
    }

    //根据月份查询商品营收统计
    @RequestMapping("/revenuetongji.action")
    @ResponseBody
    @CrossOrigin
    public List<TongJi> queryRevenueByMonth(@RequestParam("month") String month){
        return orderService.queryRevenueByMonth(month);
    }


    @RequestMapping("/queryUserOrderCount.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Orders> queryUserOrderCount(Orders order,
                                              @RequestParam("userid") int userid,
                                              @RequestParam(value = "page", defaultValue = "1") int page,
                                              @RequestParam(value = "rows", defaultValue = "10") int rows){
        order.getUser().setUserid(userid);
        System.out.println("------------------------------------------------");
        System.out.println(order.getOrderstate());
        return orderService.queryUserOrderCount(order,page,rows);
    }

    //商户查询记录
    @RequestMapping("/queryShangHuOrderCount.action")
    @ResponseBody
    @CrossOrigin
    public PageVo<Orders> queryShangHuOrderCount(Orders order,
                                              @RequestParam("shid") int shid,
                                              @RequestParam(value = "page", defaultValue = "1") int page,
                                              @RequestParam(value = "rows", defaultValue = "10") int rows){
        order.getShangHuInfo().setShid(shid);
        System.out.println("------------------------------------------------");
        System.out.println(order.getOrderstate());
        return orderService.queryShangHuOrderCount(order,page,rows);
    }

    @RequestMapping("/updOrder3.action")
    @ResponseBody
    @CrossOrigin
    public String updOrder3(Orders order){
        System.out.println("------------------------------------------------");
        System.out.println(order.getOrderstate());
        int num = orderService.updOrder3(order);
        if(num==0){
            return "确认失败";
        }
        return "确认成功";
    }

    @RequestMapping("/updOrder4.action")
    @ResponseBody
    @CrossOrigin
    public String updOrder4(Orders order){
        System.out.println("------------------------------------------------");
        System.out.println(order.getOrderstate());
        int num = orderService.updOrder4(order);
        if(num==0){
            return "确认失败";
        }
        return "确认成功";
    }

    @RequestMapping("/delOrder.action")
    @ResponseBody
    @CrossOrigin
    public String delOrder(Orders order){
        System.out.println("------------------------------------------------");
        System.out.println(order.getOrderstate());
        int num = orderService.delOrder(order);
        if(num==0){
            return "删除失败";
        }
        return "删除成功";
    }

    @RequestMapping("/delOrder1.action")
    @ResponseBody
    @CrossOrigin
    public String delOrder1(Orders order){
        System.out.println("------------------------------------------------");
        System.out.println(order.getOrderstate());
        int num = orderService.delOrder1(order);
        if(num==0){
            return "取消失败";
        }
        return "取消成功";
    }

    @RequestMapping("/delOrder2.action")
    @ResponseBody
    @CrossOrigin
    public String delOrder2(Orders order){
        System.out.println("------------------------------------------------");
        System.out.println(order.getOrderstate());
        int num = orderService.delOrder2(order);
        if(num==0){
            return "删除失败";
        }
        return "删除成功";
    }


    @RequestMapping("/updateOrderState.action")
    @ResponseBody
    @CrossOrigin
    public String updateOrderState(Orders orders,
                                   @RequestParam("comid")int comid,
                                   @RequestParam("whid")int whid,
                                   @RequestParam("purcount")int purcount){

        int num=orderService.updateOrderState(orders);

        if(num!=0){

          Stock stock=new Stock();
          stock.getWarehouse().setWhid(whid);
          stock.getCommodity().setComid(comid);
          stock.setStockcount(purcount);
          stockService.janStock(stock);

          return "出库成功!";
        }
        return "出库失败!";
    }


    @RequestMapping(value = "/manyUpdateOrderStates.action",produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String manyUpdateOrderStates(@RequestBody List<CaiGouUtil> list){

        Orders orders=new Orders();
        orders.setOrderid(list.get(0).getOrderid());
        int num=orderService.updateOrderState(orders);
        System.out.println("---------------");
        System.out.println(list.toString());
        if(num!=0){

            for (CaiGouUtil s:list){

                Stock stock=new Stock();
                stock.getWarehouse().setWhid(s.getWhid());
                stock.getCommodity().setComid(s.getComid());
                stock.setStockcount(s.getPurcount());
                stockService.janStock(stock);

            }

            return "出库成功!";
        }

        return "出库失败!";
    }

    @RequestMapping("/addOrder.action")
    @ResponseBody
    @CrossOrigin
    public String addOrder(Orders order){
        System.out.println("------------------------------------------------");
        System.out.println(order.getOrderstate());
        int num = orderService.addOrder1(order);
        if(num==0){
            return "支付失败";
        }
        return "支付成功";
    }

    @RequestMapping("/updOrder2.action")
    @ResponseBody
    @CrossOrigin
    public String updOrder2(Orders order){
        System.out.println("------------------------------------------------");
        System.out.println(order.getOrderstate());
        int num = orderService.updOrder2(order);
        if(num==0){
            return "失败";
        }
        return "删除成功";
    }
}
