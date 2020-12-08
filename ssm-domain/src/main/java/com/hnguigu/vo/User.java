package com.hnguigu.vo;

public class User {
    private Integer userid;    //用户id
    private String useraccoun; //用户账号
    private  String userpwd;   //用户密码
    private  String username;  //用户姓名
    private  String usersex;   //用户性别
    private  String userphone; //电话号码
    private  String useraddress;//用户地址
    private  Integer usersh;    //判断是否为商户

    public User(Integer userid, String useraccoun, String userpwd, String username, String usersex, String userphone, String useraddress, Integer usersh) {
        this.userid = userid;
        this.useraccoun = useraccoun;
        this.userpwd = userpwd;
        this.username = username;
        this.usersex = usersex;
        this.userphone = userphone;
        this.useraddress = useraddress;
        this.usersh = usersh;
    }

    public User() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUseraccoun() {
        return useraccoun;
    }

    public void setUseraccoun(String useraccoun) {
        this.useraccoun = useraccoun;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public Integer getUsersh() {
        return usersh;
    }

    public void setUsersh(Integer usersh) {
        this.usersh = usersh;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", useraccoun='" + useraccoun + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", username='" + username + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userphone='" + userphone + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", usersh=" + usersh +
                '}';
    }
}
