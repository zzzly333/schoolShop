package com.cqut.service.impl;

import com.cqut.domain.goods;
import com.cqut.domain.goodsType;
import com.cqut.mapper.goodsTypeMapper;
import com.cqut.service.goodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsTypeService")
public class goodsTypeServiceImpl implements goodsTypeService {
    @Autowired
    private goodsTypeMapper goodsTypeMapper;
    @Override
    public List<goodsType> getGoodsType() throws Exception {
       List<goodsType> goodsType = goodsTypeMapper.getGoodsType();
       if (goodsType==null)
           throw new Exception("商品类型不存在");
       else
           return goodsType;
    }

    @Override
    public void addGoodsType(goodsType goodsType) throws Exception {
        goodsTypeMapper.addGoodsType(goodsType);
    }

    @Override
    public void delGoodsType(goodsType goodsType) throws Exception {
        goodsTypeMapper.delGoodsType(goodsType);
    }

    @Override
    public void updateGoodsType(goodsType goodsType) throws Exception {
        goodsTypeMapper.updateGoodsType(goodsType);
    }
}
