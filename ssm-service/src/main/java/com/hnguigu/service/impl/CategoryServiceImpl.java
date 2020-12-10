package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.CategoryDao;
import com.hnguigu.service.CategoryService;
import com.hnguigu.vo.Category;
import com.hnguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;


    @Override
    public PageVo<Category> queryAll(Category category, int page, int rows) {

        PageVo<Category> pageVo=new PageVo<Category>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(categoryDao.queryAll(category));

        pageVo.setTotal(categoryDao.queryAllCount(category));

        return pageVo;
    }

    @Override
    public int add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public int delete(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public int update(Category category) {
        return categoryDao.update(category);
    }
}
