package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.ShangHuDao;
import com.hnguigu.service.ShangHuService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.ShangHuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShangHuServiceImpl  implements ShangHuService {
    @Autowired
    ShangHuDao shangHuDao;

    //添加商户
    @Override
    public int addShangHu(ShangHuInfo shangHuInfo) {
        return shangHuDao.addShangHu(shangHuInfo);
    }

    //查询商户
    @Override
    public PageVo<ShangHuInfo> selShangHu(ShangHuInfo shangHuInfo, int page, int rows) {
        PageVo<ShangHuInfo> pageVo = new PageVo<>();
        PageHelper.startPage(page,rows);
        pageVo.setRows(shangHuDao.selShangHu(shangHuInfo));
        pageVo.setTotal(shangHuDao.selShangHuCount(shangHuInfo));
        return pageVo;
    }

    //根据id查询
    @Override
    public ShangHuInfo selShangHuId(int id) {
        return shangHuDao.selShangHuId(id);
    }

    @Override
    public int updShangHu(ShangHuInfo shangHuInfo) {
        return shangHuDao.updShangHu(shangHuInfo);
    }

    @Override
    public int updShangHuYes(int shid) {
        return shangHuDao.updShangHuYes(shid);
    }

    @Override
    public int updShangHuNo(int shid) {
        return shangHuDao.updShangHuNo(shid);
    }

    @Override
    public int delShangHu(int shid) {
        return shangHuDao.delShangHu(shid);
    }

    @Override
    public int delShangHuPL(String[] id) {
        return shangHuDao.delShangHuPL(id);
    }

    //通过用户id查询
    @Override
    public ShangHuInfo queryuserid(int userid) {
        return shangHuDao.queryuserid(userid);
    }
}
