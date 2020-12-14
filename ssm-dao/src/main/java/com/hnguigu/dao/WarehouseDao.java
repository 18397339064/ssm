package com.hnguigu.dao;

import com.hnguigu.vo.Warehouse;

import java.util.List;

public interface WarehouseDao {
    //添加仓库
    public int addWarehouse(Warehouse warehouse);

    //查询仓库（模糊查询）
    public List<Warehouse> selWarehouse(Warehouse warehouse);

    //查询数量
    public int selWarehouseCount(Warehouse warehouse);

    //根据id查询
    public Warehouse selWarehouseId(int id);

    //修改仓库
    public int updWarehouse(Warehouse warehouse);

    //删除仓库
    public int delWarehouse(int id);

    //批量删除仓库
    public int delWarehousePL(String[] id);
}
