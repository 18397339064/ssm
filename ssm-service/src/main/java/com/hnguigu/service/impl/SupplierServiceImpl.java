package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.SupplierDao;
import com.hnguigu.service.SupplierService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierDao supplierDao;

    @Override
    //添加供应商
    public int addSupplier(Supplier supplier) {
        return supplierDao.addSupplier(supplier);
    }

    @Override
    //查询供应商
    public PageVo<Supplier> selSupplier(Supplier supplier, int page, int rows) {
        PageVo<Supplier> pageVo = new PageVo<>();
        PageHelper.startPage(page,rows);
        pageVo.setRows(supplierDao.selSupplier(supplier));
        pageVo.setTotal(supplierDao.selSupplierCount(supplier));
        return pageVo;
    }

    @Override
    //根据id查询供应商
    public Supplier selSupplierId(int id) {
        return supplierDao.selSupplierId(id);
    }

    @Override
    //修改供应商
    public int updSupplier(Supplier supplier) {
        return supplierDao.updSupplier(supplier);
    }

    @Override
    //删除供应商
    public int delSupplier(int id) {
        return supplierDao.delSupplier(id);
    }

    @Override
    //批量删除供应商
    public int delSupplierPL(String[] id) {
        return supplierDao.delSupplierPL(id);
    }
}
