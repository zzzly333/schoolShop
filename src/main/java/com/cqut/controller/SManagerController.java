package com.cqut.controller;

import com.cqut.domain.saleManager;
import com.cqut.service.SManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SManagerController {
    @Autowired
    public SManagerService sManagerService;

    @ResponseBody
    @RequestMapping(value = "/getSManager")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public List<saleManager> getSManager() throws Exception {
        List<saleManager> saleManager = null;
        saleManager = sManagerService.getSManager();
        System.out.println("getsaleManager:");
        System.out.println(saleManager);
        return saleManager;
//        }
    }

    @ResponseBody
    @RequestMapping(value = "/addSManager")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void addSManager(saleManager saleManager) throws Exception {
        System.out.println("addsaleManager:");
        System.out.println(saleManager);
//        System.out.println("addGoods:");
//        System.out.println(goods);
        sManagerService.addSManager(saleManager);
    }

    @ResponseBody
    @RequestMapping(value = "/delSManager")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void delSManager(saleManager saleManager) throws Exception {
        sManagerService.delSManager(saleManager);
    }

    @ResponseBody
    @RequestMapping(value = "/updateSManager")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void updateSManager(saleManager saleManager) throws Exception {
        sManagerService.updateSManager(saleManager);
    }
}
