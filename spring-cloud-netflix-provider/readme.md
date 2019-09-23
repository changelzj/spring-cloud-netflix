## Feign 消费者调用和负载均衡

* fengn默认使用ribbon，采用轮询策略的负载均衡
* feign自带熔断器，但是默认关闭，需要在配置中打开 feign.hystrix.enabled=true
* feign异常处理类的声明：
   public class UserClientFallbackFactory implements FallbackFactory<UserClient> {...}

## Hystrix 熔断器

用于处理分布式系统的延迟和容错的开源库
熔断器本身是一种开关装置，当某个服务单元发生故障后，通过断路器的故障监控，
向调用方法返回一个符合预期的，可处理的备选响应，而不是长时间的等待或抛出调用方法无法处理的异常，这样就保证了服务调用方的线程不会被长时间不必要的占用，从而避免故障在分布式系统中的蔓延，乃至雪崩

功能：

    1. 熔断
    2. 降级
    3. 限流
    4. 实时监控
    


## Hystrix Dashboard 熔断器监控：七色一圈一线

实心圆：大小和颜色 
颜色变化反应健康程度：绿最健康，然后依次是黄橙红
大小变化反应流量，流量越大圆面积越大

## Zuul 路由网关：过滤和路由

1.负责将外部请求转发到某个微服务的实例上，起到安全加固的作用
2.Zuul也要整合进入Eureka
3.Zuul默认和Ribbon结合实现了负载均衡
基本访问格式：网关+服务+API: http://host:port/{service-name}/api/api

