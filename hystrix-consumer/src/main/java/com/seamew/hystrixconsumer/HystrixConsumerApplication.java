package com.seamew.hystrixconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.seamew")
@EnableHystrixDashboard
public class HystrixConsumerApplication
{
    // 服务降级: 服务降级一般是指在服务器压力剧增的时候，根据实际业务使用情况以及流量，对一些服务
    // 和页面有策略的不处理或者用一种简单的方式进行处理，从而释放服务器资源的资源以保证核心业务的
    // 正常高效运行。这里就是模拟服务出现异常或者超时，用一种简单的方式进行处理
    //
    // 这个模块主要用来测试 hystrix 服务提供方降级和服务消费方降级以及熔断
    // * 服务提供方降级:
    //   调用 hystrix-provider 服务，主要测试以下两个接口:
    //   1. /hystrix/exception: 测试当 hystrix-provider 服务执行中出现异常后的 fallback
    //   2. /hystrix/timeout: 测试当 hystrix-provider 服务执行超时后的 fallback
    //   服务提供方降级配置步骤见 hystrix-provider 启动类注解
    //
    // * 服务消费方降级:
    //   需要在 consumer 进行服务降级的原因是，如果 provider 本身挂掉了，只能通过 consumer 来
    //   进行服务降级的操作。feign 本身引入了 hystrix 相关的包，所以这里无需再引入。具体配置步骤
    //   如下（以 HystrixFeign 为例）:
    //   1. 创建 HystrixFeign 接口的实现类，并使用 @Component 将实现类放入容器中，实现类中的方
    //      法实际上就是 fallback 方法
    //   2. 在 HystrixFeign 接口上的 @FeignClient 注解中配置 fallback 属性为我们创建的实现类
    //
    // 注意: 当 consumer 和 provider 都配置了服务降级时会出现级联降级，也就是说当 provider 降级
    // 返回数据给 consumer 后，consumer 并不会直接将这个数据返回给调用者，而是会触发 consumer 的
    // 降级，consumer 的 fallback 会被执行，相应的，会将 consumer 降级 fallback 返回的数据返回
    // 给调用者
    //
    // 熔断机制:
    // * 当一个接口调用失败次数超过一定阈值时，就会触发 hystrix 的熔断机制，这个机制类似于保险丝，或
    //   者空气开关，也就是说，其他线程来调用这个相同的接口时，都会失败，触发服务降级，开关处于关闭状态。
    //   一段时间后开关变为半开状态，可以开始接受请求，当请求成功次数超过一定阈值时，开关恢复为开启状态
    // 注意: 熔断的对象是某个接口，接口被熔断后会一直处于服务降级状态
    public static void main(String[] args)
    {
        SpringApplication.run(HystrixConsumerApplication.class, args);
    }
}
