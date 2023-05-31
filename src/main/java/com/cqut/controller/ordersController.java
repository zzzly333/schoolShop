package com.cqut.controller;

import com.cqut.domain.Order;
import com.cqut.service.ordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ordersController {
    @Autowired
    private ordersService ordersService;

    @ResponseBody
    @RequestMapping(value = "/getAllOrders")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<Order> getAllOrders(@RequestParam("username")String username) throws Exception {
        List<Order> orders = ordersService.getAllOrders(username);
        return orders;
    }
}
