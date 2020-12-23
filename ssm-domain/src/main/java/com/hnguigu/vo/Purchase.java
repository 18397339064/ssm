package com.hnguigu.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
@JsonIgnoreProperties(value="handler")
public class Purchase {

    private Integer purid;         //采购编号	Int	10	主键，自增
    private Supplier supplier=new Supplier();     // supid	供货商编号	Int	10	非空，外键
    private Commodity commodity=new Commodity();   // comid	商品编号	Int	10	非空，外键
    private Integer purcount;	   //商品数量	Int	10
    private Staff staff=new Staff();           //staffid	申请人（员工编号）	Int	10	非空，外键

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date purtime;	      //申请时间	Datatime
    private String purstate;	  //状态	Varchar	10	（未审核 /已审核）
    private Float purjinprice;	//商品进价	float	10
    private Float purzonprice;	//总价格	float	10


    public Purchase(Integer purid, Supplier supplier, Commodity commodity, Integer purcount, Staff staff, Date purtime, String purstate, Float purjinprice, Float purzonprice) {
        this.purid = purid;
        this.supplier = supplier;
        this.commodity = commodity;
        this.purcount = purcount;
        this.staff = staff;
        this.purtime = purtime;
        this.purstate = purstate;
        this.purjinprice = purjinprice;
        this.purzonprice = purzonprice;
    }

    public Purchase() {
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purid=" + purid +
                ", supplier=" + supplier +
                ", commodity=" + commodity +
                ", purcount=" + purcount +
                ", staff=" + staff +
                ", purtime=" + purtime +
                ", purstate='" + purstate + '\'' +
                ", purjinprice=" + purjinprice +
                ", purzonprice=" + purzonprice +
                '}';
    }

    public Float getPurjinprice() {
        return purjinprice;
    }

    public void setPurjinprice(Float purjinprice) {
        this.purjinprice = purjinprice;
    }

    public Float getPurzonprice() {
        return purzonprice;
    }

    public void setPurzonprice(Float purzonprice) {
        this.purzonprice = purzonprice;
    }

    public Integer getPurid() {
        return purid;
    }

    public void setPurid(Integer purid) {
        this.purid = purid;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getPurcount() {
        return purcount;
    }

    public void setPurcount(Integer purcount) {
        this.purcount = purcount;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getPurtime() {
        return purtime;
    }

    public void setPurtime(Date purtime) {
        this.purtime = purtime;
    }

    public String getPurstate() {
        return purstate;
    }

    public void setPurstate(String purstate) {
        this.purstate = purstate;
    }
}
