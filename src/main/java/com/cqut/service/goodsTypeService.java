package com.cqut.service;

import com.cqut.domain.goodsType;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface goodsTypeService {
    List<goodsType> getGoodsType(Map map) throws Exception;
    void addGoodsType(goodsType goodsType) throws Exception;
    void delGoodsType(goodsType goodsType) throws Exception;
    void updateGoodsType(goodsType goodsType) throws Exception;
    int getPage(String table);
    List<goodsType> getAllGoodsType()throws Exception;
}
