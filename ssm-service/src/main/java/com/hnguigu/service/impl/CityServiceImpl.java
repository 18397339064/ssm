package com.hnguigu.service.impl;

import com.hnguigu.dao.CityDao;
import com.hnguigu.service.CityService;
import com.hnguigu.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

    //根据省id 查询所有的市信息
    @Override
    public List<City> queryCityByPid(int provinceid) {
        return cityDao.queryCityByPid(provinceid);
    }
}
