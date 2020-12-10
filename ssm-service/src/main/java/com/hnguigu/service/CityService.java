package com.hnguigu.service;

import com.hnguigu.vo.City;

import java.util.List;

public interface CityService {

    //根据省id 查询所有的市信息
    public List<City> queryCityByPid(int provinceid);
}
