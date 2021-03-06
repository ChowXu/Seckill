package com.assign.ssm.dto;

/**
 * Created by zhouxi.
 * DATE: 16/12/19.
 * TIME: 下午3:35.
 */

//all ajax request , 封装ajax 请求结果
public class SeckillResult<T> {

    private boolean success;

    private String error;

    private T data;

    public SeckillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SeckillResult(boolean success, String error) {

        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
