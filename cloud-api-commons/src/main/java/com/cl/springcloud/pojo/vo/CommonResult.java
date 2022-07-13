package com.cl.springcloud.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/18 15:26
 * 统一返回到前端格式
 */
@Data //生成getter,setter ,toString等函数
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor //生成无参构造函数
public class CommonResult {
    /**
     *状态码
     */
    private Integer code;
    /**
     * 通知消息
     */
    private String message;
    /**
     * 数据集
     */
    private  String  data;

    /**
     * 没有传入data参数，则默认返回data为null
     * @param code
     * @param message
     */
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
