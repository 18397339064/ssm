package com.hnguigu.dao;

import com.hnguigu.vo.Category;

import java.util.List;

public interface CategoryDao {


    Category queryAllId(int id);

    List<Category> queryAll(Category category);

    List<Category> queryAll2();

    int queryAllCount(Category category);

    int add(Category category);

    int delete(int id);

    int update(Category category);


}
