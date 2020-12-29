package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.StockDao;
import com.hnguigu.service.StockService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //修改数量（增加）
    @Override
    public int updateCountJia(Stock stock) {
        return stockDao.updateCountJia(stock);
    }

    //查询该商品在库存中是否存在
    @Override
    public Stock queryCom(int comid,int whid) {
        return stockDao.queryCom(comid,whid);
    }

    //判断是否有某个商品在库存中有，如果有不能删除
    @Override
    public int queryStockComid(int comid) {
        return stockDao.queryStockComid(comid);
    }

    @Override
    public String queryStockCapacity(int whid) {
        return stockDao.queryStockCapacity(whid);
    }

    @Override
    public List<Stock> queryAllStockCapacity() {
        return stockDao.queryAllStockCapacity();
    }

    //查询商品的库存数量
    @Override
    public int queryStockCount(int comid) {
        return stockDao.queryStockCount(comid);
    }

    @Override
    public String queryWarehouseStockCount(int comid, int whid) {
        return stockDao.queryWarehouseStockCount(comid,whid);
    }

    @Override
    public int janStock(Stock stock) {
        return stockDao.janStock(stock);
    }

    @Override
    public List<Stock> queryAllWarehouseStockCount(int comid) {
        return stockDao.queryAllWarehouseStockCount(comid);
    }

}
