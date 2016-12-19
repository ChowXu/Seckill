package com.assign.ssm.emun;

/**
 * Created by zhouxi.
 * DATE: 16/12/18.
 * TIME: 下午4:10.
 */
public enum SeckillStateEnum {

    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEAT_KILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据篡改");


    private int state;

    private String stateInfo;



    SeckillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getSate() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    // 枚举 的语法  state  和  stateInfo 两个字段
    public static SeckillStateEnum stateOf(int index) {
        for (SeckillStateEnum state : values()) {
            if (state.getSate() == index) {
                return state;
            }
        }
        return null;
    }
}
