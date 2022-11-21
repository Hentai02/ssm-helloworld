package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUser(@Param("id") long id);

    User userVerify(@Param("username") String username, @Param("password") String password);

    int updateUserInfo(User user);

    int changeUserStatus(@Param("status") int status,@Param("id") int id);

}
