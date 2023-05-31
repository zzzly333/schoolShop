package com.cqut.controller;

import com.cqut.domain.ShopCart;
import com.cqut.domain.goods;
import com.cqut.service.HomeService;
import com.cqut.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;

    @ResponseBody
    @RequestMapping("/getShopCart")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<ShopCart> getShopCart(@RequestParam("username")String username) throws Exception {
        List<ShopCart> shopCarts = new ArrayList<>();
        shopCarts = shopCartService.getShopCart(username);
        return shopCarts;
    }
    @ResponseBody
    @RequestMapping("/removeShopCart")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void removeShopCart(@RequestParam String[] removeNo) throws Exception {
        shopCartService.removeShopCart(removeNo);
    }
    @ResponseBody
    @RequestMapping("/payShopCart")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void payShopCart(@RequestParam("payGoods")String[] removeNo,@RequestParam("username")String username) throws Exception {
//        shopCartService.removeShopCart(removeNo);
//        shopCartService.insertOrder(removeNo,username);
        shopCartService.payGoods(removeNo, username);
    }
}
