package com.cqut.service;

import com.cqut.domain.goods;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface goodsService {
    List<goods> getGoods() throws Exception;
    void addGoods(goods goods) throws Exception;
    void delGoods(goods goods) throws Exception;
    void updateGoods(goods goods) throws Exception;


}
