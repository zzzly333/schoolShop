package com.cqut.controller;

import com.cqut.domain.*;
import com.cqut.service.HomeService;
import com.cqut.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private HomeService homeService;

    @ResponseBody
    @RequestMapping("/getCategory")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<String> getCategory() throws Exception {
        List<String> category = new ArrayList<>();
        category = homeService.getCategory();
        return category;
    }
    @ResponseBody
    @RequestMapping("/getAllGoods")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<goods> getAllGoods() throws Exception {
        List<goods> goods = new ArrayList<>();
        goods = homeService.getAllGoods();
        return goods;
    }
    @ResponseBody
    @RequestMapping("/getHome")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<Object> getHome() throws Exception {
        List<Object> result = new ArrayList<>();
        List<goods> goods = getAllGoods();
        List<String> category = getCategory();
        result.add(goods);
        result.add(category);
        return result;
    }
    @ResponseBody
    @RequestMapping("/getCategoryGoods")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<goods> getCategoryGoods(@RequestParam("goodsType")String goodsType) throws Exception {
        List<goods> goods = new ArrayList<>();
        goods = homeService.getCategoryGoods(goodsType);
        return goods;
    }

    @ResponseBody
    @RequestMapping("/addToShopCart")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void addToShopCart(@RequestParam("username")String username,@RequestParam("goodsno")String goodsno,
                              @RequestParam("num")int num) throws Exception {
        homeService.addToShopCart(username, goodsno, num);
    }
//    @ResponseBody
//    @RequestMapping("/manager3Login")
//    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
//    public systemManager manager3Login(@RequestParam("username")String username, @RequestParam("password")String password) throws Exception {
//        systemManager manager = null;
//        manager = loginService.findManager3(username, password);
//        return manager;
//    }
//    @ResponseBody
//    @RequestMapping("/regist")
//    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
//    public User regist(@RequestParam("username")String username, @RequestParam("password")String password) throws Exception {
//        User user = null;
//        user = loginService.checkRegisted(username, password);
//        int id = (Integer.parseInt(loginService.getMaxUserId()))+1;
//        if(user == null) {
//            loginService.insertUser(id + "", username, password);
////            user = new User(id+"","",username,password,"","启用");
//        }
//        return user;
//    }

}
