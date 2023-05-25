package com.cqut.mapper;

import com.cqut.domain.goodsType;

import java.util.List;

public interface goodsTypeMapper {
    List<goodsType> getGoodsType();
    void addGoodsType(goodsType goodsType);
    void delGoodsType(goodsType goodsType);
    void updateGoodsType(goodsType goodsType);
}
