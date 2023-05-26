package com.cqut.controller;

import com.cqut.domain.goods;
import com.cqut.service.goodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class goodsController {
    @Autowired
    private goodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/getGoods")
    @CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<goods> getGoods() throws Exception {
        List<goods> goods = null;
        goods = goodsService.getGoods();
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
    @CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void addGoods(goods goods) throws Exception {
        System.out.println("addGoods:");
        System.out.println(goods);
        goodsService.addGoods(goods);
    }

    @ResponseBody
    @RequestMapping(value = "/delGoods")
    @CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void delGoods(goods goods) throws Exception {
        goodsService.delGoods(goods);
    }

    @ResponseBody
    @RequestMapping(value = "/updateGoods")
    @CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void updateGoods(goods goods) throws Exception {
        goodsService.updateGoods(goods);
    }
}
