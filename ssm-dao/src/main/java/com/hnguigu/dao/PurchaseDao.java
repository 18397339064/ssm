package com.hnguigu.dao;

import com.hnguigu.vo.Purchase;

import java.util.List;

public interface PurchaseDao {



    //添加采购订单
    int addPurchase(Purchase purchase);

    //查询所有
    public List<Purchase> queryPur();

    //查询数量
    public int queryPurCount();

    //审核通过
    public int updPurYes(int purid);

    //审核驳回
    public int updPurNo(int purid);
}
