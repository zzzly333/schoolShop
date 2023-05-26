package com.cqut.service;

import com.cqut.domain.User;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface userService {
    List<User> getUser() throws Exception;
    void addUser(User user) throws Exception;
    void delUser(User user) throws Exception;
    void updateUser(User user) throws Exception;
}
