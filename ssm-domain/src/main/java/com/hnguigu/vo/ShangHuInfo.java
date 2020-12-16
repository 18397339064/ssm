package com.hnguigu.vo;

public class ShangHuInfo {
    private int shid;   //商户id
    private String shname;
    private User user = new User();
    private String shaddress;
    private String shstate;

    public int getShid() {
        return shid;
    }

    public void setShid(int shid) {
        this.shid = shid;
    }

    public String getShname() {
        return shname;
    }

    public void setShname(String shname) {
        this.shname = shname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getShaddress() {
        return shaddress;
    }

    public void setShaddress(String shaddress) {
        this.shaddress = shaddress;
    }



    public String getShstate() {
        return shstate;
    }

    public void setShstate(String shstate) {
        this.shstate = shstate;
    }
    @Override
    public String toString() {
        return "ShangHuInfo{" +
                "shid=" + shid +
                ", shname='" + shname + '\'' +
                ", user=" + user +
                ", shaddress='" + shaddress + '\'' +
                ", shstate=" + shstate +
                '}';
    }

    public ShangHuInfo() {
    }

    public ShangHuInfo(int shid, String shname, User user, String shaddress, String shstate) {
        this.shid = shid;
        this.shname = shname;
        this.user = user;
        this.shaddress = shaddress;
        this.shstate = shstate;
    }
}
