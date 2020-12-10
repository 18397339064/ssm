package com.hnguigu.service;

import com.hnguigu.vo.Category;
import com.hnguigu.vo.PageVo;

public interface CategoryService {


    PageVo<Category> queryAll(Category category,int page,int rows);

    int add(Category category);

    int delete(int id);

    int update(Category category);
}
