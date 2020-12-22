package com.hnguigu.service;

import com.hnguigu.vo.Orders;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.TongJi;

import java.util.List;

public interface OrderService {

    //通过条件查询
    public PageVo<Orders> queryOrderCount(Orders order, int page, int rows);

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
}
