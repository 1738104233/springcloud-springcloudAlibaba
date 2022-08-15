package com.cl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/1 16:49
 *
 * 自己模拟手写负载均衡轮询算法
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
        current = this.atomicInteger.get();
        //超出边界值之后返回0重新计数
        next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        //CAS自旋锁 如果自旋锁的值和当前的值（current）一致，则更新值为（下一次next），详情看compareAndSet源码
        }while (!this.atomicInteger.compareAndSet(current,next));//更新成功返回true，取反跳出循环执行下面
        System.out.println("第"+next+"次访问次数");
        return next;
    }
    @Override
    public ServiceInstance polling(List<ServiceInstance> serviceInstances) {

        /**
         * index(实际调用服务器位置下标)=getAndIncrement()(请求次数) % serviceInstances.size()(服务器集群总数量)
         * 如:List [0] instances=127.0.0.1:8002
         * List[1] instances=127.0.0.1:8001
         *
         * 8001+8002 组合成为集群，它们共计2台机器，集群总数为2，按照轮询算法原理;
         *
         * 当总请求数为1时:1%2=1对应下标位置为1，则获得服务地址为127.0.0.1:8001
         * 当总请求数位2时:2%2=0对应下标位置为0，则获得服务地址为127.0.0.1:8002
         * 当总请求数位3时:3%2=1对应下标位置为1，则获得服务地址为127.0.0.1:8001
         * 当总请求数位4时:4%2=0对应下标位置为0，则获得服务地址为127.0.0.1:8002如此类推...
         */
        int index= getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
