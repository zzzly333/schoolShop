package com.cqut.mapper;

import com.cqut.domain.User;

import java.util.List;
import java.util.Map;

public interface userMapper {
    List<User> getUser(Map map);
    void addUser(User user);
    void delUser(User user);
    void updateUser(User user);
}
