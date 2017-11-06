package com.imooc.girl.core.shiro.service;

import com.imooc.girl.core.shiro.entity.UserInfo;

/**
 * Created by hmh on 2017/8/15.
 */
public interface UserInfoService {
    /**
     * 通过username查找用户信息;
     */
    public UserInfo findByUsername(String username);
}
