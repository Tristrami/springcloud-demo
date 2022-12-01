package com.seamew.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication
{
    public static void main(String[] args)
    {
        // 访问 localhost:8761 即可使用 eureka server 图形化界面
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}