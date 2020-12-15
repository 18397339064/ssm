package com.hnguigu.controller;

import com.hnguigu.service.OrderService;
import com.hnguigu.vo.Menu;
import com.hnguigu.vo.Orders;
import com.hnguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
