package com.hnguigu.service;

import com.hnguigu.vo.Menu;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Purchase;

public interface PurchaseService {

    //添加采购订单
    int addPurchase(Purchase purchase);

    //查询
    public PageVo<Purchase> queryPurCount(int page, int rows);

    //审核通过
    public int updPurYes(int purid);

    //审核驳回
    public int updPurNo(int purid);

}
