package com.seamew.hystrixprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.seamew.result.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hystrix")
public class HystrixController
{
    @GetMapping("providerStatus")
    public Result getProviderStatus()
    {
        return Result.success("Alive");
    }

    @GetMapping("providerException")
    @HystrixCommand(
        fallbackMethod = "exceptionFallback",
        commandProperties = {
            // 在服务提供方的角度设置的服务超时时间，如果服务的执行时间超过这个设定值，服务就会降级，执行 fallback
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
        }
    )
    public Result exception()
    {
        // 产生一个异常，触发异常 fallback
        int i = 1 / 0;
        return Result.success("exception");
    }

    @HystrixCommand(
        fallbackMethod = "timeoutFallback",
        commandProperties = {
            // 在服务提供方的角度设置的服务超时时间，如果服务的执行时间超过这个设定值，服务就会降级，执行 fallback
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds", value = "3000")
        }
    )
    @GetMapping("providerTimeout")
    public Result timeout() throws InterruptedException
    {
        // 超时，触发超时 fallback
        Thread.sleep(5000);
        return Result.success("timeout");
    }

    @PostMapping("providerFuse")
    @HystrixCommand(
        fallbackMethod = "fuseFallback",
        commandProperties = {
            // 在服务提供方的角度设置的服务超时时间，如果服务的执行时间超过这个设定值，服务就会降级，执行 fallback
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            // 监控时间 默认5000 毫秒
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            // 失败次数。默认20次
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"),
            // 失败率 默认50%
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "50")
        }
    )
    public Result fuse(@RequestParam Boolean shouldThrowException)
    {
        if (shouldThrowException != null && shouldThrowException) {
            // 如果请求中的 shouldThrowException 为 true 就抛出异常，执行 fallback，失败次数
            // 多了以后会触发 hystrix 的熔断机制，其他请求访问这个接口都会降级执行 fallback
            throw new RuntimeException();
        } else {
            return Result.success("No need to fuse");
        }
    }

    public Result exceptionFallback()
    {
        return Result.fail("Provider fallback: exceptionFallback");
    }

    public Result timeoutFallback()
    {
        return Result.fail("Provider fallback: timeoutFallback");
    }

    public Result fuseFallback(Boolean shouldThrowException)
    {
        return Result.fail("Provider fallback: fuseFallback");
    }
}
