package com.seamew.hystrixconsumer.feign;

import com.seamew.hystrixconsumer.config.FeignLoggingConfig;
import com.seamew.hystrixconsumer.feign.fallback.HystrixFeignFallback;
import com.seamew.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "hystrix-provider",
    contextId = "hystrixFeign",
    configuration = FeignLoggingConfig.class,
    fallback = HystrixFeignFallback.class
)
public interface HystrixFeign
{
    @GetMapping("/hystrix/providerStatus")
    Result getProviderStatus();

    @GetMapping("/hystrix/providerException")
    Result providerException();

    @GetMapping("/hystrix/providerTimeout")
    Result providerTimeout();

    // 如果请求有参数要使用 @RequestParam 绑定参数
    @PostMapping("/hystrix/providerFuse")
    Result providerFuse(@RequestParam Boolean shouldThrowException);
}
