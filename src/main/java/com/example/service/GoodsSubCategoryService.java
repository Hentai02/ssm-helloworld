package com.example.service;

import com.example.mapper.GoodsSubCategoryMapper;
import com.example.pojo.GoodsSubcategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsSubCategoryService implements GoodsSubCategoryMapper {

    @Resource
    GoodsSubCategoryMapper goodsSubcategoryMapper;

    @Override
    public List<GoodsSubcategory> querySubCategory(Integer gCid) {
        return goodsSubcategoryMapper.querySubCategory(gCid);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(GoodsSubcategory row) {
        return 0;
    }

    @Override
    public GoodsSubcategory selectByPrimaryKey(Integer id) {
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
