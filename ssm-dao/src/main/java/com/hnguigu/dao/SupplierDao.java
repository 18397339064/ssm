package com.hnguigu.dao;

import com.hnguigu.vo.Supplier;

import java.util.List;

public interface SupplierDao {
    //添加供应商
    public int addSupplier(Supplier supplier);

    //查询供应商（模糊查询）
    public List<Supplier> selSupplier(Supplier supplier);

    //查询总数
    public int selSupplierCount(Supplier supplier);

    //根据id查询
    public Supplier selSupplierId(int supid);

    //修改供应商
    public int updSupplier(Supplier supplier);

    //删除供应商
    public int delSupplier(int supid);

    //批量删除
    public int delSupplierPL(String[] supid);
}
