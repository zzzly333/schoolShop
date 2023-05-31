package com.cqut.mapper;

import com.cqut.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ordersMapper {
    List<Order> getAllOrders(@Param("username")String username);
}
