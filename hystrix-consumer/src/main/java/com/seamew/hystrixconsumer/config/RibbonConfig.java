package com.seamew.hystrixconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig
{
    // 使用轮询算法
    @Bean
    public IRule rule()
    {
        return new RoundRobinRule();
    }
}
