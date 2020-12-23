package com.hnguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.hnguigu.dao.CommodityDao;
import com.hnguigu.service.CommodityService;
import com.hnguigu.vo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class CommodityController {

    @Autowired
    CommodityService commodityService;


    @RequestMapping("/queryAllCommodity.action")
    @ResponseBody
    @CrossOrigin
    public String queryAllCommodity(Commodity commodity,
                                    @RequestParam(value = "page",defaultValue = "1") int page,
                                    @RequestParam(value = "rows",defaultValue = "10")int rows){

        return JSONObject.toJSONString(commodityService.queryAll(commodity,page,rows));
    }

    @RequestMapping(value = "/queryRand.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryRand(int id){
        return JSONObject.toJSONString(commodityService.queryRand(id));
    }

    @RequestMapping(value = "/queryById.action",produces = {"text/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String queryById(int id){
            return JSONObject.toJSONString(commodityService.queryById(id));
    }


    @RequestMapping("/addCommodity.action")
    @ResponseBody
    @CrossOrigin
    public String addCommodity(Commodity commodity,
                               @RequestParam(value = "fileImg") MultipartFile fileImg,
                               @RequestParam(value = "ctid")int ctid,
                               HttpServletRequest request) throws IOException {


        //获取上下文对象
      /*  String path=request.getServletContext().getRealPath("/img");

        String fileName=fileImg.getOriginalFilename();

        File file=new File(path);

        if(!file.exists()){
            file.mkdirs();
        }*/
        fileImg.transferTo(new File("D:\\S3项目\\day04\\vue\\img\\"+fileImg.getOriginalFilename()));

        commodity.setComimg("img/"+fileImg.getOriginalFilename());
        commodity.getCategory().setCtid(ctid);

        int num=commodityService.add(commodity);

        if(num!=0){

            return "添加成功!";
        }

        return "添加失败!";
    }


    @RequestMapping("/deleteCommodity.action")
    @ResponseBody
    @CrossOrigin
        public String deleteCommodity(String id){

        String[] ids=id.split(",");

        int num=0;
        for (int i=0;i<ids.length;i++){
           num+=commodityService.delete(Integer.parseInt(ids[i]));
        }

        if(num!=0){
            return "删除成功!";
        }
        return "删除失败!";
    }

    @RequestMapping("/updateCommodity.action")
    @ResponseBody
    @CrossOrigin
    public String updateCommodity(Commodity commodity,
                                  @RequestParam(value = "fileImg") MultipartFile fileImg,
                                  @RequestParam(value = "ctid")int ctid,
                                  HttpServletRequest request) throws IOException {


        //获取上下文对象
/*        String path=request.getServletContext().getRealPath("/img");

        String fileName=fileImg.getOriginalFilename();

        File file=new File(path);

        if(!file.exists()){
            file.mkdirs();
        }*/
        fileImg.transferTo(new File("D:\\S3项目\\day04\\vue\\img\\"+fileImg.getOriginalFilename()));

        commodity.setComimg("img/"+fileImg.getOriginalFilename());
        commodity.getCategory().setCtid(ctid);

        int num=commodityService.update(commodity);

        if(num!=0){
            return "修改成功!";
        }

        return "修改失败!";
    }


    @Autowired
    CommodityDao commodityDao;
    @RequestMapping("/queryAllCommodityqq.action")
    @ResponseBody
    @CrossOrigin
    public String querAllCommodityqq(){

        return JSONObject.toJSONString(commodityDao.queryAll(new Commodity()));
    }
}
