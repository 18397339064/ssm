package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.PurchaseDao;
import com.hnguigu.service.PurchaseService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Purchase;
import com.hnguigu.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {


    @Autowired
    PurchaseDao purchaseDao;

    @Override
    public int addPurchase(Purchase purchase) {

        return purchaseDao.addPurchase(purchase);
    }

    //查询
    @Override
    public PageVo<Purchase> queryPurCount(int page, int rows) {
        PageVo<Purchase> pageVo = new PageVo<>();
        //放在 查询代码的前面
        PageHelper.startPage(page,rows);
        pageVo.setRows(purchaseDao.queryPur());

        pageVo.setTotal(purchaseDao.queryPurCount());

        return pageVo;
    }

    //审核通过
    @Override
    public int updPurYes(int purid) {
        return purchaseDao.updPurYes(purid);
    }

    //审核驳回
    @Override
    public int updPurNo(int purid) {
        return purchaseDao.updPurNo(purid);
    }

}
