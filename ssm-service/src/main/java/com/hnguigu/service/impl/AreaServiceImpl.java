package com.hnguigu.service.impl;

import com.hnguigu.dao.AreaDao;
import com.hnguigu.service.AreaService;
import com.hnguigu.vo.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaDao areaDao;

    //根据市id 查询所有的区信息
    @Override
    public List<Area> queryAreaByCid(int cityid) {
        return areaDao.queryAreaByCid(cityid);
    }
}
