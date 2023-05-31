package com.cqut.mapper;

import com.cqut.domain.ShopCart;
import com.cqut.domain.goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HomeMapper {
    public List<String> getCategory();
    public List<goods> getAllGoods();
    public List<goods> getCategoryGoods(@Param("goodsType") String type);
    public void addToShopCart(@Param("username")String username, @Param("goodsno")String goodsno,
    @Param("goodsName")String goodsName,@Param("goodsImage")String goodsImage,@Param("goodsPrice")float goodsPrice,
                              @Param("num")int num,@Param("state")String state);
    public ShopCart checkShopCart(@Param("username")String username, @Param("goodsno")String goodsno);
    public int getShopCartNum(@Param("username")String username, @Param("goodsno")String goodsno);
    public void updateShopCart(@Param("username")String username, @Param("goodsno")String goodsno, @Param("num")int num);
}
