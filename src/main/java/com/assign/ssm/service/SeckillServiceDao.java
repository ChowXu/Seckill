package com.assign.ssm.service;

import com.assign.ssm.bean.Seckill;

import java.util.List;

/**
 * Created by zhouxi.
 * DATE: 16/12/17.
 * TIME: 上午10:24.
 */


public interface SeckillServiceDao {

    List<Seckill> getSeckillList(int offset, int limit);


}
