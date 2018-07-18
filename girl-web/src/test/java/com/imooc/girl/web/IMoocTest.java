package com.imooc.girl.web;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hmh on 2017/11/13.
 */
public class IMoocTest {

    public static void main(String[] args) {
        List<Double> list = Arrays.asList(188.0, 199.0, 288.0, 348.0, 366.0, 388.0, 388.1);

        Double total = list.stream()
                .map((price) -> price)
                .reduce((sum, price) -> sum + price).get();

        System.out.println(total);
    }
}
