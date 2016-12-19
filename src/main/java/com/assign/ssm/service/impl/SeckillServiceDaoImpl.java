package com.assign.ssm.service.impl;

import com.assign.ssm.dao.SeckillDao;
import com.assign.ssm.dao.SuccessKillDao;
import com.assign.ssm.bean.Seckill;
import com.assign.ssm.bean.SuccessKill;
import com.assign.ssm.dao.cache.RedisDao;
import com.assign.ssm.dto.Exposure;
import com.assign.ssm.dto.SeckillExecution;
import com.assign.ssm.emun.SeckillStateEnum;
import com.assign.ssm.exception.RepeatSeckillException;
import com.assign.ssm.exception.SeckillCloseException;
import com.assign.ssm.exception.SeckillException;
import com.assign.ssm.service.SeckillServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by zhouxi.
 * DATE: 16/12/17.
 * TIME: 上午11:00.
 */

@Service("SeckillServiceDao")
public class SeckillServiceDaoImpl implements SeckillServiceDao {

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKillDao successKillDao;

    @Autowired
    private RedisDao redisDao;

    private final String salt = "sdadfhasdfj;safjsa;dfh`4`234234";


    /**
     * 取出list 集合
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<Seckill> getSeckillList(int offset, int limit) {

        return seckillDao.getSeckillList(offset, limit);
    }


    /**
     * 把 减少库存单独放一个 好蠢, 应该站在用户角度  用户使用系统的过程中 用到的服务 来作为Service 的方法
     * <p>
     * 数据字典 保存 传递到前端数据
     *
     * @param seckillId
     */

    public Seckill querySeckillById(int seckillId) {

        return seckillDao.queryById(seckillId);
    }


    /**
     * 使用注解控制事务的方法的优点
     * 保证事务方法的执行时间尽可能端, 不要穿插 其他网络操作RPC/HTTP 请求或者剥离到事务方法外部
     * 不是所有的方法都需要事务,只读操作 不需要事务控制
     *
     * @param seckillId
     * @param userphone
     * @param md5
     */
    @Transactional
    public SeckillExecution executeSeckill(int seckillId, long userphone, String md5)
            throws SeckillException {

        if (md5 == null || !getMd5(seckillId).equals(md5)) {
            throw new SeckillException("seckill data rewrite");
        }
        /**
         * execute seckill logic
         * reduce stock and record active of bought
         *
         */


        try {
            Date date = new Date();
            //减少库存
            int reduceNum = seckillDao.reduceNum(seckillId, date);
            if (reduceNum <= 0) {
                //秒杀结束  抛出异常
                throw new SeckillCloseException("seckillClose");
            } else {
                // 纪录日志
                int updateSuccess = successKillDao.insertSuccessKillDetail(new SuccessKill(seckillId, userphone, 0, date));

                if (updateSuccess <= 0) {
                    throw new RepeatSeckillException("repeatSeckill");
                } else {
                    //秒杀成功
                    SuccessKill successKill = successKillDao.queryByIdWithSuccessKill(seckillId, userphone);
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKill);


                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (RepeatSeckillException e2) {
            throw e2;

        } catch (SeckillException e) {
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }


    }

    /**
     * 暴露秒杀地址接口  判断 是否可以秒杀
     *
     * @param seckillId
     * @return
     */

    public Exposure exposeSeckillUrl(int seckillId) {

        // 增加一个缓存逻辑,这么简答的东西
        Seckill seckill = redisDao.getSeckill(seckillId);

        if (seckill == null) {
            seckill = seckillDao.queryById(seckillId);
            if (seckill == null) {
                return new Exposure(false, seckillId);
            }
            redisDao.putSeckill(seckill);
        }

        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        // current time
        Date now = new Date();
        if (now.getTime() < startTime.getTime() || now.getTime() > endTime.getTime()) {
            // 这边返回的bean 不对 没有说明是 时间 未到, 还是秒杀已经结束
            return new Exposure(false, seckillId);
        }
        String md5 = getMd5(seckillId); //

        return new Exposure(true, md5, seckillId);
    }


    /**
     * 核心 Md5 的生成方法
     *
     * @param seckillId
     * @return
     */
    private String getMd5(int seckillId) {
        String base = seckillId + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

}
