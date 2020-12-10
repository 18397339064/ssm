package com.hnguigu.dao;

import com.hnguigu.vo.Area;

import java.util.List;

public interface AreaDao {

    //根据市id 查询所有的区信息
    public List<Area> queryAreaByCid(int cityid);
}
