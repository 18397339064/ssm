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

    //判断是否有某个商品在库存中有，如果有不能删除
    public int queryStockComid(int comid);

    //审核出库成功  减少库存
    int janStock();

}
