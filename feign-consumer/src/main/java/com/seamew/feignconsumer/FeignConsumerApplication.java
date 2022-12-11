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
        // * 这里使用 ribbon-provider 作为服务提供者，测试 feign 远程调用，有了 feign 之后
        //   我们不需要再关心远程调用的具体逻辑，只需要在本地创建接口，通过注解的方式指明要调用
        //   的服务名称和路径，再调用接口的方法即可完成远程调用，换句话说，feign 可以让我们的远
        //   程调用像调用本地方法一样，具体步骤如下:
        //   1. 引入 spring-cloud-starter-openfeign 依赖
        //   2. 定义 GoodsFeign 接口，使用 @FeignClient 注解声明要调用的服务名称
        //   3. 声明 getGoodsById() 方法，并配合 @GetMapping 声明路径
        //   4. 在 OrderController 中通过 @Autowired 注入 GoodsFeign 依赖，完成远程调用
        //
        // * 在 application.yml 中还配置了 ribbon 远程调用的超时时间
        //   1. ConnectTimeout: 连接超时时间，指的是 ribbon 进行远程调用时连接远程服务的超时时间
        //   2. ReadTimeout: 读数据（逻辑运算）超时时间，指的是连接上远程服务后，从远程服务获取数据的超时时间
        //
        // * 设置 feign 日志:
        //   1. 创建配置类 FeignLoggingConfig
        //   2. 在配置类中创建 Logger.Level 类型对象
        //   3. 在 application.yml 中配置 logging.level.[packageName] 值为 DEBUG，这里的意思是在
        //      [packageName] 包下的 feign 调用都打印 DEBUG 级别的日志
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
