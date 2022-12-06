package com.seamew.feignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // 扫描带有 @FeignClient 的接口创建实现类并将其注入到容器中
public class FeignConsumerApplication
{
    public static void main(String[] args)
    {
        // 这里使用 ribbon-provider 作为服务提供者，测试 feign 远程调用，有了 feign 之后
        // 我们不需要再关心远程调用的具体逻辑，只需要在本地创建接口，通过注解的方式指明要调用
        // 的服务名称和路径，再调用接口的方法即可完成远程调用，换句话说，feign 可以让我们的远
        // 程调用像调用本地方法一样，具体步骤如下:
        // 1. 引入 spring-cloud-starter-openfeign 依赖
        // 1. 定义 GoodsFeign 接口，使用 @FeignClient 注解声明要调用的服务名称
        // 2. 声明 getGoodsById() 方法，并配合 @GetMapping 声明路径
        // 3. 在 OrderController 中通过 @Autowired 注入 GoodsFeign 依赖，完成远程调用
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
