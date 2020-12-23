package com.hnguigu.service.impl;

import com.hnguigu.dao.PurchaseDao;
import com.hnguigu.service.PurchaseService;
import com.hnguigu.vo.Purchase;
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

}
