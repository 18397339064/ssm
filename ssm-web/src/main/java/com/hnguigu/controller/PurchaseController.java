package com.hnguigu.controller;

import com.hnguigu.service.PurchaseService;
import com.hnguigu.vo.CaiGouUtil;
import com.hnguigu.vo.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
public class PurchaseController {


    @Autowired
    PurchaseService purchaseService;


    @RequestMapping(value = "/addPurchase.action",produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String addPurchase(@RequestBody List<CaiGouUtil> list){

        Purchase purchase=new Purchase();


        purchase.setPurtime(Calendar.getInstance().getTime());
        purchase.setPurstate("未审核");
        for (CaiGouUtil c:list){
            purchase.getSupplier().setSupid(c.getSupid());
            purchase.getCommodity().setComid(c.getComid());
            purchase.getStaff().setStaffid(c.getStaffid());
            purchase.setPurjinprice(c.getJinprice());
            purchase.setPurcount(c.getPurcount());
            purchase.setPurzonprice(c.getJinprice()*c.getPurcount());

            purchaseService.addPurchase(purchase);
        }

        return "成功";
    }
}
