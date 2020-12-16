package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.MenuDao;
import com.hnguigu.service.MenuService;
import com.hnguigu.vo.Menu;
import com.hnguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    //通过条件查询
    @Override
    public PageVo<Menu> queryMenuCount(Menu menu, int page, int rows) {
        PageVo<Menu> pageVo = new PageVo<>();
        //放在 查询代码的前面
        PageHelper.startPage(page,rows);
        pageVo.setRows(menuDao.queryMenu(menu));

        pageVo.setTotal(menuDao.queryMenuCount(menu));

        return pageVo;
    }

    //添加
    @Override
    public int addMenu(Menu menu) {
        return menuDao.addMenu(menu);
    }

    //修改
    @Override
    public int updateMenu(Menu menu) {
        return menuDao.updateMenu(menu);
    }

    //批量删除
    @Override
    public int deletePLMenu(String[] id) {
        return menuDao.deletePLMenu(id);
    }

    //删除
    @Override
    public int deleteMenu(int id) {
        return menuDao.deleteMenu(id);
    }

    //通过父id查询
    @Override
    public List<Menu> queryByPid() {
        return menuDao.queryByPid();
    }

    @Override
    public List<Menu> queryAllLeftMenu(int staid) {

        //查询所有的父菜单  父节点为0  菜单类型为1
        List<Menu> menus =menuDao.queryChilder(0);

        //将所有的父菜单的子菜单查询出来，绑定好
        for (Menu menu:menus) {
            List<Menu> childsmenu = menuDao.querymenuBypidandsid(staid,menu.getId().intValue());
            menu.setChildMenu(childsmenu);

        }

        return menus;

    }

    @Override
    public List<Menu> queryAuthorMenu() {
        //查询出顶级菜单
        List<Menu> list=menuDao.queryNodeType(1);

        for(Menu s:list){
            s.setLabel(s.getName());
            s.setChildren(menuDao.queryChilder(s.getId()));

            for(Menu s2:s.getChildren()){
                 s2.setLabel(s2.getName());
                 s2.setChildren(menuDao.queryChilder(s2.getId()));
                 for(Menu s3:s2.getChildren()){
                     s3.setLabel(s3.getName());
                 }
            }
        }



        return list;
    }


}
