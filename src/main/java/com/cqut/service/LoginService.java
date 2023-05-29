package com.cqut.service;

import com.cqut.domain.User;
import com.cqut.domain.goodserManager;
import com.cqut.domain.saleManager;
import com.cqut.domain.systemManager;

import javax.annotation.Resource;

@Resource
public interface LoginService {
    public User findUser(String username,String password) throws Exception;
    public goodserManager findManager1(String username, String password) throws Exception;
    public saleManager findManager2(String username, String password) throws Exception;
    public systemManager findManager3(String username, String password) throws Exception;
    public User checkRegisted(String username,String password) throws Exception;
    public void insertUser(String id,String username,String password) throws Exception;
    public String getMaxUserId() throws Exception;
}
