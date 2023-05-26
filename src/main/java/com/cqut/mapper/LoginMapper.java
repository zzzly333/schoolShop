package com.cqut.mapper;

import com.cqut.domain.User;


public interface LoginMapper {
    User findUser(User userQuery);
}
