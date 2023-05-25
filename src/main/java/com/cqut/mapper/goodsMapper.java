package com.cqut.mapper;

import com.cqut.domain.goods;

import java.util.List;

public interface goodsMapper {
    List<goods> getGoods();
    void addGoods(goods goods);
    void delGoods(goods goods);
    void updateGoods(goods goods);
}
