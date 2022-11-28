package com.example.service;

import com.example.mapper.GoodsMapper;
import com.example.pojo.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService implements GoodsMapper {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryTest() {
        return goodsMapper.queryTest();
    }

    @Override
    public List<Goods> queryGoods(int gSubCid) {
        return goodsMapper.queryGoods(gSubCid);
    }

    @Override
    public List<Goods> likeGoods() {
        return goodsMapper.likeGoods();
    }

    @Override
    public List<Goods> queryAllGoods(int start,int end,int cat) {
        return goodsMapper.queryAllGoods(start, end,cat);
    }

    @Override
    public int getGoodsCount() {
        return goodsMapper.getGoodsCount();
    }

    @Override
    public int changeGoodsStatus(int status,int id) {
        return goodsMapper.changeGoodsStatus(status,id);
    }

    @Override
    public int updateGoodsInfo(Goods goods) {
        return goodsMapper.updateGoodsInfo(goods);
    }

    @Override
    public Goods getGoods(int id) {
        return goodsMapper.getGoods(id);
    }

    @Override
    public int insertGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

}
