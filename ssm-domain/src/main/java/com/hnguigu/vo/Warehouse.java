package com.hnguigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value="handler")
public class Warehouse {
    private int whid;
    private String whname;
    private String whaddress;
    private Category category = new Category();
    private Commodity commodity=new Commodity();
    private Integer capacity;

    public int getWhid() {
        return whid;
    }

    public void setWhid(int whid) {
        this.whid = whid;
    }

    public String getWhname() {
        return whname;
    }

    public void setWhname(String whname) {
        this.whname = whname;
    }

    public String getWhaddress() {
        return whaddress;
    }

    public void setWhaddress(String whaddress) {
        this.whaddress = whaddress;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Warehouse(int whid, String whname, String whaddress, Category category, Commodity commodity, Integer capacity) {
        this.whid = whid;
        this.whname = whname;
        this.whaddress = whaddress;
        this.category = category;
        this.commodity = commodity;
        this.capacity = capacity;
    }

    public Warehouse() {
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "whid=" + whid +
                ", whname='" + whname + '\'' +
                ", whaddress='" + whaddress + '\'' +
                ", category=" + category +
                ", commodity=" + commodity +
                ", capacity=" + capacity +
                '}';
    }
}
