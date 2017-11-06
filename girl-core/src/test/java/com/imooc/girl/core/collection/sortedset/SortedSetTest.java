package com.imooc.girl.core.collection.sortedset;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by hmh on 2017/8/11.
 */
public class SortedSetTest {
    public static void main(String[] args) {
        SortedSet allSet = new TreeSet<String>();
        allSet.add("A");
        allSet.add("D");
        allSet.add("C");
        allSet.add("C");
        allSet.add("C");
        allSet.add("B");
        allSet.add("E");
        Comparator comparator = allSet.comparator();
        System.out.println(allSet);
        System.out.println(comparator);
        System.out.println("第一个元素：" + allSet.first());
        System.out.println("最后一个元素：" + allSet.last());
        System.out.println("headSet元素：" + allSet.headSet("C"));
        System.out.println("tailSet元素：" + allSet.tailSet("C"));
        System.out.println("subSet元素：" + allSet.subSet("B", "D"));
    }
}
