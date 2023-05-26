package com.cqut.mapper;

import com.cqut.domain.User;

import java.util.List;

public interface userMapper {
    List<User> getUser();
    void addUser(User user);
    void delUser(User user);
    void updateUser(User user);
}
