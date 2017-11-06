package com.imooc.girl.core.repository;

import com.imooc.girl.core.domain.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by hmh on 2017/11/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest  {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void findByFirstName() {
        Customer bob = repository.findByFirstName("Bob");
        Assert.assertNotNull(bob);
        System.out.println(bob.toString());
    }

    @Test
    public void findByLastName() {
        List<Customer> customers = repository.findByLastName("Smith");
        Assert.assertNotEquals(0, customers.size());
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 1);
        Page<Customer> customers = repository.findAll(pageRequest);
        Assert.assertNotEquals(0, customers.getTotalElements());
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void test() {
        System.out.println("测试");
    }

}