package com.example.mapper;

import com.example.pojo.SsGoodsSubcategor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<SsGoodsSubcategor> querySubcategor(@Param("cid") int cid);

}
