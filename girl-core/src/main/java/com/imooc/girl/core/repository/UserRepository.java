package com.imooc.girl.core.repository;

import com.imooc.girl.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hmh on 2017/11/6.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String userName, String email);
}
