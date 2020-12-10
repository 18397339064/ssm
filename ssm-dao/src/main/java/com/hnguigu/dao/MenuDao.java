package com.hnguigu.dao;

import com.hnguigu.vo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {

    //通过条件查询
    public List<Menu> queryMenu(Menu menu);

    //通过条件查询记录
    public int queryMenuCount(Menu menu);

    //添加
    public int addMenu(Menu menu);

    //修改
    public int updateMenu(Menu menu);

    //批量删除
    public int deletePLMenu(String[] id);

    //删除
    public int deleteMenu(int id);

    //查询父菜单
    public List<Menu> queryByPid();
}