package com.cqut.mapper;

import com.cqut.domain.goods;

import java.util.List;
import java.util.Map;

public interface goodsMapper {
    List<goods> getGoods(Map map);
    void addGoods(goods goods);
    void delGoods(goods goods);
    void updateGoods(goods goods);
}
