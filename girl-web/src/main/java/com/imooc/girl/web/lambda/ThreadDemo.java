package com.imooc.girl.web.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hmh on 2017/9/12.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        /** 1 */
        // java8 之前
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Before Java8, too much code for too little to do");
//            }
//        }).start();

        // java8 方式
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();

        /** 2 */
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        for (String feature : features) {
//            System.out.println(feature);
//        }

//        features.forEach(n -> System.out.println(n));
        features.forEach(System.out::println);


    }
}
