package com.assign.ssm.service.impl;

import com.assign.ssm.Dao.SeckillDao;
import com.assign.ssm.bean.Seckill;
import com.assign.ssm.service.SeckillServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public List<Seckill> getSeckillList(int offset, int limit) {
        return seckillDao.getSeckillList(offset, limit);
    }


}
