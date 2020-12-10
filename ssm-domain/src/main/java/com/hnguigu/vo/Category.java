package com.hnguigu.vo;

public class Category {

   /* 8、商品分类表名：category
    商品分类字段：商品分类编号ctid、商品分类名ctname、商品分类图片ctimg*/

    private Integer ctid;
    private String ctname;
    private String ctimg;


    public Category(Integer ctid, String ctname, String ctimg) {
        this.ctid = ctid;
        this.ctname = ctname;
        this.ctimg = ctimg;
    }

    public Category() {
    }

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public String getCtimg() {
        return ctimg;
    }

    public void setCtimg(String ctimg) {
        this.ctimg = ctimg;
    }
}