package com.seamew.ha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerHighAvailabilityApplication {

    public static void main(String[] args) {
        // 搭建 eureka 高可用集群的步骤:
        // 1. 创建 springboot 项目，引入 eureka 相关依赖，在主启动类上加上 @EnableEurekaServer 注解
        // 2. 在 application.yml 中添加 eureka 相关配置:
        //    (1) 配置主机名: eureka.instance.hostname，主机名可能需要在 hosts 文件中配置
        //    (2) 配置应用名称: 集群中的实例的 spring.application.name 属性都配置为相同的值
        // 3. 集群实例相互注册，即配置 client.server-url.defaultZone 属性
        // 4. 配置 eureka client 的client.server-url.defaultZone 属性，将集群所有节点的 ip:port 都配置到属性中，以逗号分隔
        SpringApplication.run(EurekaServerHighAvailabilityApplication.class, args);
    }
}
