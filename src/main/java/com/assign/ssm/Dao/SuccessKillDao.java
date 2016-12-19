package com.assign.ssm.dao;

import com.assign.ssm.bean.SuccessKill;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zhouxi.
 * DATE: 16/12/17.
 * TIME: 下午2:15.
 */

public interface SuccessKillDao {

    int insertSuccessKillDetail(SuccessKill successKill);

    SuccessKill queryByIdWithSuccessKill(@Param("seckillId") int seckillId, @Param("userPhone") long userPhone);


}
