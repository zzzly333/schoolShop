package com.cqut.controller;

import com.cqut.domain.goodsType;
import com.cqut.service.goodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class goodsTypeController {
    @Autowired
    private goodsTypeService goodsTypeService;

    @ResponseBody
    @RequestMapping(value = "/getGoodsType")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<goodsType> getGoodsType(String pagenum,String pagesize) throws Exception {
        System.out.println(pagenum+"   "+pagesize);
        int begin = (Integer.parseInt(pagenum)-1)*Integer.parseInt(pagesize);
        int end = Integer.parseInt(pagesize);
        Map map = new HashMap();
        map.put("begin",begin);
        map.put("end",end);
        List<goodsType> goodsType = goodsTypeService.getGoodsType(map);
//        if(goodsType != null){
//            HttpSession session = request.getSession();
//            session.setAttribute("goodsType", goodsType);
        System.out.println("getGoodsType:");
            System.out.println(goodsType);
            return goodsType;
//        }

    }

    @ResponseBody
    @RequestMapping(value = "/getPage")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public int getPage(String table) {
        System.out.println(table);
        return goodsTypeService.getPage(table);
    }

    @ResponseBody
    @RequestMapping(value = "/addGoodsType")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void addGoodsType(goodsType goodsType) throws Exception {
        goodsTypeService.addGoodsType(goodsType);
    }

    @ResponseBody
    @RequestMapping(value = "/delGoodsType")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void delGoodsType(goodsType goodsType) throws Exception {
        goodsTypeService.delGoodsType(goodsType);
    }

    @ResponseBody
    @RequestMapping(value = "/updateGoodsType")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void updateGoodsType(goodsType goodsType) throws Exception {
        goodsTypeService.updateGoodsType(goodsType);
    }
}
