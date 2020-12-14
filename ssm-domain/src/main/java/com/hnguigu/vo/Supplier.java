package com.hnguigu.vo;

public class Supplier {
    private int supid;
    private String supname;
    private String suppeople;
    private String supphone;
    private String supaddress;

    public int getSupid() {
        return supid;
    }

    public void setSupid(int supid) {
        this.supid = supid;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getSuppeople() {
        return suppeople;
    }

    public void setSuppeople(String suppeople) {
        this.suppeople = suppeople;
    }

    public String getSupphone() {
        return supphone;
    }

    public void setSupphone(String supphone) {
        this.supphone = supphone;
    }

    public String getSupaddress() {
        return supaddress;
    }

    public void setSupaddress(String supaddress) {
        this.supaddress = supaddress;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supid=" + supid +
                ", supname='" + supname + '\'' +
                ", suppeople='" + suppeople + '\'' +
                ", supphone='" + supphone + '\'' +
                ", supaddress='" + supaddress + '\'' +
                '}';
    }

    public Supplier(int supid, String supname, String suppeople, String supphone, String supaddress) {
        this.supid = supid;
        this.supname = supname;
        this.suppeople = suppeople;
        this.supphone = supphone;
        this.supaddress = supaddress;
    }

    public Supplier() {
    }
}
