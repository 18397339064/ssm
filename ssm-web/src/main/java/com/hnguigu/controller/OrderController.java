package com.hnguigu.controller;

import com.hnguigu.service.OrderService;
import com.hnguigu.vo.Menu;
import com.hnguigu.vo.Orders;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.TongJi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

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
}
