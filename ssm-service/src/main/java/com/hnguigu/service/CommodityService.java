package com.hnguigu.service;

import com.hnguigu.vo.Commodity;
import com.hnguigu.vo.PageVo;

import java.util.List;

public interface CommodityService {


    PageVo<Commodity> queryAll(Commodity commodity,int page,int rows);

    List<Commodity> queryRand(int id);
    
    Commodity queryById(int id);

    int add(Commodity commodity);

    int delete(int id);

    int update(Commodity category);
}
