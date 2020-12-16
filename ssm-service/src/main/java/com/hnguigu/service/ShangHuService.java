package com.hnguigu.service;

import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.ShangHuInfo;

import java.util.List;

public interface ShangHuService {
    //注册商户
    public int addShangHu(ShangHuInfo shangHuInfo);

    //查询商户
    public PageVo<ShangHuInfo> selShangHu(ShangHuInfo shangHuInfo, int page, int rows);

    //根据id查询商户
    public ShangHuInfo selShangHuId(int id);

    //修改商户
    public int updShangHu(ShangHuInfo shangHuInfo);

    //审核成功
    public int updShangHuYes(int shid);

    //审核失败
    public int updShangHuNo(int shid);

    //删除商户
    public int delShangHu(int shid);

    //批量删除
    public int delShangHuPL(String[] id);

    //通过用户id查询
    public ShangHuInfo queryuserid(int userid);
}
