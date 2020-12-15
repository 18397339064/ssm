package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.OrderDao;
import com.hnguigu.service.OrderService;
import com.hnguigu.vo.Orders;
import com.hnguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
