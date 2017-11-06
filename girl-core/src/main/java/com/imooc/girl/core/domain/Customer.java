package com.imooc.girl.core.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by hmh on 2017/8/2.
 */
@Log4j
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
