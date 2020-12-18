package com.hnguigu.service;

import com.hnguigu.vo.Commodity;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.SupCom;

import java.util.List;

public interface SupComService {

    //添加
    public int addSupCom(SupCom supCom);

    //查询（模糊查询）
    public PageVo<SupCom> selSupCom(SupCom supCom,int page,int rows);

    //根据id查询
    public SupCom selSupComId(int supcomid);

    //修改
    public int updSupCom(SupCom supCom);

    //删除
    public int delSupCom(int supcomid);

    //批量删除
    public int delSupComPL(String[] supcomid);

    //查询供应商里面没有哪些商品
    public List<Commodity> queryNoCom(int supid);
}
