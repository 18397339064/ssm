package com.hnguigu.vo;

public class Area {

    private Integer areaid;
    private String areaname;
    private Integer cityid;
    private City city;

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Area() {
    }

    public Area(Integer areaid, String areaname, Integer cityid) {
        this.areaid = areaid;
        this.areaname = areaname;
        this.cityid = cityid;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaid=" + areaid +
                ", areaname='" + areaname + '\'' +
                ", cityid=" + cityid +
                ", city=" + city +
                '}';
    }
}
