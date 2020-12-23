package com.hnguigu.dao;

import com.hnguigu.vo.ShoppingCar;

import java.util.List;

public interface ShoppingCarDao{
    //根据用户id查询该用户所有的商品
    public List<ShoppingCar> selShoppingCar(int id);

    //查询该商品是否相同
    public ShoppingCar selSoppingCarId(ShoppingCar shoppingCar);

    //商品相同相加
    public int updShoppingCarXT(ShoppingCar shoppingCar);

    //加入购物车
    public int addShoppingCar(ShoppingCar shoppingCar);

    //根据用户id修改数量
    public int updShoppingCarShu(ShoppingCar shoppingCar);

    //修改状态
    public int updShoppingCarZT(String[] ids);

    //删除购物车商品
    public int delShoppingCar(int id);
}
