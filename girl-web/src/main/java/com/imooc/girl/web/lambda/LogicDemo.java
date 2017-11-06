package com.imooc.girl.web.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by hmh on 2017/9/12.
 */
public class LogicDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.print("输出所有数字：");
        evaluate(list, (n) -> true);

        System.out.print("不输出：");
        evaluate(list, (n) -> false);

        System.out.print("输出偶数：");
        evaluate(list, (n) -> n % 2 == 0);

        System.out.print("输出奇数：");
        evaluate(list, (n) -> n % 2 == 1);

        System.out.print("输出大于 5 的数字：");
        evaluate(list, (n) -> n > 5);
    }

    public static void evaluate(List<Integer> names, Predicate<Integer> condition) {
//        for (Integer n : list) {
//            if (predicate.test(n)) {
//                System.out.print(n + " ");
//            }
//        }

        names.stream()
                .filter((name) -> (condition.test(name)))
                .forEach((name) -> System.out.print(name + " "));

        System.out.println();
    }
}
