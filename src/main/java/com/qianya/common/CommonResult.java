package com.qianya.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CommonResult<T> implements Serializable {

    private long code;
    private String msg;
    private T data;

    public CommonResult() {
    }

    public CommonResult(long code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static<T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),data);
    }
    public static<T> CommonResult<T> success(){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),null);
    }

    public static<T> CommonResult<T> erro(String message){
        return new CommonResult<>(ResultCode.FAILED.getCode(),message,null);
    }
    public static<T> CommonResult<T> erro(T data){
        return new CommonResult<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(),data);
    }
    public static<T> CommonResult<T> erro(){
        return new CommonResult<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(),null);
    }

    public static<T> CommonResult<T> erro(long code, String message){
        return new CommonResult<>(code,message,null);
    }

    /**
     * 未登陆返回结果
     */
    public static<T> CommonResult<T> noLogin(T data){
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(),data);
    }
    /**
     * 未授权返回结果
     */
    public static<T> CommonResult<T> noPermission(T data){
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(),data);
    }
    /**
     * 参数验证失败返回结果
     */
    public  static<T> CommonResult<T> validateFailed(){
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), ResultCode.VALIDATE_FAILED.getMessage(),null);
    }

    public  static<T> CommonResult<T> validateFailed(String message){
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(),message,null);
    }
}
