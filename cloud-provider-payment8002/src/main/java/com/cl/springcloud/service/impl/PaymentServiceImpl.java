package com.cl.springcloud.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cl.springcloud.dao.PaymentDao;
import com.cl.springcloud.pojo.po.Payment;
import com.cl.springcloud.pojo.vo.CommonResult;
import com.cl.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/18 16:37
 */
@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    //获取yml文件里配置的端口
    @Value("${server.port}")
    private String serverPort;
    @Override
    public CommonResult createPayment(String serial) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(serial);
            String serial1 = jsonObject.getString("serial");
            int payment = paymentDao.createPayment(serial1);
            log.info("createPayment---serverPort"+serverPort+"---添加结果："+payment);
            if (payment > 0){
                return new CommonResult(200,"Success serverPort:"+serverPort, JSONObject.toJSONString(payment));
            }
            return new CommonResult(200,"Null", JSONObject.toJSONString(""));
        }catch (Exception e){
            log.error(e);
            return new CommonResult(404,"Exception", JSONObject.toJSONString(e));
        }

    }

    @Override
    public CommonResult getPaymentById(String paymentId) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(paymentId);
            String paymentId1 = jsonObject.getString("paymentId");
            Payment paymentResult = paymentDao.getPaymentById(Long.decode(paymentId1));
            log.info("getPaymentById---serverPort"+serverPort+"---查询结果："+paymentResult);
            if (paymentResult!=null){
                return new CommonResult(200,"Success serverPort:"+serverPort, JSONObject.toJSONString(paymentResult));
            }else {
                return new CommonResult(200,"Null", JSONObject.toJSONString(""));
            }
        }catch (Exception e){
            log.error(e);
            return new CommonResult(404,"Exception", JSONObject.toJSONString(e));
        }
    }
}
