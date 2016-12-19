package com.assign.ssm.dao.cache;

import com.assign.ssm.bean.Seckill;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by zhouxi.
 * DATE: 16/12/17.
 * TIME: 下午9:15.
 */
public class RedisDao {

    private JedisPool jedisPool;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 建立一种序列化方式
     */
    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    public RedisDao(String ip, int port) {

        jedisPool = new JedisPool(ip, port);
    }

    public Seckill getSeckill(long seckillId) {
        // 获取连接  redis 操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckillId;
                //redis 并未实现内部的序列化操作
                //get -> byte[] -> 反序列化 -> Object(Seckill)
                //protostuff :pojo
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    //Empty object
                    Seckill seckill = schema.newMessage();
                    //make object seckill
                    ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
                    // seckill 反序列化
                    return seckill;
                }
            } finally {
                jedis.close();
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public String putSeckill(Seckill seckill){
        // set Object(seckill) -> byte[]
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                String key = "seckill:"+ seckill.getSeckillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(seckill,schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes(),timeout,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }
        catch(Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }
}
