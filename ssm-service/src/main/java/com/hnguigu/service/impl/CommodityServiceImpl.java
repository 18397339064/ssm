package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.CategoryDao;
import com.hnguigu.dao.CommodityDao;
import com.hnguigu.service.CategoryService;
import com.hnguigu.service.CommodityService;
import com.hnguigu.vo.Category;
import com.hnguigu.vo.Commodity;
import com.hnguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityDao commodityDao;


    @Override
    public PageVo<Commodity> queryAll(Commodity commodity, int page, int rows) {
        PageVo<Commodity> pageVo=new PageVo<Commodity>();

        PageHelper.startPage(page,rows);
       pageVo.setRows(commodityDao.queryAll(commodity));

        pageVo.setTotal(commodityDao.queryAllCount(commodity));

        return pageVo;
    }

    @Override
    public int add(Commodity commodity) {
        return commodityDao.add(commodity);
    }

    @Override
    public int delete(int id) {
        return commodityDao.delete(id);
    }

    @Override
    public int update(Commodity commodity) {
        return commodityDao.update(commodity);
    }
}
