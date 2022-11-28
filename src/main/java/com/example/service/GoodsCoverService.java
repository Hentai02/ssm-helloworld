package com.example.service;

import com.example.mapper.GoodsCoverMapper;
import com.example.pojo.GoodsCover;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsCoverService implements GoodsCoverMapper {

    @Resource
    GoodsCoverMapper goodsCoverMapper;

    @Override
    public List<GoodsCover> selectAll(Integer gId) {
        return goodsCoverMapper.selectAll(gId);
    }
}
