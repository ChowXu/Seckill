package com.assign.ssm.dto;

import com.assign.ssm.bean.SuccessKill;
import com.assign.ssm.emun.SeckillStateEnum;

/**
 * Created by zhouxi.
 * DATE: 16/12/18.
 * TIME: 上午12:21.
 */
public class SeckillExecution {

    private int seckillId;

    //execute result state    1  秒杀成功
    private int state;
    //state presentation
    private String stateInfo;
    //seckill success object
    private SuccessKill successKill;

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKill=" + successKill.toString() +
                '}';
    }

    public SeckillExecution(int seckillId, SeckillStateEnum seckillStateEnum, SuccessKill successKill) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getSate();
        this.stateInfo = seckillStateEnum.getStateInfo();
        this.successKill = successKill;
    }

    public SeckillExecution(int seckillId, SeckillStateEnum seckillStateEnum) {
        this.seckillId = seckillId;
        this.stateInfo = seckillStateEnum.getStateInfo();
        this.state = seckillStateEnum.getSate();
    }

    public int getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(int seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKill getSuccessKill() {
        return successKill;
    }

    public void setSuccessKill(SuccessKill successKill) {
        this.successKill = successKill;
    }
}
