package com.hnguigu.controller;

import com.hnguigu.service.CategoryService;
import com.hnguigu.vo.Category;
import com.hnguigu.vo.Commodity;
import com.hnguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @RequestMapping("/queryAllCategory.action")
    @ResponseBody
    public PageVo queryAllCategory(Category category, int page, int rows){

        return categoryService.queryAll(category,page,rows);
    }

}
