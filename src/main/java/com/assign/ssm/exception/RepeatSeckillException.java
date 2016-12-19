package com.assign.ssm.exception;

import com.assign.ssm.dto.SeckillExecution;

/**
 * Created by zhouxi.
 * DATE: 16/12/18.
 * TIME: 上午12:25.
 */
public class RepeatSeckillException extends SeckillException {
    public RepeatSeckillException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatSeckillException(String message) {
        super(message);
    }
}
