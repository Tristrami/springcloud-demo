package com.seamew.hystrixprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.seamew.domain.Goods;
import com.seamew.hystrixprovider.service.GoodsService;
import com.seamew.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("{goodsId}")
    @HystrixCommand(
        fallbackMethod = "getGoodsByIdFallback", commandProperties = {
            @HystrixProperty(
                // 在服务提供方的角度设置的服务超时时间，如果服务的执行时间超过这个设定值，服务就会降级，执行 fallback
                name ="execution.isolation.thread.timeoutInMilliseconds",
                value = "3000"
            )
        }
    )
    public Result getGoodsById(@PathVariable Integer goodsId)
    {
        Goods goods = goodsService.getGoodsById(goodsId);
        return Result.success(goods);
    }


    // fallback 函数的参数及返回值类型要和原函数一致
    public Result getGoodsByIdFallback(Integer Id)
    {
        return Result.fail();
    }
}
