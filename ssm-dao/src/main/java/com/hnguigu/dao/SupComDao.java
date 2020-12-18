package com.hnguigu.dao;

import com.hnguigu.vo.Commodity;
import com.hnguigu.vo.Stock;
import com.hnguigu.vo.SupCom;
import com.hnguigu.vo.Supplier;

import java.util.List;

public interface SupComDao {

    //添加
    public int addSupCom(SupCom supCom);

    //查询（模糊查询）
    public List<SupCom> selSupCom(SupCom supCom);

    //查询总数
    public int selSupComCount(SupCom supCom);

    //根据id查询
    public SupCom selSupComId(int supcomid);

    //修改
    public int updSupCom(SupCom supCom);

    //删除
    public int delSupCom(int supcomid);

    //批量删除
    public int delSupComPL(String[] supcomid);


}
