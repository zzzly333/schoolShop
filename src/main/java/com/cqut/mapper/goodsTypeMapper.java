package com.cqut.mapper;

import com.cqut.domain.goodsType;

import java.util.List;
import java.util.Map;

public interface goodsTypeMapper {
    List<goodsType> getGoodsType(Map map);
    void addGoodsType(goodsType goodsType);
    void delGoodsType(goodsType goodsType);
    void updateGoodsType(goodsType goodsType);
    int getPage(String table);
}
