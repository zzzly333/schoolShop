package com.cqut.service;

import com.cqut.domain.goods;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface HomeService {
    public List<String> getCategory() throws Exception;
    public List<goods> getAllGoods() throws Exception;
    public List<goods> getCategoryGoods(String type) throws Exception;
    public void addToShopCart(String username,String goodsno,int num) throws Exception;
}
