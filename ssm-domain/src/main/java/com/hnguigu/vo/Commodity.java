package com.hnguigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value="handler")
public class Commodity {

   /* 7、商品表名:commodity
    商品字段：商品编号comid、商品名comname、商品分类编号ctid(商品分类名)、
    商品图片comimg、商品价格comprice、规格comsperifications、商品产地complace、商品总销售comnum*/

    private Integer comid;
    private String comname;
    private Category category=new Category();
    private String comimg;
    private Float comprice;
    private String comsperifications;
    private String complace;
    private Integer comnum;


    public Commodity(Integer comid, String comname, Category category, String comimg, Float comprice, String comsperifications, String complace, Integer comnum) {
        this.comid = comid;
        this.comname = comname;
        this.category = category;
        this.comimg = comimg;
        this.comprice = comprice;
        this.comsperifications = comsperifications;
        this.complace = complace;
        this.comnum = comnum;
    }

    public Commodity() {
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getComimg() {
        return comimg;
    }

    public void setComimg(String comimg) {
        this.comimg = comimg;
    }

    public Float getComprice() {
        return comprice;
    }

    public void setComprice(Float comprice) {
        this.comprice = comprice;
    }

    public String getComsperifications() {
        return comsperifications;
    }

    public void setComsperifications(String comsperifications) {
        this.comsperifications = comsperifications;
    }

    public String getComplace() {
        return complace;
    }

    public void setComplace(String complace) {
        this.complace = complace;
    }

    public Integer getComnum() {
        return comnum;
    }

    public void setComnum(Integer comnum) {
        this.comnum = comnum;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "comid=" + comid +
                ", comname='" + comname + '\'' +
                ", category=" + category +
                ", comimg='" + comimg + '\'' +
                ", comprice=" + comprice +
                ", comsperifications='" + comsperifications + '\'' +
                ", complace='" + complace + '\'' +
                ", comnum=" + comnum +
                '}';
    }
}
