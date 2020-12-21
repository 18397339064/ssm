package com.hnguigu.dao;

import com.hnguigu.vo.Category;
import com.hnguigu.vo.Commodity;

import java.util.List;

public interface CommodityDao {


    Commodity queryAllId(int id);

    List<Commodity> queryAll(Commodity commodity);

    List<Commodity> queryRand(int id);

    int queryAllCount(Commodity commodity);

    int add(Commodity commodity);

    int delete(int id);

    int update(Commodity commodity);


}
