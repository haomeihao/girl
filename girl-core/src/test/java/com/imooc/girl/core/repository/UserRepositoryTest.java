package com.imooc.girl.core.repository;

import com.imooc.girl.core.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hmh on 2017/11/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void findByUserName() {
        User aa = userRepository.findByUserName("aaa");
        Assert.assertNotNull(aa);
    }

    @Test
    public void findByEmail() {
//        User aa = userRepository.findByEmail("aaa@126.com");
//        Assert.assertNotNull(aa);
    }
}

