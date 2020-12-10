package com.hnguigu.controller;

import com.hnguigu.service.ProvinceService;
import com.hnguigu.vo.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    //查询省信息
    @RequestMapping("/queryprovince.action")
    @ResponseBody
    @CrossOrigin
    public List<Province> queryProvince(){
        return provinceService.queryProvince();
    }
}
