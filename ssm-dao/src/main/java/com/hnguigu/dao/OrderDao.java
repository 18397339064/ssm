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

    //订单审核出库
    public int updateOrder(Orders orders);

}
