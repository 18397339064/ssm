package com.hnguigu.service;

import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Stock;

import java.util.List;

public interface StockService {


    PageVo<Stock> queryAll(Stock stock,int page,int rows);

    int add(Stock stock);

    int delete(int id);

    int update(Stock stock);

}
