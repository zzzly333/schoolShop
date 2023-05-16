package com.cqut.ssm.mapper;
import com.cqut.ssm.entity.User;
import org.springframework.stereotype.Repository;
/**
 * 本文作者：谷哥的小弟
 * 博客地址：http://blog.csdn.net/lfdfhl
 */

@Repository
public interface UserMapper {
    User findUserById(int id);
}

