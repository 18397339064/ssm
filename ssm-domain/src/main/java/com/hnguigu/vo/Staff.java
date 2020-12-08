package com.hnguigu.vo;

public class Staff {
    private  Integer staffid;      //员工编号
    private  String staffaccount;  //员工账号
    private  String staffpwd;      //员工密码
    private  String staffname;     //员工姓名
    private  String staffsex;      //员工性别
    private  String staffphone;    //员工电话

    public Staff(Integer staffid, String staffaccount, String staffpwd, String staffname, String staffsex, String staffphone) {
        this.staffid = staffid;
        this.staffaccount = staffaccount;
        this.staffpwd = staffpwd;
        this.staffname = staffname;
        this.staffsex = staffsex;
        this.staffphone = staffphone;
    }

    public Staff() {
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public String getStaffaccount() {
        return staffaccount;
    }

    public void setStaffaccount(String staffaccount) {
        this.staffaccount = staffaccount;
    }

    public String getStaffpwd() {
        return staffpwd;
    }

    public void setStaffpwd(String staffpwd) {
        this.staffpwd = staffpwd;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffsex() {
        return staffsex;
    }

    public void setStaffsex(String staffsex) {
        this.staffsex = staffsex;
    }

    public String getStaffphone() {
        return staffphone;
    }

    public void setStaffphone(String staffphone) {
        this.staffphone = staffphone;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffid=" + staffid +
                ", staffaccount='" + staffaccount + '\'' +
                ", staffpwd='" + staffpwd + '\'' +
                ", staffname='" + staffname + '\'' +
                ", staffsex='" + staffsex + '\'' +
                ", staffphone='" + staffphone + '\'' +
                '}';
    }
}
