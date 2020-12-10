package com.hnguigu.service.impl;

import com.hnguigu.dao.ProvinceDao;
import com.hnguigu.service.ProvinceService;
import com.hnguigu.vo.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceDao provinceDao;

    //查询所有省信息
    @Override
    public List<Province> queryProvince() {
        return provinceDao.queryProvince();
    }
}
