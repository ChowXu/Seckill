package com.assign.ssm.bean;

import java.util.Date;

/**
 * Created by zhouxi.
 * DATE: 16/12/17.
 * TIME: 下午2:26.
 */
public class SuccessKill {

    private int seckillId;
    private long userPhone;
    private int state;
    private Date createTime;

    //many to one
    private Seckill seckill;

    public SuccessKill() {
    }

    @Override
    public String toString() {
        return "SuccessKill{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ", seckill=" + seckill.toString() +
                '}';
    }

    public SuccessKill(int seckillId, long userPhone, int state, Date createTime) {
        this.seckillId = seckillId;
        this.userPhone = userPhone;
        this.state = state;
        this.createTime = createTime;
    }

    public SuccessKill(long userPhone, int seckillId, int state, Seckill seckill, Date createTime) {
        this.userPhone = userPhone;
        this.seckillId = seckillId;
        this.state = state;
        this.seckill = seckill;
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public int getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(int seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
