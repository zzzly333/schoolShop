package com.cqut.service;

import com.cqut.domain.Order;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface ordersService {
    List<Order> getAllOrders() throws Exception;
}
