package com.cqut.service;

import com.cqut.domain.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface userService {
    List<User> getUser(Map map) throws Exception;
    void addUser(User user) throws Exception;
    void delUser(User user) throws Exception;
    void updateUser(User user) throws Exception;
    void updateUser2(Map map) throws Exception;
}
