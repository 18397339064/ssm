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

    //用户通过条件查询
    public PageVo<Orders> queryUserOrderCount(Orders order, int page, int rows);

    //商户通过条件查询
    public PageVo<Orders> queryShangHuOrderCount(Orders order, int page, int rows);

    //修改状态（待提货）
    public int updOrder3(Orders orders);

    //修改状态（确定收货）
    public int updOrder4(Orders orders);

    //删除订单(未付款)
    public int delOrder(Orders orders);

    //删除订单(待发货)
    public int delOrder1(Orders orders);

    //删除订单（已发货）
    public int delOrder2(Orders orders);
}
