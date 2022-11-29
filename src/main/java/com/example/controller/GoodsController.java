package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mapper.GoodsCommentMapper;
import com.example.mapper.GoodsMapper;
import com.example.mapper.GoodsSubCategoryMapper;
import com.example.mapper.ShopCartMapper;
import com.example.pojo.*;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class GoodsController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsSubCategoryMapper goodsSubCategoryMapper;

    @Resource
    private GoodsCommentMapper goodsCommentMapper;

    @Resource
    private ShopCartMapper shopCartMapper;

    /**
     * 获取商品子类别
     * @param gCid
     * @return
     */
    @PostMapping("/goods/Subcategory.do")
    public BaseResponse querySubcategory(@RequestParam Integer gCid){
        List<GoodsSubcategory> goodsSubCategory = goodsSubCategoryMapper.querySubCategory(gCid);
        logger.error(gCid);
        return BaseResponse.success(goodsSubCategoryMapper.querySubCategory(gCid));
    }

    /**
     * 获取指定子类别商品
     * @param gSubCid
     * @return
     */
    @PostMapping("/goods/queryGoods.do")
    public BaseResponse queryGoods(@RequestParam int gSubCid){
        List<Goods> goods = goodsMapper.queryGoods(gSubCid);
        return BaseResponse.success(goods);
    }

    /**
     * 获取猜你喜欢商品
     * @return
     */
    @PostMapping("/goods/queryLikeGoods.do")
    public BaseResponse queryLikeGoods(){
        List<Goods> goods = goodsMapper.likeGoods();
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
        int total = goodsMapper.getGoodsCount();
        int page_size = 10;
        int page_count = total/page_size+1;
        if (current_page != 1){
            start = end;
            end = current_page * page_size;
        }
        JSONObject jsonObject = new JSONObject();
        List<Goods> goods = goodsMapper.queryAllGoods(start,end,0,null);
        List<Goods> srcGoods = goodsMapper.queryAllGoods(-1,-1,0,null);
        jsonObject.put("goods",goods);
        jsonObject.put("total",total);
        jsonObject.put("page_count",page_count);
        jsonObject.put("page_size",page_size);
        jsonObject.put("srcGoods",srcGoods);
        return BaseResponse.success(jsonObject);
    }

    /**
     * 浏览最多的商品
     * @return
     */
    @PostMapping("/goods/queryHotGoods.do")
    public BaseResponse queryHotGoods(){
        List<Goods> goods = goodsMapper.queryHotGoods();
        return BaseResponse.success(goods);
    }

    /**
     * 下架商品
     * @param id
     * @return
     */
    @PostMapping("/goods/deleteGoods.do")
    public BaseResponse deleteGoods(@RequestParam int id){
        int row = goodsMapper.changeGoodsStatus(-1,id);
        return BaseResponse.success();
    }

    // TODO: 更新和上架合并为一个controller

    /**
     * 上架商品
     * @param id
     * @return
     */
    @PostMapping("/goods/shelvesGoods.do")
    public BaseResponse shelvesGoods(@RequestParam int id){
        int row = goodsMapper.changeGoodsStatus(0,id);
        Goods goods = goodsMapper.getGoods(id);
        if (goods.getCount() <= 0){
            goods.setCount(1);
            goodsMapper.updateGoodsInfo(goods);
        }
        return BaseResponse.success();
    }


    /**
     * 更新商品
     * @param goods
     * @return
     */
    @PostMapping("/goods/updateGoodsInfo.do")
    public BaseResponse updateGoodsInfo(HttpSession session, @RequestBody Goods goods){
        Goods srcGoods = goodsMapper.getGoods(goods.getId());
        User user = (User) session.getAttribute("user");
        UploadInfo uploadInfo = (UploadInfo) session.getAttribute("uploadInfo");
        if (uploadInfo != null){
            File dir = uploadInfo.tmpFile.getParentFile().getParentFile();
            try {
                if (uploadInfo.tmpFile.exists()){
                    FileUtils.delete(uploadInfo.tmpFile);
                }
                File srcFile = new File(dir,"/data/goods/" + goods.getId() + "/" + uploadInfo.tmpFileName);
                Goods goodsed = goodsMapper.getGoods(goods.getId());
                File fileed = new File(dir, goodsed.getCover());
                if (fileed.exists()){
                    FileUtils.delete(fileed);
                }
                goods.setCover("/data/goods/" + goods.getId() + "/" + srcFile.getName());
            } catch (IOException e) {
                return BaseResponse.error(e);
            }
//            File dir = uploadInfo.tmpFile.getParentFile().getParentFile();
//            File cover = new File(dir,"/cover");
//            File[] files = cover.listFiles();
//            if (files.length>0){
//                try {
//                    FileUtils.delete(files[0]);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }

        }
//        if (srcGoods.equals(goods)){
//            logger.error("用没有更改商品信息");
//            return BaseResponse.success("不改就别点确定！");
//        }
        goodsMapper.updateGoodsInfo(goods);
        return BaseResponse.success("修改成功！");
    }

    /**
     * 发货
     * @param id
     * @param number
     * @return
     */
    @PostMapping("/goods/shipments.do")
    public BaseResponse shipments(@RequestParam Integer id,@RequestParam String number){
        shopCartMapper.updateNumber(number,id);
        return BaseResponse.success("发货成功！");
    }


    /**
     * 添加商品
     * @param goods
     * @return
     */
    @PostMapping("/goods/insertGoods.do")
    public BaseResponse insertGoods(HttpSession session,@RequestBody Goods goods){
        User sessionUser = (User) session.getAttribute("user");
        goods.setView(1);
        goods.setUid(sessionUser.getId());
        goods.setIsDel(0);
        goods.setCreateBy(sessionUser.getUsername());
        goods.setCreateTime(new Date());
        if (goods.getCover() == null){
            goods.setCover("/app/data/goods/404");
        }
        int row = goodsMapper.insertGoods(goods);
        logger.error(row);
        return BaseResponse.success();
    }

    /**
     * 发布评论
     * @param comment
     * @return
     */
    @PostMapping("/goods/insertGoodsComment.do")
    public BaseResponse insertComment(@RequestParam Integer gId,@RequestParam String comment,HttpSession session){
        User session_user = (User) session.getAttribute("user");
        if (session_user != null){
            GoodsComment goodsComment = new GoodsComment();
            goodsComment.setContent(comment);
            goodsComment.setUid(session_user.getId());
            goodsComment.setgId(gId);
            goodsComment.setIsDel(0);
            goodsComment.setCreateTime(new Date());
            goodsComment.setCreateBy(session_user.getUsername());
            goodsCommentMapper.insert(goodsComment);
            logger.debug("done");
            return BaseResponse.success("发表成功！");
        }else {
            return BaseResponse.fail("请先登录！");
        }

    }


    /**
     * 加入购物车
     * @param count
     * @param gId
     * @param session
     * @return
     */
    @PostMapping("goods/insertShopCart.do")
    public BaseResponse insertCart(@RequestParam Integer count,@RequestParam Integer gId,HttpSession session){
        User session_user = (User) session.getAttribute("user");
        ShopCart shopCart = new ShopCart();
        ShopCart goodsOne = shopCartMapper.queryBygId(gId,session_user.getId());
        if (session_user != null){
            if (goodsOne != null && goodsOne.getIsDel() >= 0){
                if (goodsOne.getUid().equals(session_user.getId())){
                    shopCartMapper.updateByPrimaryKey(goodsOne.getCount() + count,gId,null);
                }
            }
            shopCart.setUid(session_user.getId());
            shopCart.setCreateBy(session_user.getUsername());
            shopCart.setCount(count);
            shopCart.setgId(gId);
            shopCart.setIsDel(1);
            shopCart.setCreateTime(new Date());
            shopCartMapper.insert(shopCart);
            return BaseResponse.success("已加入购物车！");
        }

        return BaseResponse.fail("请先登录！");
    }


    /**
     * 获取购物车中的商品
     * @param session
     * @return
     */
    @PostMapping("/goods/shopCartAll.do")
    public BaseResponse queryAllInCart(HttpSession session, @RequestParam Integer isDel){
        User user = (User) session.getAttribute("user");
        List<ShopCart> shopCarts = shopCartMapper.selectByPrimaryKey(user.getId(),isDel);
        return BaseResponse.success(shopCarts);
    }

    /**
     * 模拟交易
     * @param req
     * @return
     */
    @PostMapping("/goods/shopCartClear.do")
    public BaseResponse goodsSettlement(@RequestBody List<ShopCart> req){
        for(ShopCart cart:req){
            shopCartMapper.updateByPrimaryKey(null,cart.getgId(),-1);
        }
        return BaseResponse.success("支付成功！");

    }

    /**
     * 删除购物车中的商品
     * @param req
     * @return
     */
    @PostMapping("/goods/delShopCart.do")
    public BaseResponse delShopCart(@RequestBody List<ShopCart> req){
        for(ShopCart cart:req){
            shopCartMapper.deleteByPrimaryKey(cart.getId());
        }
        return BaseResponse.success("删除成功！");
    }

    /**
     * 删除长账单
     * @param id
     * @return
     */
    @PostMapping("/goods/delOrders.do")
    public BaseResponse delOrders(@RequestParam Integer id){
        shopCartMapper.deleteByPrimaryKey(id);
        return BaseResponse.success();
    }






}
