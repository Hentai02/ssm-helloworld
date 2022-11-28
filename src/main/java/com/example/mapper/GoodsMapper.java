package com.example.mapper;

import com.example.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<Goods> queryTest();

    List<Goods> queryGoods(@Param("gSubCid") int gSubCid);

    List<Goods> likeGoods();

    List<Goods> queryAllGoods(@Param("start") int start,@Param("end") int end,@Param("cat") int cat);

    int getGoodsCount();

    int changeGoodsStatus(@Param("status") int status,@Param("id") int id);

    int updateGoodsInfo(Goods goods);

    Goods getGoods(@Param("id") int id);

    int insertGoods(Goods goods);
}
