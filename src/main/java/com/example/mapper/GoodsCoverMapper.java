package com.example.mapper;

import com.example.pojo.GoodsCover;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCoverMapper {
    List<GoodsCover> selectAll(@Param("gId") Integer gId);
}