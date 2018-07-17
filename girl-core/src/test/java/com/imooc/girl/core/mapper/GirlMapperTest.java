package com.imooc.girl.core.mapper;

import com.imooc.girl.core.mapper.slave.GirlMapper;
import com.imooc.girl.core.model.Girl;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by hmh on 2017/11/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlMapperTest extends TestCase {

    @Autowired
    private GirlMapper girlMapper;

    @Autowired
    private GirlDemoMapper girlDemoMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        Girl girl = girlMapper.selectByPrimaryKey(1);
        Assert.assertNotNull(girl);
    }

    @Test
    public void getOne() {
        com.imooc.girl.core.domain.Girl one = girlDemoMapper.getOne(1);
        Assert.assertNotNull(one);
    }

    @Test
    public void getAll() {
        List<com.imooc.girl.core.domain.Girl> all = girlDemoMapper.getAll();
        Assert.assertNotEquals(0, all.size());
    }

}