package com.hnguigu.vo;

public class User {
    private Integer userid;    //用户id
    private String useraccount; //用户账号
    private  String userpwd;   //用户密码
    private  String username;  //用户姓名
    private  String usersex;   //用户性别
    private  String userphone; //电话号码
    private  Integer usersh;    //判断是否为商户

    public User(Integer userid, String useraccount, String userpwd, String username, String usersex, String userphone,Integer usersh) {
        this.userid = userid;
        this.useraccount = useraccount;
        this.userpwd = userpwd;
        this.username = username;
        this.usersex = usersex;
        this.userphone = userphone;
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

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
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
                ", useraccount='" + useraccount + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", username='" + username + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userphone='" + userphone + '\'' +
                ", usersh=" + usersh +
                '}';
    }
}
