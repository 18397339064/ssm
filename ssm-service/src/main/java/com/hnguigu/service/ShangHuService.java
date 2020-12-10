package com.hnguigu.service;

import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.ShangHuInfo;

import java.util.List;

public interface ShangHuService {
    //注册商户
    public int addShangHu(ShangHuInfo shangHuInfo);

    //查询已审核商户
    public PageVo<ShangHuInfo> selShangHu(ShangHuInfo shangHuInfo, int page, int rows);

    //查询未审核商户
    public PageVo<ShangHuInfo> selShangHuSheng(ShangHuInfo shangHuInfo, int page, int rows);

    //根据id查询商户
    public ShangHuInfo selShangHuId(int id);

    //修改商户
    public int updShangHu(ShangHuInfo shangHuInfo);

    //审核成功
    public int updShangHuYes();

    //审核失败
    public int updShangHuNo();

    //删除商户
    public int delShangHu(int id);

    //批量删除
    public int delShangHuPL(int[] id);
}
