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
    public List<Order> getAllOrders(String username) throws Exception {
        List<Order> orders = null;
        orders = ordersMapper.getAllOrders(username);
        return orders;
    }
}
