package com.cqut.controller;

import com.cqut.domain.goodsType;
import com.cqut.service.goodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
public class goodsTypeController {
    @Autowired
    private goodsTypeService goodsTypeService;

    @ResponseBody
    @RequestMapping("/goodsType")
    @CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {RequestMethod.POST})
    public void getGoodsType() throws Exception {
        List<goodsType> goodsType = null;
        goodsType = goodsTypeService.getGoodsType();
        if(goodsType != null){
//            HttpSession session = request.getSession();
//            session.setAttribute("goodsType", goodsType);
            System.out.println(goodsType);
        }
        else
            System.out.println("error");
    }
}
