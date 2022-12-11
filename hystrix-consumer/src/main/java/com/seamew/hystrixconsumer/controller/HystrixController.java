package com.seamew.hystrixconsumer.controller;

import com.seamew.hystrixconsumer.feign.HystrixFeign;
import com.seamew.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
public class HystrixController
{
    @Autowired
    private HystrixFeign hystrixFeign;

    @GetMapping("providerException")
    public Result providerException()
    {
        return hystrixFeign.providerException();
    }

    @GetMapping("providerStatus")
    public Result getProviderStatus()
    {
        //  consumer 连接 provider 失败时会触发 fallback 方法，停掉 provider 即可测试
        return hystrixFeign.getProviderStatus();
    }
}
