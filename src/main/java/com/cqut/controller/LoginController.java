package com.cqut.controller;

import com.cqut.domain.*;
import com.cqut.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping("/userLogin")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public User userLogin(@RequestParam("username")String username,@RequestParam("password")String password) throws Exception {
        System.out.println(111);
        User user = null;
        user = loginService.findUser(username, password);
        return user;
    }

    @ResponseBody
    @RequestMapping("/manager1Login")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public goodserManager manager1Login(@RequestParam("username")String username,@RequestParam("password")String password) throws Exception {
        goodserManager manager = null;
        System.out.println(username+"\t"+password);
        manager = loginService.findManager1(username, password);
        return manager;
    }
    @ResponseBody
    @RequestMapping("/manager2Login")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public saleManager manager2Login(@RequestParam("username")String username,@RequestParam("password")String password) throws Exception {
        saleManager manager = null;
        manager = loginService.findManager2(username, password);
        return manager;
    }
    @ResponseBody
    @RequestMapping("/manager3Login")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public systemManager manager3Login(@RequestParam("username")String username, @RequestParam("password")String password) throws Exception {
        systemManager manager = null;
        manager = loginService.findManager3(username, password);
        return manager;
    }
    @ResponseBody
    @RequestMapping("/regist")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public User regist(@RequestParam("username")String username, @RequestParam("password")String password) throws Exception {
        User user = null;
        user = loginService.checkRegisted(username, password);
        int id = (Integer.parseInt(loginService.getMaxUserId()))+1;
        if(user == null) {
            loginService.insertUser(id + "", username, password);
//            user = new User(id+"","",username,password,"","启用");
        }
        return user;
    }

}
