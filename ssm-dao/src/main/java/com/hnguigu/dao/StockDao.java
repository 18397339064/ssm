package com.hnguigu.dao;

import com.hnguigu.vo.Stock;

import java.util.List;

public interface StockDao {


    Stock queryAllId(int id);

    List<Stock> queryAll(Stock stock);

    int queryAllCount(Stock stock);

    int add(Stock stock);

    int delete(int id);

    int update(Stock stock);

    //修改数量（增加）
    public int updateCountJia(Stock stock);

    //查询该商品在库存中是否存在
    public Stock queryCom(int comid);

}
