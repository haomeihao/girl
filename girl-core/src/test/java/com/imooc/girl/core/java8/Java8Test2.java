package com.imooc.girl.core.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hmh on 2017/8/1.
 */
public class Java8Test2 {
    public static void main(String args[]) {
        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println);
    }
}
