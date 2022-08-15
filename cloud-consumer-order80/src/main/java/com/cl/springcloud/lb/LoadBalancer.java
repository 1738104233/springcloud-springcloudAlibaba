package com.cl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/1 16:24
 */
public interface LoadBalancer {
 /**
  * 自定义负载均衡轮询算法
  * @param serviceInstances  能够提供服务器机器的集合
  * @return
  */
 ServiceInstance polling(List<ServiceInstance> serviceInstances);
}
