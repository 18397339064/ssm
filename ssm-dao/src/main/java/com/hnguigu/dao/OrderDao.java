package com.hnguigu.dao;

import cn.hutool.db.sql.Order;
import com.hnguigu.vo.Orders;
import com.hnguigu.vo.TongJi;
import org.apache.ibatis.annotations.Param;

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

    //查询用户订单（可根据状态查询）记录
    public int queryUserOrderCount(Orders orders);

    //查询商户订单
    public List<Orders> queryShangHuOrder(Orders orders);

    //查询商户订单记录
    public int queryShangHuOrderCount(Orders orders);

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

    //添加订单（未付款）
    public int addOrder1(Orders orders);

    //用户点击付款
    public int updOrder2(String orders);

    //查询订单编号是否存在
    public int queryZhiFuBao(Orders orders);

    /**
     * 根据月份和商户查询商户统计营收
     * @param month
     * @return
     */
    public List<TongJi> queryShangHuRevenueByMonth(@Param("month") String month,
                                                   @Param("shid") int shid);

}
