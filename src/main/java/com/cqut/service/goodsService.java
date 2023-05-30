package com.cqut.service;

import com.cqut.domain.goods;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface goodsService {
    List<goods> getGoods(Map map) throws Exception;
    void addGoods(goods goods) throws Exception;
    void delGoods(goods goods) throws Exception;
    void updateGoods(goods goods) throws Exception;
    List<goods> getAllGoods() throws Exception;

}
