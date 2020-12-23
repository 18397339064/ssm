package com.hnguigu.controller;

import com.hnguigu.service.ShoppingCarService;
import com.hnguigu.vo.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ShoppingController {
    @Autowired
    ShoppingCarService shoppingCarService;

    @RequestMapping("/selShoppingCar.action")
    @ResponseBody
    @CrossOrigin
    public List<ShoppingCar> selShoppingCar(@RequestParam("userid")int userid){
        return shoppingCarService.selShoppingCar(userid);
    }

    @RequestMapping("/addShoppingCar.action")
    @ResponseBody
    @CrossOrigin
    public String addShoppingCar(@RequestParam("userid")int userid,
                                 @RequestParam("comid")int comid,
                                 ShoppingCar shoppingCar){
        shoppingCar.getCommodity().setComid(comid);
        shoppingCar.getUser().setUserid(userid);
        ShoppingCar shoppingCar1 = new ShoppingCar();
        shoppingCar1 = shoppingCarService.selShoppingCarId(shoppingCar);
        int num = 0;
        if(shoppingCar1==null) {
            num = shoppingCarService.addShoppingCar(shoppingCar);
        }else{
            shoppingCar.setShopid(shoppingCar1.getShopid());
            num = shoppingCarService.updShoppingCarXT(shoppingCar);
        }
        if(num==1){
            return "添加成功";
        }
        return "添加失败";
    }

    @RequestMapping("/updShoppingCarShu.action")
    @ResponseBody
    @CrossOrigin
    public String updShoppingCarShu(ShoppingCar shoppingCar){
        int num = shoppingCarService.updShoppingCarShu(shoppingCar);
        if(num==1){
            return "修改数量成功";
        }
        return "修改数量失败";
    }

    @RequestMapping("/updShoppingCarZT.action")
    @ResponseBody
    @CrossOrigin
    public String updShoppingCarZT(String ids){

        String[] idss=ids.split(",");

        int num=shoppingCarService.updShoppingCarZT(idss);
        if(num==idss.length){
            return "修改状态成功";
        }
        return "修改状态失败";
    }

    @RequestMapping("/delShoppingCar.action")
    @ResponseBody
    @CrossOrigin
    public String delShoppingCar(int id){
        int num = shoppingCarService.delShoppingCar(id);
        if(num==1){
            return "删除成功";
        }
        return "删除失败";
    }
}
