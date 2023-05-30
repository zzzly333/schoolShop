package com.cqut.service.impl;

import com.cqut.domain.ShopCart;
import com.cqut.domain.goods;
import com.cqut.mapper.HomeMapper;
import com.cqut.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HomeService")
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;
    @Override
    public List<String> getCategory() throws Exception {
        return homeMapper.getCategory();
    }
    @Override
    public List<goods> getAllGoods() throws Exception {
        return homeMapper.getAllGoods();
    }

    @Override
    public List<goods> getCategoryGoods(String type) throws Exception {
        return homeMapper.getCategoryGoods(type);
    }

    @Override
    public void addToShopCart(String username, String goodsno, int num) throws Exception {
        ShopCart shopCart = null;
        shopCart = homeMapper.checkShopCart(username,goodsno);
        int num1 = num;
        if (shopCart != null) { //购物车已存在该商品
            num1 += homeMapper.getShopCartNum(username, goodsno);
            homeMapper.updateShopCart(username, goodsno, num1);
        }
        else
            homeMapper.addToShopCart(username, goodsno, num1);
    }

}
