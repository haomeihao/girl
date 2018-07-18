package com.imooc.girl.core.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Redis客户端
 * Created by hmh on 2018/3/22.
 */
public class RedisClient {

    private Jedis jedis; //非切片额客户端连接
    private JedisPool jedisPool; //非切片连接池
    private ShardedJedis shardedJedis; //切片额客户端连接
    private ShardedJedisPool shardedJedisPool; //切片连接池

    public RedisClient() {

    }

    /**
     * 初始化非切片池
     */
    private void initialPool() {
        // 池基本配置
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
    }
}
