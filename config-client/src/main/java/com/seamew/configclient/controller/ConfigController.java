package com.seamew.configclient.controller;

import com.seamew.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("config")
public class ConfigController {

    @Value("${message}")
    private String message;

    @GetMapping("message")
    public Result getMessage() {
        return Result.success(message);
    }
}
