package com.imooc.girl.core.findwork;

import redis.clients.jedis.Jedis;

/**
 * Created by hmh on 2018/6/27.
 */
public class RedisLock {

    private Jedis jedis; //非切片额客户端连接

    private static final String LOCK_PREFIX = "Redis";
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    public boolean tryLock(String key, String request) {
        String result = this.jedis.set(LOCK_PREFIX + key, request, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 10);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        } else {
            return false;
        }
    }


}
