package com.example.controller;

import com.example.mapper.GoodsCommentMapper;
import com.example.mapper.GoodsCoverMapper;
import com.example.mapper.GoodsMapper;
import com.example.pojo.Goods;
import com.example.pojo.GoodsComment;
import com.example.pojo.GoodsCover;
import com.example.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class PagePathController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    GoodsMapper goodsMapper;

    @Resource
    GoodsCoverMapper goodsCoverMapper;

    @Resource
    GoodsCommentMapper goodsCommentMapper;

    /**
     * 首页
     * @return
     */
    @GetMapping(path = {"/index.html","/index","/"})
    public String index(HttpSession session, Model model){
        return "index";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(path = "/login.html",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    /**
     * 个人中心
     * @param session
     * @return
     */
    @GetMapping("/user.html")
    public String user(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null){
            return "user";
        }
        return "redirect:/app/";
    }


    /**
     * 商品类别
     * @param cat
     * @param page
     * @param model
     * @return
     */
    @GetMapping("goods/list.html")
    public String goodsList(@RequestParam(name = "cat",defaultValue = "0") int cat,
                            @RequestParam(name = "page",defaultValue = "1")  int page,
                            Model model){
        int page_size = 10;
        int total = goodsMapper.getGoodsCount();
        int page_count = total/page_size+1;
        int start = 0;
        int end = page_size;
        if (page != 1){
            start = end;
            end = page_size * page;
        }
        if (cat < 1000){
            List<Goods> goods = goodsMapper.queryAllGoods(start, end, 0,cat);
            model.addAttribute("goods_list",goods);
            model.addAttribute("current_page",page);
            model.addAttribute("total",total);
            return "list";
        }
        List<Goods> goods = goodsMapper.queryAllGoods(start, end, cat,null);
        model.addAttribute("goods_list",goods);
        model.addAttribute("current_page",page);
        model.addAttribute("total",total);

        logger.debug("总条目：" + total + ",总页数：" + page_count + ",开始：" + start + ",结束：" + end);
        logger.debug("总条目：" + Arrays.toString(goods.toArray()));
        return "list";
    }

    /**
     * 商品详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("goods/{id}.html")
    public String goodsDetail(@PathVariable() Integer id,Model model){
        Goods goods = goodsMapper.getGoods(id);
        goods.setView(goods.getView() + 1);
        goodsMapper.updateGoodsInfo(goods);
        List<GoodsCover> goodsCovers = goodsCoverMapper.selectAll(id);
        List<GoodsComment> goodsComments = goodsCommentMapper.queryBygId(id);
        model.addAttribute(goods);
        model.addAttribute(goodsCovers);
        model.addAttribute(goodsComments);
        return "goods_detail";
    }

    /**
     * 购物车
     * @param session
     * @return
     */
    @GetMapping("goods/cart.html")
    public String shopCart(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null){
            return "shop_cart";
        }
        return "redirect:/app/";
    }

    /**
     * 我的订单
     * @return
     */
    @GetMapping("goods/orders.html")
    public String orders(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null){
            return "orders";
        }
        return "redirect:/app/";
    }

    /**
     * 搜索页面
     * @param search
     * @param model
     * @return
     */
    @GetMapping("/goods/search.html")
    public String searchGoods(@RequestParam(name = "search",defaultValue = "") String search,Model model){
        List<Goods> goods = goodsMapper.searchGoods(search);
        model.addAttribute("goods_list",goods);
        return "search";
    }
}
