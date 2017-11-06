package com.imooc.girl.core.shiro.dao;

import com.imooc.girl.core.shiro.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hmh on 2017/8/15.
 */
public interface UserInfoDao extends CrudRepository<UserInfo, Long> {
    /**
     * 通过username查找用户信息;
     */
    public UserInfo findByUsername(String username);
}
