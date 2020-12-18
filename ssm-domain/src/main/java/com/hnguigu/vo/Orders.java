package com.hnguigu.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Orders {

    private String orderid;
    private Integer comid;
    private Commodity commodity;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date ordertime;
    private Integer ordercount;
    private Integer userid;
    private User user;
    private Integer shid;
    private ShangHuInfo shangHuInfo;
    private Float totalmoney;
    private String orderstate;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(Integer ordercount) {
        this.ordercount = ordercount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShangHuInfo getShangHuInfo() {
        return shangHuInfo;
    }

    public void setShangHuInfo(ShangHuInfo shangHuInfo) {
        this.shangHuInfo = shangHuInfo;
    }

    public Float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getShid() {
        return shid;
    }

    public void setShid(Integer shid) {
        this.shid = shid;
    }

    public Orders() {
    }

    public Orders(String orderid, Integer comid, Date ordertime, Integer ordercount, Integer userid, Integer shid, Float totalmoney, String orderstate) {
        this.orderid = orderid;
        this.comid = comid;
        this.ordertime = ordertime;
        this.ordercount = ordercount;
        this.userid = userid;
        this.shid = shid;
        this.totalmoney = totalmoney;
        this.orderstate = orderstate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", comid=" + comid +
                ", commodity=" + commodity +
                ", ordertime=" + ordertime +
                ", ordercount=" + ordercount +
                ", userid=" + userid +
                ", user=" + user +
                ", shid=" + shid +
                ", shangHuInfo=" + shangHuInfo +
                ", totalmoney=" + totalmoney +
                ", orderstate='" + orderstate + '\'' +
                '}';
    }
}
