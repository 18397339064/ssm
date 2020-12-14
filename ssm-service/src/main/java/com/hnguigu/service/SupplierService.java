package com.hnguigu.service;

import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Supplier;

import java.util.List;

public interface SupplierService {
    //添加供应商
    public int addSupplier(Supplier supplier);

    //查询供应商（模糊查询）
    public PageVo<Supplier> selSupplier(Supplier supplier,int page,int rows);

    //根据id查询
    public Supplier selSupplierId(int id);

    //修改供应商
    public int updSupplier(Supplier supplier);

    //删除供应商
    public int delSupplier(int id);

    //批量删除
    public int delSupplierPL(String[] id);
}
