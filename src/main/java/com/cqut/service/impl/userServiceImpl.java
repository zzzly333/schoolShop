package com.cqut.service.impl;

import com.cqut.domain.User;
import com.cqut.mapper.userMapper;
import com.cqut.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class userServiceImpl implements userService {
    @Autowired
    public userMapper userMapper;
    @Override
    public List<User> getUser() throws Exception {
        List<User> users = userMapper.getUser();
        if(users==null)
            throw new Exception("用户不存在");
        else
        {
            System.out.println(users);
            return users;
        }
    }

    @Override
    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }

    @Override
    public void delUser(User user) throws Exception {
        userMapper.delUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userMapper.updateUser(user);
    }
}
