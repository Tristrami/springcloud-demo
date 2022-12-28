package com.seamew.hystrixconsumer.feign;

import com.seamew.hystrixconsumer.config.FeignLoggingConfig;
import com.seamew.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient 的 value (alias for 'name') 属性代表要调用的服务名称
// 有多个 @FeignClient 时, 如果 value 属性相同，那么可以指定不同的 contextId 属性
@FeignClient(value = "hystrix-provider", contextId = "goodsFeign", configuration = FeignLoggingConfig.class)
public interface GoodsFeign
{
    @GetMapping("/goods/{goodsId}")
    Result getGoodsById(@PathVariable Long goodsId);
}
