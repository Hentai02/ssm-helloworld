package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.SsUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements UserMapper {
    @Resource
    private UserMapper userMapper;

    public SsUser getAnyUser() {
        return userMapper.getAnyUser();
    }

    public SsUser userVerify(String username, String password) {
        return userMapper.userVerify(username, password);
    }


}
