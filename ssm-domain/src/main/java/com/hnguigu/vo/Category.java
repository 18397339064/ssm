package com.hnguigu.vo;

import java.util.ArrayList;
import java.util.List;

public class Category {

   /* 8、商品分类表名：category
    商品分类字段：商品分类编号ctid、商品分类名ctname、商品分类图片ctimg*/

    private Integer ctid;
    private String ctname;
    private String ctimg;
    private List<Commodity> commodity = new ArrayList<Commodity>();


    public Category(Integer ctid, String ctname, String ctimg, List<Commodity> commodity) {
        this.ctid = ctid;
        this.ctname = ctname;
        this.ctimg = ctimg;
        this.commodity = commodity;
    }

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

    public List<Commodity> getCommodity() {
        return commodity;
    }

    public void setCommodity(List<Commodity> commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "Category{" +
                "ctid=" + ctid +
                ", ctname='" + ctname + '\'' +
                ", ctimg='" + ctimg + '\'' +
                ", commodity=" + commodity +
                '}';
    }
}
