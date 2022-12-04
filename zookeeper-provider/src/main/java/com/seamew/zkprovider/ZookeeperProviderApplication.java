package com.seamew.zkprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// 启用服务注册中心客户端 DiscoveryClient 实现类，这个接口封装了具有服务注册中心中基本的读操作，
// 例如获取一个服务，在启动类上使用这个注解后 spring 会将这个程序作为服务注册到注册中心中
@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperProviderApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ZookeeperProviderApplication.class, args);
    }
}
