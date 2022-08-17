package com.wintersing.rule;

import com.alibaba.nacos.client.naming.utils.ThreadLocalRandom;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class CustomRule extends AbstractLoadBalancerRule {

    /**
     * 初始化配置信息
     * @param iClientConfig
     */
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) { }

    /**
     * 负载均衡策略规则，此处以随机数为例，可以写其他的规则或者自己创造的新规则
     * @param o
     * @return
     */
    @Override
    public Server choose(Object o) {
        ILoadBalancer iLoadBalancer = this.getLoadBalancer();
        //获取当前请求的服务实例
        List<Server> reachableServers = iLoadBalancer.getReachableServers();
        //根据服务实例产生随机数
        int random = ThreadLocalRandom.current().nextInt(reachableServers.size());
        //获取此随机数下的服务
        Server server = reachableServers.get(random);
        return server;
    }
}
