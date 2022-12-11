package com.seamew.feignconsumer.feign;

import com.seamew.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "ribbon-provider", contextId = "timeoutFeign")
public interface TimeoutFeign
{
    @GetMapping("timeout/readTimeout")
    Result readTimeout();
}
