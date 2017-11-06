package com.imooc.girl.core.redis;

import com.imooc.girl.core.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by hmh on 2017/11/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws InterruptedException {
        User user = new User("aa", "aa123456", "aa@126.com", "AA","123");
        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("com.imooc", user);
        valueOperations.set("com.imooc.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        Boolean exist = redisTemplate.hasKey("com.imooc.f");
        if (exist) {
            System.out.println("exist is true");
        } else {
            System.out.println("exist is false");
        }
        Assert.assertEquals("aa", valueOperations.get("com.imooc").getUserName());
    }

}
