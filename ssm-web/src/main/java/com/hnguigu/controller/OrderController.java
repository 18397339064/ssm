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

}
