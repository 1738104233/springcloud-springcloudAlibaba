package com.cl.springcloud.unified.result;

import com.alibaba.fastjson.JSON;
import com.cl.springcloud.unified.code.ResultCode;
import com.cl.springcloud.unified.code.StatusCode;

import lombok.Data;
import lombok.Getter;

/**
 * 统一返回结果集
 */
@Getter
public class CommonResultVO {
    /**
     *状态码
     */
    private String code;
    /**
     * 通知消息
     */
    private String message;
    /**
     * 数据集
     */
    private Object data;


   public CommonResultVO(){

   }

    /**
     * 手动设置返回VO
     * @param code
     * @param message
     * @param data
     */
    public CommonResultVO(String code, String message, Object data) {
        this.code = code;
        this.message = message;
//        //如果是String类型就不用toJsonString转换了,否则会出现““data””
//        if (data.getClass().equals(String.class)) {
//            this.data = (String) data;
//        } else {
//            this.data = JSON.toJSONString(data);
//        }
        this.data = data;
    }


    /**
     * 默认返回成功状态码,成功消息,数据对象
     * @param data
     */
    public CommonResultVO(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
//        //如果是String类型就不用toJsonString转换了,否则会出现““data””
//        if (data.getClass().equals(String.class)) {
//            this.data = (String) data;
//        } else {
//            this.data = JSON.toJSONString(data);
//        }
        this.data = data;
    }

    /**
     * 返回指定状态码,指定消息,数据对象
     * @param statusCode
     * @param data
     */
    public CommonResultVO(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
//        //如果是String类型就不用toJsonString转换了,否则会出现““data””
//        if (data.getClass().equals(String.class)) {
//            this.data = (String) data;
//        } else {
//            this.data = JSON.toJSONString(data);
//        }
        this.data = data;
    }

}
