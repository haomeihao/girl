//package com.imooc.girl.core;
//
//import com.imooc.girl.core.domain.Customer;
//import com.imooc.girl.core.repository.CustomerRepository;;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
///**
// * Created by hmh on 2017/8/2.
// */
////@SpringBootApplication
//public class CustomerApplication implements CommandLineRunner {
//
//    private static final Logger log = LoggerFactory.getLogger(CustomerApplication.class);
//
//    @Autowired
//    private CustomerRepository repository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(CustomerApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        repository.deleteAll();
//
//        // save a couple of customers
//        repository.save(new Customer("Alice", "Smith"));
//        repository.save(new Customer("Bob", "Smith"));
//
//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (Customer customer : repository.findAll()) {
//            System.out.println(customer);
//        }
//        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByFirstName("Alice"));
//
//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (Customer customer : repository.findByLastName("Smith")) {
//            System.out.println(customer);
//        }
//    }
//}
