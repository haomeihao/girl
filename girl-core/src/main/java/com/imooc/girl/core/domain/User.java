package com.imooc.girl.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by hmh on 2017/11/6.
 */
@Entity
@Data
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 3121231231L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String passWord;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String regTime;

    public User(String userName, String passWord, String email, String nickName, String regTime) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.nickName = nickName;
        this.regTime = regTime;
    }
}
