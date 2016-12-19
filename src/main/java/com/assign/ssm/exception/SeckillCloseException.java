package com.assign.ssm.exception;

import com.assign.ssm.bean.SuccessKill;
import com.assign.ssm.dto.SeckillExecution;

/**
 * Created by zhouxi.
 * DATE: 16/12/18.
 * TIME: 上午12:25.
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillCloseException(String message) {
        super(message);
    }
}
