package com.cqut.controller;

import com.cqut.domain.User;
import com.cqut.domain.goodsType;
import com.cqut.service.LoginService;
import com.cqut.service.goodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping("/login")
    @CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public User login(User checkUser) throws Exception {
        User user = null;
        user = loginService.findUser(checkUser);
        System.out.println(user);
        return user;
    }
}
