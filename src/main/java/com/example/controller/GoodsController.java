package com.example.controller;

import com.example.pojo.BaseResponse;
import com.example.pojo.SsGoodsSubcategor;
import com.example.service.GoodsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class GoodsController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private GoodsService goodsService;

    @ResponseBody
    @PostMapping("/goods/subcategor.do")
    public BaseResponse querySubcategor(@RequestParam int cid, Model model){
        logger.info("商品子类ID:" + cid);
        List<SsGoodsSubcategor> subcategors = goodsService.querySubcategor(cid);
        return BaseResponse.success(subcategors);
    }

}
