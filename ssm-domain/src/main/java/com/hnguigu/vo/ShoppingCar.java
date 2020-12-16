package com.hnguigu.vo;

public class ShoppingCar {
    private int shopid;
    private Commodity commodity = new Commodity();
    private User user = new User();
    private int shopCount;
    private String status;

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getShopCount() {
        return shopCount;
    }

    public void setShopCount(int shopCount) {
        this.shopCount = shopCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShoppingCar(int shopid, Commodity commodity, User user, int shopCount, String status) {
        this.shopid = shopid;
        this.commodity = commodity;
        this.user = user;
        this.shopCount = shopCount;
        this.status = status;
    }

    public ShoppingCar() {
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "shopid=" + shopid +
                ", commodity=" + commodity +
                ", user=" + user +
                ", shopCount=" + shopCount +
                ", status='" + status + '\'' +
                '}';
    }
}
