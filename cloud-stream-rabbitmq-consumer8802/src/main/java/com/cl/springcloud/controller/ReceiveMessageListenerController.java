package com.cl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/7/11 10:49
 */

@Component
@EnableBinding(Sink.class) //将注解@EnableBinding加到应用上就可以实现与消息代理的连接,定义消息的接收管道
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    //@StreamListener：它定义到方法上后会将被修饰的方法注册到消息中间件上数据流的时间监听器，注解中的属性对应监听的消息通道名
    @StreamListener(Sink.INPUT) // 根据通道名称监听通道
    public void input(Message<String> message){//使用Message类型接收消息
      System.out.println("消费者1号------>接收到的消息："+message.getPayload()+"\t   port："+serverPort);
    }

}
