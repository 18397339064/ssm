package com.hnguigu.dao;

import com.hnguigu.vo.Orders;
import com.hnguigu.vo.TongJi;

import java.util.List;

public interface OrderDao {

    //通过条件查询
    public List<Orders> queryOrder(Orders order);

    //通过条件查询记录
    public int queryOrderCount(Orders order);

    /**
     * 根据月份查询商品出库统计
     * @param month
     * @return
     */
    public List<TongJi> queryChuKuTotalByMonth(String month);

    /**
     * 根据月份查询商品营收统计
     * @param month
     * @return
     */
    public List<TongJi> queryRevenueByMonth(String month);

    //查询用户订单（可根据状态查询）
    public List<Orders> queryUserOrder(Orders orders);

    //修改状态（确定收货）
    public int updOrder4(Orders orders);

    //查询用户订单（可根据状态查询）记录
    public int queryUserOrderCount(Orders orders);



    //删除订单(未付款)
    public int delOrder(Orders orders);

    //删除订单(待发货)
    public int delOrder1(Orders orders);

    //删除订单（已发货）
    public int delOrder2(Orders orders);
}
