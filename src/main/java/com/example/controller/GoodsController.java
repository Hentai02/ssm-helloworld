package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mapper.GoodsSubcategoryMapper;
import com.example.pojo.BaseResponse;
import com.example.pojo.Goods;
import com.example.pojo.GoodsSubcategory;
import com.example.pojo.User;
import com.example.service.GoodsService;
import com.example.service.GoodsSubcategoryService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class GoodsController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private GoodsService goodsService;
    @Resource
    private GoodsSubcategoryService goodsSubcategoryService;

    @Resource
    private GoodsSubcategoryMapper goodsSubcategoryMapper;

    /**
     * 获取商品子类别
     * @param gCid
     * @return
     */
    @PostMapping("/goods/Subcategory.do")
    public BaseResponse querySubcategory(@RequestParam Integer gCid){
        List<GoodsSubcategory> goodsSubCategory = goodsSubcategoryService.querySubCategory(gCid);
        logger.error(gCid);
        return BaseResponse.success(goodsSubcategoryService.querySubCategory(gCid));
    }

    /**
     * 获取指定子类别商品
     * @param gscid
     * @return
     */
    @PostMapping("/goods/queryGoods.do")
    public BaseResponse queryGoods(@RequestParam int gscid){
        List<Goods> goods = goodsService.queryGoods(gscid);
        return BaseResponse.success(goods);
    }

    /**
     * 获取猜你喜欢商品
     * @return
     */
    @PostMapping("/goods/queryLikeGoods.do")
    public BaseResponse queryLikeGoods(){
        List<Goods> goods = goodsService.likeGoods();
        return BaseResponse.success(goods);
    }

    /**
     * 获取所有商品
     * @param current_page
     * @return
     */
    @PostMapping("/goods/queryAllGoods.do")
    public BaseResponse queryAllGoods(@RequestParam int current_page){
        int start = 0;
        int end = 10;
        int total = goodsService.getGoodsCount();
        int page_size = 10;
        int page_count = total/page_size+1;
        if (current_page != 1){
            start = end;
            end = current_page * page_size;
        }
        JSONObject jsonObject = new JSONObject();
        List<Goods> goods = goodsService.queryAllGoods(start,end);
        List<Goods> srcGoods = goodsService.queryAllGoods(-1,-1);
        jsonObject.put("goods",goods);
        jsonObject.put("total",total);
        jsonObject.put("page_count",page_count);
        jsonObject.put("page_size",page_size);
        jsonObject.put("srcGoods",srcGoods);
        return BaseResponse.success(jsonObject);
    }

    /**
     * 下架商品
     * @param id
     * @return
     */
    @PostMapping("/goods/deleteGoods.do")
    public BaseResponse deleteGoods(@RequestParam int id){
        int row = goodsService.changeGoodsStatus(-1,id);
        return BaseResponse.success();
    }

    /**
     * 上架商品
     * @param id
     * @return
     */
    @PostMapping("/goods/shelvesGoods.do")
    public BaseResponse shelvesGoods(@RequestParam int id){
        int row = goodsService.changeGoodsStatus(0,id);
        Goods goods = goodsService.getGoods(id);
        if (goods.getCount() <= 0){
            goods.setCount(1);
            goodsService.updateGoodsInfo(goods);
        }
        return BaseResponse.success();
    }

    // TODO:   更新和上架可以合并为一个方法

    /**
     * 更新商品
     * @param goods
     * @return
     */
    @PostMapping("/goods/updateGoodsInfo.do")
    public BaseResponse updateGoodsInfo(HttpSession session, @RequestBody Goods goods){
        Goods srcGoods = goodsService.getGoods(goods.getId());
        User user = (User) session.getAttribute("user");
        // TODO: 刷新更新时间 更新者
//        if (srcGoods.equals(goods)){
//            logger.error("用没有更改商品信息");
//            return BaseResponse.success("不改就别点确定！");
//        }
        goodsService.updateGoodsInfo(goods);
        return BaseResponse.success("修改成功！");
    }


    /**
     * 添加商品
     * @param goods
     * @return
     */
    @PostMapping("/goods/insertGoods.do")
    public BaseResponse insertGoods(@RequestBody Goods goods){
        int row = goodsService.insertGoods(goods);
        logger.error(row);
        return BaseResponse.success();
    }






}
