package com.example.service;

import com.example.mapper.GoodsMapper;
import com.example.pojo.SsGoodsSubcategor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService implements GoodsMapper {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<SsGoodsSubcategor> querySubcategor(int cid) {
        return goodsMapper.querySubcategor(cid);
    }
}
