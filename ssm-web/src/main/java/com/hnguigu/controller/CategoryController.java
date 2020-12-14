package com.hnguigu.controller;

import com.hnguigu.service.CategoryService;
import com.hnguigu.vo.Category;
import com.hnguigu.vo.Commodity;
import com.hnguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    //条件查询加分页
    @RequestMapping("/queryAllCategory.action")
    @ResponseBody
    @CrossOrigin
    public PageVo queryAllCategory(Category category,
                                   @RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "rows",defaultValue = "10")int rows){

        return categoryService.queryAll(category,page,rows);
    }


    //添加
    @RequestMapping("/addCategory.action")
    @ResponseBody
    @CrossOrigin
    public String addCategory(Category category){

        int num=categoryService.add(category);

        if(num!=0){

            return "添加成功!";
        }

        return "添加失败!";
    }

    @RequestMapping("/deleteCategory.action")
    @ResponseBody
    @CrossOrigin
    public String deleteCategory(String id){

        String[] ids=id.split(",");

        int num=0;
        for (int i=0;i<ids.length;i++){
            num+=categoryService.delete(Integer.parseInt(ids[i]));
        }


        if(num!=0){
            return "删除成功!";
        }

        return "删除失败!";
    }


    @RequestMapping("/updateCategory.action")
    @ResponseBody
    @CrossOrigin
    public String updateCategory(Category category){


        int num=categoryService.update(category);

        if(num!=0){

            return "修改成功!";
        }

        return "修改失败!";
    }


}
