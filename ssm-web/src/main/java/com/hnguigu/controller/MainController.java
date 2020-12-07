package com.hnguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping ( "/check")
    @ResponseBody
    @CrossOrigin
    public String check () {
        String str="SSM vue前后端框架搭建成功";
        return str;
    }
}
