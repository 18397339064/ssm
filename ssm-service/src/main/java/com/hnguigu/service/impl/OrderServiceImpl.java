package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.OrderDao;
import com.hnguigu.service.OrderService;
import com.hnguigu.vo.Orders;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.TongJi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public PageVo<Orders> queryOrderCount(Orders orders, int page, int rows) {
        PageVo<Orders> pageVo = new PageVo<>();
        //放在 查询代码的前面
        PageHelper.startPage(page,rows);
        pageVo.setRows(orderDao.queryOrder(orders));

        pageVo.setTotal(orderDao.queryOrderCount(orders));

        return pageVo;
    }

    //根据月份查询商品出库统计
    @Override
    public List<TongJi> queryChuKuTotalByMonth(String month) {
        return orderDao.queryChuKuTotalByMonth(month);
    }

    //根据月份查询商品营收统计
    @Override
    public List<TongJi> queryRevenueByMonth(String month) {
        return orderDao.queryRevenueByMonth(month);
    }

    @Override
    public int updateOrder(Orders orders) {
        return orderDao.updateOrder(orders);
    }
}
