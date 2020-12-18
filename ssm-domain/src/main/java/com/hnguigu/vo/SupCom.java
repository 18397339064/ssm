package com.hnguigu.vo;

public class SupCom {

    private Integer supcomid;
    private Commodity commodity=new Commodity();
    private Supplier supplier=new Supplier();
    private Float jinprice;

    public Integer getSupcomid() {
        return supcomid;
    }

    public void setSupcomid(Integer supcomid) {
        this.supcomid = supcomid;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Float getJinprice() {
        return jinprice;
    }

    public void setJinprice(Float jinprice) {
        this.jinprice = jinprice;
    }

    public SupCom() {
    }

    public SupCom(Integer supcomid, Commodity commodity, Supplier supplier, Float jinprice) {
        this.supcomid = supcomid;
        this.commodity = commodity;
        this.supplier = supplier;
        this.jinprice = jinprice;
    }

    @Override
    public String toString() {
        return "SupCom{" +
                "supcomid=" + supcomid +
                ", commodity=" + commodity +
                ", supplier=" + supplier +
                ", jinprice=" + jinprice +
                '}';
    }
}
