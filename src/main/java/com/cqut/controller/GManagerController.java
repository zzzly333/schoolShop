package com.cqut.controller;

import com.cqut.domain.goodserManager;
import com.cqut.domain.saleManager;
import com.cqut.service.GManagerService;
import com.cqut.service.SManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GManagerController {
    @Autowired
    public GManagerService GManagerService;

    @ResponseBody
    @RequestMapping(value = "/getGManager")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<goodserManager> getGManager() throws Exception {
        List<goodserManager> goodserManager = null;
        goodserManager = GManagerService.getGManager();
        System.out.println("getgoodserManager:");
        System.out.println(goodserManager);
        return goodserManager;
//        }
    }

    @ResponseBody
    @RequestMapping(value = "/addGManager")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void addGManager(goodserManager goodserManager) throws Exception {
        System.out.println("addgoodserManagerr:");
        System.out.println(goodserManager);
//        System.out.println("addGoods:");
//        System.out.println(goods);
        GManagerService.addGManager(goodserManager);
    }

    @ResponseBody
    @RequestMapping(value = "/delGManager")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void delSManager(goodserManager goodserManager) throws Exception {
        GManagerService.delGManager(goodserManager);
    }

    @ResponseBody
    @RequestMapping(value = "/updateGManager")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void updateSManager(goodserManager goodserManager) throws Exception {
        GManagerService.updateGManager(goodserManager);
    }
}
