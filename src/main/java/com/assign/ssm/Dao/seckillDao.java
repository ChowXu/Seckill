package com.assign.ssm.Dao;

import com.assign.ssm.bean.Seckill;

import java.util.List;

/**
 * Created by zhouxi.
 * DATE: 16/12/16.
 * TIME: 下午4:55.
 *
 * seckill Dao CURD 增删改查
 */
public interface seckillDao {

    int insertSeckill(Seckill seckill);

    List<Seckill> getSeckillList();

    void deleteSeckill(Seckill seckill);

    int updateSeckill(Seckill seckill);

}
