package com.imooc.girl.web.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hmh on 2017/9/12.
 */
public class MapReduceDemo {
    public static void main(String[] args) {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);

        // 不使用lambda表达式为每个订单加上12%的税
//        double total = 0;
//        for (Integer cost : costBeforeTax) {
//            double price = cost + .12*cost;
////            System.out.println(price);
//            total = total + price;
//        }
//        System.out.println("Total : " + total);

        // 使用lambda表达式
//        costBeforeTax.stream()
//                .map((cost) -> cost + .12*cost)
//                .forEach(System.out::println);
        double bill = costBeforeTax.stream()
                .map((cost) -> cost + .12 * cost)
                .reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);

    }
}
