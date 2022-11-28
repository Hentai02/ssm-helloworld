package com.example.controller;

import com.example.pojo.Goods;
import com.example.pojo.GoodsCover;
import com.example.pojo.User;
import com.example.service.GoodsCoverService;
import com.example.service.GoodsService;
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
    GoodsService goodsService;

    @Resource
    GoodsCoverService goodsCoverService;

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
     *
     * @param cat
     * @return
     */
    @GetMapping("goods/list.html")
    public String goodsList(@RequestParam(name = "cat",defaultValue = "0") int cat,
                            @RequestParam(name = "page",defaultValue = "1")  int page,
                            Model model){
        int page_size = 10;
        int total = goodsService.getGoodsCount();
        int page_count = total/page_size+1;
        int start = 0;
        int end = page_size;
        if (page != 1){
            start = end;
            end = page_size * page;
        }
        List<Goods> goods = goodsService.queryAllGoods(start, end, cat);
        model.addAttribute("goods_list",goods);
        model.addAttribute("current_page",page);
        model.addAttribute("total",total);
        logger.debug("总条目：" + total + ",总页数：" + page_count + ",开始：" + start + ",结束：" + end);
        logger.debug("总条目：" + Arrays.toString(goods.toArray()));
        return "list";
    }

    @GetMapping("goods/{id}.html")
    public String goodsDetail(@PathVariable Integer id,Model model){
        logger.debug(id);
        Goods goods = goodsService.getGoods(id);
        List<GoodsCover> goodsCovers = goodsCoverService.selectAll(id);
        model.addAttribute(goods);
        model.addAttribute(goodsCovers);
        logger.debug(goodsCovers);
        return "goods_detail";
    }
}
