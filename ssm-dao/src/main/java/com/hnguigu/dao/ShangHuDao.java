package com.hnguigu.dao;

import com.hnguigu.vo.ShangHuInfo;

import java.util.List;

public interface ShangHuDao {
    //注册商户
    public int addShangHu(ShangHuInfo shangHuInfo);

    //查询已审核商户(模糊查询)
    public List<ShangHuInfo> selShangHu(ShangHuInfo shangHuInfo);

    //查询已审核总数
    public int selShangHuCount(ShangHuInfo shangHuInfo);

    //查询未审核的商户
    public List<ShangHuInfo> selShangHuSheng(ShangHuInfo shangHuInfo);

    //查询未审核的总数
    public int selShangHuShengCount(ShangHuInfo shangHuInfo);

    //根据id查询商户
    public ShangHuInfo selShangHuId(int shid);

    //修改商户
    public int updShangHu(ShangHuInfo shangHuInfo);

    //审核成功
    public int updShangHuYes();

    //审核失败
    public int updShangHuNo();

    //删除商户
    public int delShangHu(int shid);

    //批量删除
    public int delShangHuPL(int[] shid);
}
