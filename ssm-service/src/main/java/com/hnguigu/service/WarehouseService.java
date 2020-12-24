package com.hnguigu.service;

import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Warehouse;

import java.util.List;

public interface WarehouseService {
    //添加仓库
    public int addWarehouse(Warehouse warehouse);

    //查询仓库（模糊查询）
    public PageVo<Warehouse> selWarehouse(Warehouse warehouse,int page,int rows);

    //根据id查询
    public Warehouse selWarehouseId(int id);

    //修改仓库
    public int updWarehouse(Warehouse warehouse);

    //删除仓库
    public int delWarehouse(int id);

    //批量删除仓库
    public int delWarehousePL(String[] id);

    //查询该商品是什么类型，放入哪个仓库
    public List<Warehouse> queryComCt(int comid);
}
