package com.seamew.ribbonprovider.controller;

import com.seamew.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("timeout")
public class TimeoutController {

    @GetMapping("/readTimeout")
    public Result readTimeout() throws InterruptedException {
        Thread.sleep(5000);
        return Result.success();
    }
}
