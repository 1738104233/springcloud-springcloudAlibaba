package com.cl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/1 11:16
 *
 * 注意！官方文档明确给出了警告：
 * 这个自定义配置类不能放在@ComponentScan所扫描的当前包及子包下，
 * 否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的了。
 */
@Configuration
public class MySelfRule {

    /**
     * 配置Ribbon核心组件IRule的规则
     * IRule:根据特定算法从服务列表中选取一个要访问的服务，选择负载均衡算法（轮询、随机.....）
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
