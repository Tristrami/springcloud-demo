package com.seamew.feignconsumer.controller;

import com.seamew.feignconsumer.feign.TimeoutFeign;
import com.seamew.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("timeout")
public class TimeoutController
{
    @Autowired
    private TimeoutFeign timeoutFeign;

    @GetMapping("/readTimeout")
    public Result readTimeout() throws InterruptedException
    {
        return timeoutFeign.readTimeout();
    }
}
