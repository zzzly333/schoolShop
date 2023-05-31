package com.cqut.controller;

import com.cqut.domain.goods;
import com.cqut.service.goodsService;
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
public class goodsController {
    @Autowired
    private goodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/getGoods")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<goods> getGoods(String pagenum,String pagesize) throws Exception {
        List<goods> goods = null;
        int begin = (Integer.parseInt(pagenum)-1)*Integer.parseInt(pagesize);
        int end = Integer.parseInt(pagesize);
        Map map = new HashMap();
        map.put("begin",begin);
        map.put("end",end);
        goods = goodsService.getGoods(map);
//        if(goodsType != null){
//            HttpSession session = request.getSession();
//            session.setAttribute("goodsType", goodsType);
        System.out.println("getGoods:");
        System.out.println(goods);
        return goods;
//        }
    }

    @ResponseBody
    @RequestMapping(value = "/addGoods")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void addGoods(goods goods) throws Exception {
        System.out.println("addGoods:");
        System.out.println(goods);
        goodsService.addGoods(goods);
    }

    @ResponseBody
    @RequestMapping(value = "/delGoods")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void delGoods(goods goods) throws Exception {
        goodsService.delGoods(goods);
    }

    @ResponseBody
    @RequestMapping(value = "/updateGoods")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void updateGoods(goods goods) throws Exception {
        goodsService.updateGoods(goods);
    }

//    @ResponseBody
//    @RequestMapping(value = "/getAllGoods")
//    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
//    public List<goods> getAllGoods() throws Exception {
//        List<goods> goods = goodsService.getAllGoods();
//        return goods;
//    }
}
