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

    @Override
    public PageVo<ShangHuInfo> selShangHuSheng(ShangHuInfo shangHuInfo, int page, int rows) {
        PageVo<ShangHuInfo> pageVo = new PageVo<>();
        PageHelper.startPage(page,rows);
        pageVo.setRows(shangHuDao.selShangHuSheng(shangHuInfo));
        pageVo.setTotal(shangHuDao.selShangHuShengCount(shangHuInfo));
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
    public int updShangHuYes() {
        return shangHuDao.updShangHuYes();
    }

    @Override
    public int updShangHuNo() {
        return shangHuDao.updShangHuNo();
    }

    @Override
    public int delShangHu(int id) {
        return shangHuDao.delShangHu(id);
    }

    @Override
    public int delShangHuPL(int[] id) {
        return shangHuDao.delShangHuPL(id);
    }
}
