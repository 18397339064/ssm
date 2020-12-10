package com.hnguigu.service;

import com.hnguigu.vo.Commodity;
import com.hnguigu.vo.PageVo;

public interface CommodityService {


    PageVo<Commodity> queryAll(Commodity commodity,int page,int rows);

    int add(Commodity commodity);

    int delete(int id);

    int update(Commodity category);
}
