package com.imooc.girl.core.shiro.service.impl;

import com.imooc.girl.core.shiro.dao.UserInfoDao;
import com.imooc.girl.core.shiro.entity.UserInfo;
import com.imooc.girl.core.shiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hmh on 2017/8/15.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
