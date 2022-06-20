package com.example.mapper;

import com.example.pojo.SsUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    SsUser getAnyUser();

    SsUser userVerify(@Param("username") String username, @Param("password") String password);

}
