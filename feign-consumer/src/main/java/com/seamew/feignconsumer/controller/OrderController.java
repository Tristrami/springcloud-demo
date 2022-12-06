package com.seamew.feignconsumer.controller;

import com.seamew.feignconsumer.feign.GoodsFeign;
import com.seamew.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
public class OrderController
{
    @Autowired
    private GoodsFeign goodsFeign;

    @PostMapping
    public Result addOrder(@RequestParam("goodsId") Long goodsId)
    {
        return goodsFeign.getGoodsById(goodsId);
    }
}