package com.cqut.service.impl;

import com.cqut.domain.User;
import com.cqut.domain.goodserManager;
import com.cqut.domain.saleManager;
import com.cqut.domain.systemManager;
import com.cqut.mapper.LoginMapper;
import com.cqut.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public User findUser(String username,String password) throws Exception {
        User user = null;
        user = loginMapper.findUser(username, password);
        return user;
    }

    @Override
    public goodserManager findManager1(String username, String password) throws Exception {
        goodserManager manager = null;
        manager = loginMapper.findManager1(username, password);
        return manager;
    }

    @Override
    public saleManager findManager2(String username, String password) throws Exception {
        saleManager manager = null;
        manager = loginMapper.findManager2(username, password);
        return manager;
    }

    @Override
    public systemManager findManager3(String username, String password) throws Exception {
        systemManager manager = null;
        manager = loginMapper.findManager3(username, password);
        return manager;
    }

    @Override
    public User checkRegisted(String username, String password) throws Exception {
        User user = null;
        user = loginMapper.checkRegisted(username, password);
        return user;
    }

    @Override
    public void insertUser(String id,String username, String password) throws Exception {
        loginMapper.insertUser(id,username, password);
    }

    @Override
    public String getMaxUserId() throws Exception {
        return loginMapper.getMaxUserId();
    }

}
