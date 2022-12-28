package com.seamew.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayServerApplication
{
    public static void main(String[] args)
    {
        // 网关旨在为微服务架构提供一种简单而有效的统一的 API 路由管理方式，系统中一些与业务无关的公共逻辑可以放在网关服务中，
        // 如认证、鉴权、监控、缓存、负载均衡、流量管控、路由转发等，其主要有以下两个作用:
        // 1. 路由: 网关服务将作为系统的入口，将客户端的请求根据配置的路由映射把请求转发到对应的微服务上，再将结果返回给客户端
        // 2. 过滤: 认证、鉴权、缓存、负载均衡、流量管控等
        // 这里以 hystrix-provider 和 hystrix-consumer 两个服务为例，当前这个 gateway 服务将作为这两个服务的网关，发送到
        // 网关的请求会根据我们在 application.yml 中配置的路由规则转发到相应的服务上，并将结果通过网关服务返回给客户端，同时，
        // application.yml 中定义了全局过滤器和局部过滤器，我们可以通过 /api/api-gateway-server.http 中的请求来测试过滤器
        // 是否生效；spring gateway 中定义了许多过滤器可供我们直接使用
        // https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/
        SpringApplication.run(ApiGatewayServerApplication.class, args);
    }
}
