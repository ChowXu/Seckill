package com.assign.ssm.exception;

/**
 * Created by zhouxi.
 * DATE: 16/12/18.
 * TIME: 上午12:25.
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillException(String message) {
        super(message);
    }
}
