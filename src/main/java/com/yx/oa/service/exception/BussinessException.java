package com.yx.oa.service.exception;
//
public class BussinessException extends RuntimeException{
    //异常编码
    private String code;
    //具体异常文本消息
    private String message;
    public BussinessException(String code,String msg){
        //错误的标准描述文本
        super(code + ":" + msg);
        this.code = code;
        this.message = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
