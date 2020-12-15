package com.hnguigu.service;

import com.hnguigu.vo.Orders;
import com.hnguigu.vo.PageVo;

import java.util.List;

public interface OrderService {

    //通过条件查询
    public PageVo<Orders> queryOrderCount(Orders order, int page, int rows);
}
