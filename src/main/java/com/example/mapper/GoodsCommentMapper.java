package com.example.mapper;

import com.example.pojo.GoodsComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCommentMapper {
    List<GoodsComment> queryBygId(@Param("gId") Integer gId);

    int insert(GoodsComment row);
}