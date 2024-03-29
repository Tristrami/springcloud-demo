package com.seamew.feignconsumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLoggingConfig {

    @Bean
    public Logger.Level level() {
        // NONE: No logging
        // BASIC: Log only the request method and URL and the response status code and execution time
        // HEADERS: Log the basic information along with request and response headers
        // FULL: Log the headers, body, and metadata for both requests and responses
        return Logger.Level.FULL;
    }
}
