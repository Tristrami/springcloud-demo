package com.seamew.hystrixconsumer.feign.fallback;

import com.seamew.hystrixconsumer.feign.HystrixFeign;
import com.seamew.result.Result;
import org.springframework.stereotype.Component;

@Component
public class HystrixFeignFallback implements HystrixFeign
{
    @Override
    public Result providerException()
    {
        return Result.fail("Consumer fallback: fail");
    }

    @Override
    public Result getProviderStatus()
    {
        return Result.fail("down", "Consumer fallback: provider connect fail fallback");
    }
}
