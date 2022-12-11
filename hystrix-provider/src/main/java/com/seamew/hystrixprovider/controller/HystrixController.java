package com.seamew.hystrixprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.seamew.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
public class HystrixController
{
    @GetMapping("status")
    public Result getProviderStatus()
    {
        return Result.success("Alive");
    }

    @GetMapping("exception")
    @HystrixCommand(
        fallbackMethod = "exceptionFallback", commandProperties = {
            @HystrixProperty(
                // 在服务提供方的角度设置的服务超时时间，如果服务的执行时间超过这个设定值，服务就会降级，执行 fallback
                name ="execution.isolation.thread.timeoutInMilliseconds",
                value = "3000"
            )
        }
    )
    public Result exception()
    {
        // 产生一个异常，触发异常 fallback
        int i = 1 / 0;
        return Result.success("exception");
    }

    @HystrixCommand(
        fallbackMethod = "timeoutFallback", commandProperties = {
            @HystrixProperty(
                // 在服务提供方的角度设置的服务超时时间，如果服务的执行时间超过这个设定值，服务就会降级，执行 fallback
                name ="execution.isolation.thread.timeoutInMilliseconds",
                value = "3000"
            )
        }
    )
    @GetMapping("timeout")
    public Result timeout() throws InterruptedException
    {
        // 超时，触发超时 fallback
        Thread.sleep(5000);
        return Result.success("timeout");
    }

    public Result exceptionFallback()
    {
        return Result.fail("exceptionFallback");
    }

    public Result timeoutFallback()
    {
        return Result.fail("timeoutFallback");
    }
}
