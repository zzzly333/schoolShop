package com.cqut.service.impl;

import com.cqut.domain.Order;
import com.cqut.mapper.ordersMapper;
import com.cqut.service.ordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ordersService")
public class ordersServiceImpl implements ordersService {
    @Autowired
    public ordersMapper ordersMapper;
    @Override
    public List<Order> getAllOrders() throws Exception {
        List<Order> orders = ordersMapper.getAllOrders();
        if(orders==null)
            throw new Exception("订单不存在");
        else
        {
            return orders;
        }
    }
}
