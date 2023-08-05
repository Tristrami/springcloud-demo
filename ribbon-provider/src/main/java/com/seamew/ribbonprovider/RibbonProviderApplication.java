package com.seamew.ribbonprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonProviderApplication {

    public static void main(String[] args) {
        // 这里以 eureka 作为服务注册中心，启动多个 ribbon-provider 服务实例，测试 ribbon
        // 负载均衡；在 idea 中启动多个实例的步骤如下:
        // 1. 点击顶部运行按钮旁边的白框，选择 Edit Configurations... 选项
        // 2. 在侧边栏中选择 ribbon-provider 项目
        // 3. 在 build and run 部分的设置中点击 Modify options 按钮，勾选 Allow multiple instances 选项
        // 4. 启动 ribbon-provider
        // 5. 更改 application.yml 中的 server.port 属性，再次启动 ribbon-provider，就会有两个运行在不同
        //    端口的服务实例了

        SpringApplication.run(RibbonProviderApplication.class, args);
    }
}
