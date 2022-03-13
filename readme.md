## Feign 消费者调用和负载均衡

* fengn默认使用ribbon，采用轮询策略的负载均衡
* feign自带熔断器，但是默认关闭，需要在配置中打开 feign.hystrix.enabled=true
* feign异常处理工厂类的声明：
   public class UserClientFallbackFactory implements FallbackFactory<UserClient> {...}

## Ribbon 负载均衡

* ribbon和eureka整合，可以直接通过服务名调用服务  

* ribbon在工作时分两步，首先选择eureka server，优先选择负载小的那一台，然后根据用户指定的策略，在某一台选择一个访问地址。  

* 不指定策略就默认是Round轮询  

几种负载均衡策略：

        Round：轮询
        Random：随机
        AvailabilityFilteringRule： 会先过滤掉多次访问失败而处于断路器跳闸状态的服务还有并发连接数量超过阈值的服务，
        对剩余的服务进行轮询访问
        WeightedResponceTimeRule：根据平均响应时间计算出所有服务的权重，响应时间越快，则权重越大，选中几率越高
        刚启动时如果统计信息不足，则使用轮询策略，等统计信息足够，在切换到这个策略
        RetryRule: 先按照轮询策略获取服务，如果获取失败会在指定时间内重试，获取可用的服务。
        BestAvailableRule: 会先过滤掉多次访问失败而处于断路器跳闸状态的服务,在选择并发量最少的一台
        ZoneAvoidanceRule: 默认规则，符合判断服务器所在区域的性能和server可用性选择服务器
        
        
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

## ZipKin链路追踪

ZipKin，开源的跟踪系统，Twitter公司开源，收集服务的定时数据，以解决服务的延迟问题，包括数据手机存储查询和展现
每个服务向ZipKin报告定时数据，ZipKin会根据调用关系生成依赖关系图
除了parent pom外，所有服务都要被追踪，包括注册中心Eureka

## Spring-Cloud-Admin 服务监控

会话数量 健康状态 并发数 延迟


## Spring-Cloud-Config

* 查看配置信息

 http://ip:port/{application}/{profile}/{label}
 http://ip:port/{label}/{application}-{profile}.yml
 http://ip:port/{label}/{application}-{profile}.properties
