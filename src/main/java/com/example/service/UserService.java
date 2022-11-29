package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements UserMapper {
    @Resource
    private UserMapper userMapper;

    public List<User> getUser(long id) {
        return userMapper.getUser(id);
    }

    public User userVerify(String username, String password) {
        return userMapper.userVerify(username, password);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    @Override
    public int updateUserAddress(User user) {
        return userMapper.updateUserAddress(user);
    }

    @Override
    public int changeUserStatus(int status,int id) {
        return userMapper.changeUserStatus(status,id);
    }


}
