package com.cqut.service;

import com.cqut.domain.goodsType;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface goodsTypeService {
    public List<goodsType> getGoodsType() throws Exception;
}
