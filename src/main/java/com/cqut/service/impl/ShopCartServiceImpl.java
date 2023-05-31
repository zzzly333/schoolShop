package com.cqut.service.impl;

import com.cqut.domain.Order;
import com.cqut.domain.ShopCart;
import com.cqut.domain.goods;
import com.cqut.mapper.ShopCartMapper;
import com.cqut.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service("ShopCartService")
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    private ShopCartMapper shopCartMapper;
    @Override
    public List<ShopCart> getShopCart(String username) {
        return shopCartMapper.getShopCart(username);
    }

    @Override
    public void removeShopCart(String[] removeNo) {
        for (int i =0 ;i <removeNo.length;i++){
            shopCartMapper.removeShopCart(removeNo[i]);
        }
//
    }

    @Override
    public void payGoods(String[] goodsNo, String username) {
        long time = System.currentTimeMillis();
        int num = 0;
        Date date = new Date(time);
        for (int i =0 ; i<goodsNo.length; i++){
            ShopCart shopCart = shopCartMapper.getCheckedItem(username,goodsNo[i]);
            Order order = new Order(shopCart.getUsername(),shopCart.getGoodsno(),shopCart.getGoodsName(),shopCart.getGoodsImage(),
                    shopCart.getGoodsPrice()*shopCart.getNum(),shopCart.getNum(),date);
            shopCartMapper.insertOrder(order);//生成订单
            num = shopCartMapper.getGoodsNum(goodsNo[i]);
            System.out.println(num+"\t"+shopCart.getNum());
            shopCartMapper.changeGoodsNum(shopCart.getGoodsno(),num-shopCart.getNum());//改变商品表商品数量
        }
        removeShopCart(goodsNo);//从购物车中移除
    }
}
