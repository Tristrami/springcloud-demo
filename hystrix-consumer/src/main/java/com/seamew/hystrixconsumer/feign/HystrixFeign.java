package com.seamew.hystrixconsumer.feign;

import com.seamew.hystrixconsumer.config.FeignLoggingConfig;
import com.seamew.hystrixconsumer.feign.fallback.HystrixFeignFallback;
import com.seamew.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
    name = "hystrix-provider",
    contextId = "hystrixFeign",
    configuration = FeignLoggingConfig.class,
    fallback = HystrixFeignFallback.class
)
public interface HystrixFeign
{
    @GetMapping("/hystrix/providerException")
    Result providerException();

    @GetMapping("/hystrix/providerStatus")
    Result getProviderStatus();
}
