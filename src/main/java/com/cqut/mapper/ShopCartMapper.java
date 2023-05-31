package com.cqut.mapper;

import com.cqut.domain.Order;
import com.cqut.domain.ShopCart;
import com.cqut.domain.goods;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface ShopCartMapper {
    public List<ShopCart> getShopCart(@Param("username")String username);
    public void removeShopCart(@Param("goodsno")String goodsno);
    public void insertOrder(Order order);
    public ShopCart getCheckedItem(@Param("username")String username,@Param("goodsno")String goodsno);
    public void changeGoodsNum(@Param("id")String id,@Param("goodsNum")int goodsNum);
    public int getGoodsNum(@Param("id")String id);
}
