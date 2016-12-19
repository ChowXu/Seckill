package com.assign.ssm.dao;

import com.assign.ssm.bean.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by zhouxi.
 * DATE: 16/12/16.
 * TIME: 下午4:55.
 *
 * seckill dao CURD 增删改查
 */

public interface SeckillDao {

    /**
     * 增加
     * @param seckill
     * @return
     */
    int insertSeckill(Seckill seckill);

    /**
     * 根据ID 查找列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> getSeckillList(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 减少库存
     * @param seckillId
     * @param date
     * @return
     */
    int reduceNum(@Param("seckillId") int seckillId, @Param("killTime") Date date);

    /**
     * 根据ID 查找 Seckill
     * @param seckillId
     * @return
     */
    Seckill queryById(@Param("seckillId") int seckillId);





}
