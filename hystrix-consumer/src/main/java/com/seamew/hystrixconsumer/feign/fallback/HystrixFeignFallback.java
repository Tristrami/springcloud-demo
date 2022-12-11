package com.seamew.hystrixconsumer.feign.fallback;

import com.seamew.hystrixconsumer.feign.HystrixFeign;
import com.seamew.result.Result;
import org.springframework.stereotype.Component;

@Component
public class HystrixFeignFallback implements HystrixFeign
{
    @Override
    public Result getProviderStatus()
    {
        return Result.fail("Consumer fallback: getProviderStatus");
    }

    @Override
    public Result providerException()
    {
        return Result.fail("Consumer fallback: providerException");
    }

    @Override
    public Result providerTimeout()
    {
        return Result.fail("Consumer fallback: providerTimeout");
    }

    @Override
    public Result providerFuse(Boolean shouldThrowException)
    {
        return Result.fail("Consumer fallback: providerFuse");
    }
}
