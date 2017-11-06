package com.imooc.girl.parent.mmc;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

import java.util.Map;

/**
 * Created by hmh on 2017/8/28.
 */
public class MMCDemo {

    public static void main(String[] args) {
        init();

        MemCachedClient client = new MemCachedClient();
        client.add("key", 1);
        client.set("key", 2);
        client.replace("key", 3);

        Object value = client.get("key");
        String[] keys = {"key1", "key2"};
        Map<String, Object> values = client.getMulti(keys);

        System.out.println(value);
        System.out.println(values);
    }


    public static void init() {
        String[] services = {"119.23.206.15:11211"};

        SockIOPool pool = SockIOPool.getInstance();

        pool.setServers(services); //设置服务器
        pool.setFailover(true); //容错
        pool.setInitConn(10); //设置初始连接数
        pool.setMinConn(5); //最小连接数
        pool.setMaxConn(25); //最大连接数
        pool.setMaintSleep(30); //连接池维护线程的睡眠时间
        pool.setNagle(false); //是否使用Nagle算法
        pool.setSocketTO(3000); //socket的读取等待超时时间
        pool.setAliveCheck(true); //连接心跳检测开关
        pool.setHashingAlg(SockIOPool.CONSISTENT_HASH); //设置Hash算法

        pool.initialize();
    }

}
