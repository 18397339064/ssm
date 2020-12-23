package com.hnguigu.service.impl;

import com.hnguigu.dao.ShoppingCarDao;
import com.hnguigu.service.ShoppingCarService;
import com.hnguigu.vo.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Autowired
    ShoppingCarDao shoppingCarDao;

    @Override
    public List<ShoppingCar> selShoppingCar(int id) {
        return shoppingCarDao.selShoppingCar(id);
    }

    @Override
    public ShoppingCar selShoppingCarId(ShoppingCar shoppingCar) {
        return shoppingCarDao.selSoppingCarId(shoppingCar);
    }

    @Override
    public int updShoppingCarXT(ShoppingCar shoppingCar) {
        return shoppingCarDao.updShoppingCarXT(shoppingCar);
    }

    @Override
    public int addShoppingCar(ShoppingCar shoppingCar) {
        return shoppingCarDao.addShoppingCar(shoppingCar);
    }

    @Override
    public int updShoppingCarShu(ShoppingCar shoppingCar) {
        return shoppingCarDao.updShoppingCarShu(shoppingCar);
    }

    @Override
    public int updShoppingCarZT(String[] ids) {
        return shoppingCarDao.updShoppingCarZT(ids);
    }

    @Override
    public int delShoppingCar(int id) {
        return shoppingCarDao.delShoppingCar(id);
    }
}
