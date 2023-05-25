package com.cqut.service.impl;

import com.cqut.domain.goods;
import com.cqut.mapper.goodsMapper;
import com.cqut.service.goodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsService")
public class goodsServiceImpl implements goodsService {
    @Autowired
    private goodsMapper goodsMapper;
    @Override
    public List<goods> getGoods() throws Exception {
        List<goods> goods = goodsMapper.getGoods();
        if (goods==null)
            throw new Exception("商品不存在");
        else
            return goods;
    }

    @Override
    public void addGoods(goods goods) throws Exception {
        goodsMapper.addGoods(goods);
    }

    @Override
    public void delGoods(goods goods) throws Exception {
        goodsMapper.delGoods(goods);
    }

    @Override
    public void updateGoods(goods goods) throws Exception {
        goodsMapper.updateGoods(goods);
    }
}
