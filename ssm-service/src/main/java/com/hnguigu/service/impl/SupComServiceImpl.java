package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.CommodityDao;
import com.hnguigu.dao.SupComDao;
import com.hnguigu.service.SupComService;
import com.hnguigu.vo.Commodity;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.SupCom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupComServiceImpl implements SupComService {

    @Autowired
    SupComDao supComDao;

    @Autowired
    CommodityDao commodityDao;

    //添加
    @Override
    public int addSupCom(SupCom supCom) {
        return supComDao.addSupCom(supCom);
    }

    //条件查询
    @Override
    public PageVo<SupCom> selSupCom(SupCom supCom, int page, int rows) {
        PageVo pageVo=new PageVo();

        PageHelper.startPage(page,rows);
        pageVo.setRows(supComDao.selSupCom(supCom));

        pageVo.setTotal(supComDao.selSupComCount(supCom));

        return pageVo;
    }

    //id查询
    @Override
    public SupCom selSupComId(int supcomid) {
        return supComDao.selSupComId(supcomid);
    }

    //修改
    @Override
    public int updSupCom(SupCom supCom) {
        return supComDao.updSupCom(supCom);
    }

    //删除
    @Override
    public int delSupCom(int supcomid) {
        return supComDao.delSupCom(supcomid);
    }

    //批量删除
    @Override
    public int delSupComPL(String[] supcomid) {
        return supComDao.delSupComPL(supcomid);
    }

    //查询供应商里面没有哪些商品
    @Override
    public List<Commodity> queryNoCom(int supid) {
        return commodityDao.queryNoCom(supid);
    }
}
