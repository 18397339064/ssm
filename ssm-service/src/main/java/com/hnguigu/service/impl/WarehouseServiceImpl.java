package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.WarehouseDao;
import com.hnguigu.service.WarehouseService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    WarehouseDao warehouseDao;

    @Override
    //添加仓库
    public int addWarehouse(Warehouse warehouse) {
        return warehouseDao.addWarehouse(warehouse);
    }

    @Override
    //查询仓库信息
    public PageVo<Warehouse> selWarehouse(Warehouse warehouse, int page, int rows) {
        PageVo<Warehouse> pageVo = new PageVo<>();
        PageHelper.startPage(page,rows);
        pageVo.setRows(warehouseDao.selWarehouse(warehouse));
        pageVo.setTotal(warehouseDao.selWarehouseCount(warehouse));
        return pageVo;
    }

    @Override
    //根据仓库id查询
    public Warehouse selWarehouseId(int id) {
        return warehouseDao.selWarehouseId(id);
    }

    @Override
    //修改仓库
    public int updWarehouse(Warehouse warehouse) {
        return warehouseDao.updWarehouse(warehouse);
    }

    @Override
    //删除仓库
    public int delWarehouse(int id) {
        return warehouseDao.delWarehouse(id);
    }

    @Override
    //批量删除仓库
    public int delWarehousePL(String[] id) {
        return warehouseDao.delWarehousePL(id);
    }
}
