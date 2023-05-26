package com.cqut.service.impl;

import com.cqut.domain.User;
import com.cqut.mapper.LoginMapper;
import com.cqut.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public User findUser(User checkUser) throws Exception {
        User user = loginMapper.findUser(checkUser);
        if (user == null)
            throw new Exception("用户名或密码错误！");
        else
            return user;
    }
}
