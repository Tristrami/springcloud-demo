package com.seamew.ribbonconsumer.controller;

import com.seamew.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController
{
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Result addOrder(@RequestParam("goodsId") Long goodsId)
    {
        // 使用 ribbon 负载均衡客户端后，主机名直接写服务名，端口号无需指定，ribbon 会根据
        // 响应的负载均衡算法将请求分散到不同端口的服务实例
        String url = "http://ribbon-provider/goods/" + goodsId;
        return restTemplate.getForObject(url, Result.class);
    }
}