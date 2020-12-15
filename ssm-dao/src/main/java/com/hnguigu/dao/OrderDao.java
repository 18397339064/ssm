package com.hnguigu.dao;

import com.hnguigu.vo.Orders;

import java.util.List;

public interface OrderDao {

    //通过条件查询
    public List<Orders> queryOrder(Orders order);

    //通过条件查询记录
    public int queryOrderCount(Orders order);
}
