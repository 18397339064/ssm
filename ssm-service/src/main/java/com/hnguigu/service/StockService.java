package com.hnguigu.service;

import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Stock;

import java.util.List;

public interface StockService {


    PageVo<Stock> queryAll(Stock stock,int page,int rows);

    int add(Stock stock);

    int delete(int id);

    int update(Stock stock);

    //修改数量（增加）
    public int updateCountJia(Stock stock);

    //查询该商品在库存中是否存在
    public Stock queryCom(int comid,int whid);

    //判断是否有某个商品在库存中有，如果有不能删除
    public int queryStockComid(int comid);

    //查询当前仓库的 所有商品 占用的库存
    int queryStockCapacity(int whid);

    //查询所有 仓库的 当前 已占用的库存
    List<Stock> queryAllStockCapacity();
    //查询商品的库存数量
    public int queryStockCount(int comid);

}
