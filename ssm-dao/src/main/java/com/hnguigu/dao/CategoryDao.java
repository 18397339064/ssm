package com.hnguigu.dao;

import com.hnguigu.vo.Category;

import java.util.List;

public interface CategoryDao {


    Category queryAllId(Category category);

    List<Category> queryAll(Category category);

    int queryAllCount(Category category);

    int add(Category category);

    int delete(int id);

    int update(Category category);


}
