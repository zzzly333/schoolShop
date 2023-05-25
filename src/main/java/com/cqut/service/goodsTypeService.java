package com.cqut.service;

import com.cqut.domain.goodsType;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface goodsTypeService {
    List<goodsType> getGoodsType() throws Exception;
    void addGoodsType(goodsType goodsType) throws Exception;
    void delGoodsType(goodsType goodsType) throws Exception;
    void updateGoodsType(goodsType goodsType) throws Exception;
}
