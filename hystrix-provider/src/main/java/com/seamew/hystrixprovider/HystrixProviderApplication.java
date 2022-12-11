package com.seamew.hystrixprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
// 开启 hystrix
@EnableCircuitBreaker
public class HystrixProviderApplication
{
    public static void main(String[] args)
    {
        // 服务降级: 服务降级一般是指在服务器压力剧增的时候，根据实际业务使用情况以及流量，对一些服务
        // 和页面有策略的不处理或者用一种简单的方式进行处理，从而释放服务器资源的资源以保证核心业务的
        // 正常高效运行。这里就是模拟服务出现异常或者超时，用一种简单的方式进行处理
        //
        // 这里演示了使用 hystrix 在服务提供方对服务进行降级的功能。hystrix 在这里解决了服务超时或
        // 出错引发的级联出错或级联等待的问题。provider 服务降级的配置步骤如下:
        // 1. 引入 spring-cloud-starter-netflix-hystrix 依赖
        // 2. 在服务提供者的 controller 中创建 fallback 方法
        // 3. 在服务提供者的 controller 要使用 hystrix 的方法上使用 @HystrixCommand 注解配置
        //    该方法出现异常或者超时后的 fallback 方法，以及配置 Hystrix 的参数，例如 Hystrix
        //    的服务执行超时时间
        // 4. 在服务提供方的主启动类上加上 @EnableCircuitBreaker 来启用 hystrix
        SpringApplication.run(HystrixProviderApplication.class, args);
    }
}
