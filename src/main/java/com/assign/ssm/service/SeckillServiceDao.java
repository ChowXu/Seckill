package com.assign.ssm.service;

import com.assign.ssm.bean.Seckill;
import com.assign.ssm.bean.SuccessKill;
import com.assign.ssm.dto.Exposure;
import com.assign.ssm.dto.SeckillExecution;
import com.assign.ssm.exception.RepeatSeckillException;
import com.assign.ssm.exception.SeckillCloseException;
import com.assign.ssm.exception.SeckillException;

import java.util.Date;
import java.util.List;

/**
 * Created by zhouxi.
 * DATE: 16/12/17.
 * TIME: 上午10:24.
 */


/**
 * 业务接口: 站在使用者的角度 设计接口  很重要
 * 三个方面: 方法定义粒度,参数,返回类型,
 */
public interface SeckillServiceDao {

    /**
     * 查询所有秒杀纪录
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> getSeckillList(int offset, int limit);


    /**
     * 查询单个秒杀纪录
     *
     * @param seckillId
     * @return
     */
    Seckill querySeckillById(int seckillId);

    /**
     * 秒杀开启时候 输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     */
    Exposure exposeSeckillUrl(int seckillId);

    /**
     * execute seckill
     *
     * @param seckillId
     * @param userphone
     * @param md5
     */
    SeckillExecution executeSeckill(int seckillId, long userphone, String md5)
            throws SeckillException, RepeatSeckillException, SeckillCloseException;


}
