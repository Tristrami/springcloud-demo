package com.seamew.consumer.controller;

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
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping
    public Result addOrder(@RequestParam("goodsId") Long goodsId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-provider");
        ServiceInstance serviceInstance = instances.get(0);
        String url = serviceInstance.getScheme()
                + "://" + serviceInstance.getHost()
                + ":" + serviceInstance.getPort()
                + "/goods/" + goodsId;
        return restTemplate.getForObject(url, Result.class);
    }
}