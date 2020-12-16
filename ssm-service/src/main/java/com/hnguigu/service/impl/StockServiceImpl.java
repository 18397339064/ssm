package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.StockDao;
import com.hnguigu.service.StockService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {


    @Autowired
    StockDao stockDao;

    @Override
    public PageVo<Stock> queryAll(Stock stock, int page, int rows) {

        PageVo pageVo=new PageVo();

        PageHelper.startPage(page,rows);
        pageVo.setRows(stockDao.queryAll(stock));

        pageVo.setTotal(stockDao.queryAllCount(stock));

        return pageVo;
    }

    @Override
    public int add(Stock stock) {
        return stockDao.add(stock);
    }

    @Override
    public int delete(int id) {
        return stockDao.delete(id);
    }

    @Override
    public int update(Stock stock) {
        return stockDao.update(stock);
    }
}