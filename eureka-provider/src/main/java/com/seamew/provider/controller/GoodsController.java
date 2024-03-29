package com.seamew.provider.controller;

import com.seamew.domain.Goods;
import com.seamew.provider.service.GoodsService;
import com.seamew.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("{goodsId}")
    public Result getGoodsById(@PathVariable Integer goodsId) {
        Goods goods = goodsService.getGoodsById(goodsId);
        return Result.success(goods);
    }
}
