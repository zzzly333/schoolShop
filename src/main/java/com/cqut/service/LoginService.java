package com.cqut.service;

import com.cqut.domain.User;

import javax.annotation.Resource;

@Resource
public interface LoginService {
    public User findUser(User checkUser) throws Exception;
}
