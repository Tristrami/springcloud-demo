package com.seamew.feignconsumer.feign;

import com.seamew.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ribbon-provider")
public interface GoodsFeign
{
    @GetMapping("/goods/{goodsId}")
    Result getGoodsById(@PathVariable Long goodsId);
}
