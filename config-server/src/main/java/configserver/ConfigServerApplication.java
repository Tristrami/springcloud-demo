package configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication
{
    public static void main(String[] args)
    {
        // config-server 将从我们配置的 git 远程仓库中获取配置文件，支持用以下几种形式的 url 获取配置文件
        // localhost:8888/foo/development
        // localhost:8888/foo/development/master
        // localhost:8888/foo/development,db/master
        // localhost:8888/foo-development.yml
        // localhost:8888/foo-db.properties
        // localhost:8888/master/foo-db.properties
        // 这里以 hystrix-provider 为例，将其作为 config-client，把它原来的配置文件删除，创建新的配置文件
        // bootstrap.yml，在其中定义 config-server 的 url，这样 hystrix-provider 在启动时就会先尝试去
        // 通过 config-server 获取配置文件
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
