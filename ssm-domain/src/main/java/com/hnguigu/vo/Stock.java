package com.hnguigu.vo;

public class Stock {

    /*stockid	仓库库存编号
    whid	仓库编号
    comid	商品编号
    stockcount	库存量*/

    private Integer stockid;
    private Warehouse warehouse=new Warehouse();
    private Commodity commodity=new Commodity();
    private Integer stockcount;

    public Stock(Integer stockid, Warehouse warehouse, Commodity commodity, Integer stockcount) {
        this.stockid = stockid;
        this.warehouse = warehouse;
        this.commodity = commodity;
        this.stockcount = stockcount;
    }

    public Stock() {
    }

    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getStockcount() {
        return stockcount;
    }

    public void setStockcount(Integer stockcount) {
        this.stockcount = stockcount;
    }
}
