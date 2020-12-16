package com.hnguigu.dao;

import com.hnguigu.vo.ShangHuInfo;

import java.util.List;

public interface ShangHuDao {
    //注册商户
    public int addShangHu(ShangHuInfo shangHuInfo);

    //查询商户(模糊查询)
    public List<ShangHuInfo> selShangHu(ShangHuInfo shangHuInfo);

    //查询总数
    public int selShangHuCount(ShangHuInfo shangHuInfo);

    //根据id查询商户
    public ShangHuInfo selShangHuId(int shid);

    //修改商户
    public int updShangHu(ShangHuInfo shangHuInfo);

    //审核成功
    public int updShangHuYes(int shid);

    //审核失败
    public int updShangHuNo(int shid);

    //删除商户
    public int delShangHu(int shid);

    //批量删除
    public int delShangHuPL(String[] shid);

    //通过用户id查询
    public ShangHuInfo queryuserid(int userid);
}
