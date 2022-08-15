package com.cl.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/9 16:31
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //使用Hystrix
public class PaymentHystrixMain8001 {

    public static void main(String[] args){
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }


    /**
     * 监控仪表盘出现Unable to connect to Command Metric Stream.配置：
     * 此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级的坑
     * ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream",
     * 只要在自己的项目里配置上下的servlet即可
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream"); //在仪表盘里填写的监控地址 例：http://localhost:8001/hystrix.stream
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
