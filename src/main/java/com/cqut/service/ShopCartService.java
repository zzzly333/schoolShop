package com.cqut.service;

import com.cqut.domain.ShopCart;
import com.cqut.domain.goods;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface ShopCartService {
    public List<ShopCart> getShopCart(String username);
    public void removeShopCart(String[] removeNo);
    public void payGoods(String[] goodsNo,String username);
}
