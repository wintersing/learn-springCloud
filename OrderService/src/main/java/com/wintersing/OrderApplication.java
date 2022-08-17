package com.wintersing;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.wintersing.rule.CustomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
@RibbonClients(value = {
        @RibbonClient(name = "userservice")
})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    public IRule iRule(){//方法名一定叫iRule，遵循约定大于配置
//        return new RandomRule();//使用随机负载均衡策略
//        return new NacosRule();//指定使用Nacos提供的负载均衡策略（优先调用统一集群的实例，基于随机权重）
        return new CustomRule();//自定义的rule
    }

}
