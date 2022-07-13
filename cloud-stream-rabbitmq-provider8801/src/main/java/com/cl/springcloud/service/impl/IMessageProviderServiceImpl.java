package com.cl.springcloud.service.impl;

import com.cl.springcloud.service.IMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.UUID;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/7/8 13:59
 */

@EnableBinding(Source.class)  //将注解@EnableBinding加到应用上就可以实现与消息代理的连接,定义消息的推送管道
public class IMessageProviderServiceImpl implements IMessageProviderService {

    @Resource
    private MessageChannel output;//消息发送管道
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("****serial:"+serial);
        return null;
    }
}
