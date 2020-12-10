package com.hnguigu.vo;

public class Province {
    private Integer provinceid;
    private String provincename;

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public Province() {
    }

    public Province(Integer provinceid, String provincename) {
        this.provinceid = provinceid;
        this.provincename = provincename;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceid=" + provinceid +
                ", provincename='" + provincename + '\'' +
                '}';
    }
}
