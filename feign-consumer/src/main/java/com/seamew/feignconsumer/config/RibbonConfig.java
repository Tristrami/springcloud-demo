package com.seamew.feignconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {

    // 使用随机算法
    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
