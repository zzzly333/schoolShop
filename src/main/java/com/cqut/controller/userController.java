package com.cqut.controller;

import com.cqut.domain.User;
import com.cqut.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class userController {
    @Autowired
    private userService userService;

    @ResponseBody
    @RequestMapping(value = "/getUser")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<User> getUser() throws Exception {
//        System.out.println(123);
        List<User> User = null;
        User = userService.getUser();
        System.out.println("getUser:");
        System.out.println(User);
        return User;
//        }
    }

    @ResponseBody
    @RequestMapping(value = "/addUser")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void addUser(User user) throws Exception {
        System.out.println("addUser:");
        System.out.println(user);
//        System.out.println("addGoods:");
//        System.out.println(goods);
        userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/delUser")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void delUser(User user) throws Exception {
        userService.delUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void updateUser(User user) throws Exception {
        userService.updateUser(user);
    }
}
