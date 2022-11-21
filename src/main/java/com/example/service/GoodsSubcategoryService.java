package com.example.service;

import com.example.mapper.GoodsSubcategoryMapper;
import com.example.pojo.GoodsSubcategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsSubcategoryService implements GoodsSubcategoryMapper {

    @Resource
    GoodsSubcategoryMapper goodsSubcategoryMapper;

    @Override
    public List<GoodsSubcategory> querySubCategory(Integer cid) {
        return goodsSubcategoryMapper.querySubCategory(cid);
    }

    @Override
    public int deleteByPrimaryKey(Integer scid) {
        return 0;
    }

    @Override
    public int insert(GoodsSubcategory row) {
        return 0;
    }

    @Override
    public GoodsSubcategory selectByPrimaryKey(Integer scid) {
        return null;
    }

    @Override
    public List<GoodsSubcategory> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(GoodsSubcategory row) {
        return 0;
    }
}
