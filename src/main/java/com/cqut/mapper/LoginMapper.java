package com.cqut.mapper;

import com.cqut.domain.User;
import com.cqut.domain.goodserManager;
import com.cqut.domain.saleManager;
import com.cqut.domain.systemManager;
import org.apache.ibatis.annotations.Param;


public interface LoginMapper {
    User findUser(@Param("username")String username,@Param("password")String password);
    goodserManager findManager1(@Param("username")String username, @Param("password")String password);
    saleManager findManager2(@Param("username")String username, @Param("password")String password);
    systemManager findManager3(@Param("username")String username, @Param("password")String password);
    User checkRegisted(@Param("username")String username,@Param("password")String password);
    void insertUser(@Param("id")String id,@Param("username")String username,@Param("password")String password);
    String getMaxUserId();

}
