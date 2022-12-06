package com.seamew.ribbonconsumer;

import com.seamew.ribbonconsumer.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
// 声明式的配置 ribbon 客户端，在这里可以配置负载均衡算法，name 代表服务名，configuration 代表配置类，
// 也就是配置调用某个服务时使用某一个配置
@RibbonClient(name = "ribbon-provider", configuration = RibbonConfig.class)
public class RibbonConsumerApplication
{
    public static void main(String[] args)
    {
        // 这里使用 eureka 作为服务注册中心，使用具有负载均衡功能的 RestTemplate 调用
        // ribbon-provider 服务，ribbon-provider 将会在不同的端口上启动多个实例，我
        // 们不断的发送请求就可以测试 ribbon 的客户端负载均衡功能
        //
        // 同时我们也可以自定义 ribbon 的负载均衡策略，可以通过编程方式配置（见 config/RibbonConfig），
        // 也可以通过配置文件配置（见 application.yml），要注意的是，由于是 consumer 调用 provider 服
        // 务，所以 ribbon 负载均衡作用于 consumer 这里，负载均衡策略需要在服务调用者，也就是 consumer
        // 这里配置
        // * 编程方式配置:
        // 1. 创建配置类，使用 @Bean 向容器中放入 IRule 实现类
        // 2. 在主启动类上添加 @RibbonClient 注解配置调用某个服务使用的配置类
        // * 配置文件配置:
        // 1.
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }
}
