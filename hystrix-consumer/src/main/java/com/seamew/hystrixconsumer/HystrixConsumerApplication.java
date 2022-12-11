package com.seamew.hystrixconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.seamew")
public class HystrixConsumerApplication
{
    // 服务降级: 服务降级一般是指在服务器压力剧增的时候，根据实际业务使用情况以及流量，对一些服务
    // 和页面有策略的不处理或者用一种简单的方式进行处理，从而释放服务器资源的资源以保证核心业务的
    // 正常高效运行。这里就是模拟服务出现异常或者超时，用一种简单的方式进行处理
    //
    // 这个模块主要用来测试 hystrix 服务提供方降级和服务消费方降级
    // * 服务提供方降级:
    //   调用 hystrix-provider 服务，主要测试以下两个接口:
    //   1. /hystrix/exception: 测试当 hystrix-provider 服务执行中出现异常后的 fallback
    //   2. /hystrix/timeout: 测试当 hystrix-provider 服务执行超时后的 fallback
    //   服务提供方降级配置步骤见 hystrix-provider 启动类注解
    //
    // * 服务消费方降级:
    //   需要在 consumer 进行服务降级的原因是，如果 provider 本身挂掉了，只能通过 consumer 来
    //   进行服务降级的操作。feign 本身引入了 hystrix 相关的包，所以这里无需再引入。具体配置步骤
    //   如下（以 HystrixFeign 为例）:
    //   1. 创建 HystrixFeign 接口的实现类，并使用 @Component 将实现类放入容器中，实现类中的方
    //      法实际上就是 fallback 方法
    //   2. 在 HystrixFeign 接口上的 @FeignClient 注解中配置 fallback 属性为我们创建的实现类
    public static void main(String[] args)
    {
        SpringApplication.run(HystrixConsumerApplication.class, args);
    }
}
