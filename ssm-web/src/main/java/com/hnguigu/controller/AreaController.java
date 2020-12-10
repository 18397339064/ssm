package com.hnguigu.controller;

import com.hnguigu.service.AreaService;
import com.hnguigu.vo.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AreaController {

    @Autowired
    AreaService areaService;

    //根据市id 查询所有的区信息
    @RequestMapping("/queryareabycid.action")
    @ResponseBody
    @CrossOrigin
    public List<Area> queryAreaByCid(@RequestParam(value = "cid", defaultValue = "0") int cityid){
        return areaService.queryAreaByCid(cityid);
    }

}
