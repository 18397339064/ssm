package com.hnguigu.service;

import com.hnguigu.vo.ShoppingCar;

import java.util.List;

public interface ShoppingCarService {
    //根据用户id查询该用户所有的商品
    public List<ShoppingCar> selShoppingCar(int id);

    //根据用户id修改数量
    public int updShoppingCarShu(ShoppingCar shoppingCar);

    //修改状态
    public int updShoppingCarZT(String[] ids);

    //删除购物车商品
    public int delShoppingCar(int id);
}
