package com.imooc.girl.web.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by hmh on 2017/9/12.
 */
public class PredicateDemo {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);

    }

    public static void filter(List<String> names, Predicate<String> condition) {
//        for (String name : names) {
//            if (condition.test(name)) {
//                System.out.print(name + " ");
//            }
//        }

        Predicate<String> startWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;

//        names.stream()
//                .filter((name) -> (condition.test(name)))
//                .forEach((name) -> System.out.print(name + " "));

        names.stream()
                .filter(startWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));

        System.out.println();
    }
}
