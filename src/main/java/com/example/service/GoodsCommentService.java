package com.example.service;

import com.example.mapper.GoodsCommentMapper;
import com.example.pojo.GoodsComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsCommentService implements GoodsCommentMapper {

    @Resource
    GoodsCommentMapper goodsCommentMapper;

    @Override
    public List<GoodsComment> queryBygId(Integer gId) {
        return goodsCommentMapper.queryBygId(gId);
    }

    @Override
    public int insert(GoodsComment row) {
        return goodsCommentMapper.insert(row);
    }
}
