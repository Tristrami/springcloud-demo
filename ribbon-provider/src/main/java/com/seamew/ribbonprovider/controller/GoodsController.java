package com.seamew.ribbonprovider.controller;

import com.seamew.domain.Goods;
import com.seamew.result.Result;
import com.seamew.ribbonprovider.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsController
{
    @Autowired
    private GoodsService goodsService;

    // 记录当前服务实例的端口号，测试 ribbon 负载均衡是否起效
    @Value("${server.port}")
    private int port;

    @GetMapping("{goodsId}")
    public Result getGoodsById(@PathVariable Integer goodsId)
    {
        Goods goods = goodsService.getGoodsById(goodsId);
        goods.setTitle(goods.getTitle());
        return Result.success(goods, "Port: " + port);
    }
}
