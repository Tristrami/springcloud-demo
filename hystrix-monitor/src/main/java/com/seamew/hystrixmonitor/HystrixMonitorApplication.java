package com.seamew.hystrixmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class HystrixMonitorApplication
{

    public static void main(String[] args)
    {
        // hystrix 监控台搭建步骤:
        // * 配置 monitor 服务:
        //   1. 创建 hystrix-monitor 模块，引入 springboot 相关依赖，并将服务注册到 eureka
        //   2. 添加 spring-boot-starter-actuator，spring-cloud-starter-netflix-turbine，
        //      spring-cloud-starter-netflix-hystrix-dashboard 依赖
        //   3. 在 application.yml 中添加相关配置
        //   4. 在启动类上加上 EnableHystrixDashboard 和 EnableTurbine 注解
        //
        // * 配置 hystrix-provider 服务:
        //   1. 添加 spring-boot-starter-actuator，spring-cloud-starter-netflix-hystrix-dashboard 依赖
        //   2. 添加 HystrixConfig 配置类使用 @Bean 创建 ServletRegistrationBean 来配置监控相关的 servlet
        //   3. 在启动类上加上 @EnableHystrixDashboard 注解
        //
        // * 访问 hystrix 监控台
        //   1. 进入监控台: http://localhost:8769/hystrix
        //   2. 在 url 框中输入 http://localhost:8769/turbine.stream
        //   3. 向 hystrix-consumer 发送请求才能看见监控图表，不然会一直在加载状态
        SpringApplication.run(HystrixMonitorApplication.class, args);
    }
}
