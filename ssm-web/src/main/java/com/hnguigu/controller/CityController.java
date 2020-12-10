package com.hnguigu.controller;

import com.hnguigu.service.CityService;
import com.hnguigu.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CityController{

    @Autowired
    CityService cityService;

    //根据省id 查询所有的市信息
    @RequestMapping("/querycitybypid.action")
    @ResponseBody
    @CrossOrigin
    public List<City> queryCityByPid(@RequestParam(value = "pid", defaultValue = "0") int provinceid){
        return cityService.queryCityByPid(provinceid);
    }
}
