package com.cl.springcloud.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/17 17:47
 */
@Data //生成getter,setter ,toString等函数
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor //生成无参构造函数
public class Payment implements Serializable {
    /**
     * 付款id
     */
    private Long payment_id;
    /**
     * 付款号
     */
    private String serial;
}