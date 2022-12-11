package com.seamew.hystrixconsumer.controller;

import com.seamew.hystrixconsumer.feign.HystrixFeign;
import com.seamew.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hystrix")
public class HystrixController
{
    @Autowired
    private HystrixFeign hystrixFeign;

    @GetMapping("providerStatus")
    public Result getProviderStatus()
    {
        // consumer 连接 provider 失败时会触发 fallback 方法，停掉 provider 即可测试
        return hystrixFeign.getProviderStatus();
    }

    @GetMapping("providerException")
    public Result providerException()
    {
        return hystrixFeign.providerException();
    }

    @GetMapping("providerTimeout")
    public Result providerTimeout()
    {
        return hystrixFeign.providerTimeout();
    }

    // 当请求中 shouldThrowException 为 true 时，一致发送该请求会触发熔断机制，这个接口在一段
    // 时间内将一直处于服务降级状态
    @PostMapping("providerFuse")
    public Result providerFuse(@RequestParam Boolean shouldThrowException)
    {
        return hystrixFeign.providerFuse(shouldThrowException);
    }
}
