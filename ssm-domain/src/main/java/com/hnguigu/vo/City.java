package com.hnguigu.vo;

public class City {
    private Integer cityid;
    private String cityname;
    private Integer provinceid;
    private Province province;

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City() {
    }

    public City(Integer cityid, String cityname, Integer provinceid) {
        this.cityid = cityid;
        this.cityname = cityname;
        this.provinceid = provinceid;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityid=" + cityid +
                ", cityname='" + cityname + '\'' +
                ", provinceid=" + provinceid +
                ", province=" + province +
                '}';
    }
}
