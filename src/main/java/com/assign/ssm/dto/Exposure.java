package com.assign.ssm.dto;

/**
 * Created by zhouxi.
 * DATE: 16/12/18.
 * TIME: 上午12:15.
 */

/**
 * dto 的作用
 * 与 bean 的区别
 */
public class Exposure {

    //is exposing
    private boolean exposure;

    private String md5;

    private int seckillId;

    private long now;

    private long start;

    private long end;


    @Override
    public String toString() {
        return "Exposure{" +
                "exposure=" + exposure +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }


    public Exposure(boolean exposure, String md5, int seckillId) {
        this.exposure = exposure;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposure(boolean exposure, int seckillId) {
        this.exposure = exposure;
        this.seckillId = seckillId;
    }



    public Exposure(boolean exposure, int seckillId, long start, long end, long now) {
        this.exposure = exposure;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposure(boolean exposure, long now, long end, long start) {
        this.exposure = exposure;
        this.now = now;
        this.end = end;
        this.start = start;
    }

    public boolean isExposure() {
        return exposure;
    }

    public void setExposure(boolean exposure) {
        this.exposure = exposure;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
