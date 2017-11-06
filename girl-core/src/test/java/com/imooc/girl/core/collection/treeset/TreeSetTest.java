package com.imooc.girl.core.collection.treeset;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by hmh on 2017/8/11.
 * 有序排序，排序正确需重写compareTo()，如不，会报异常
 * java.lang.ClassCastException: com.imooc.collection.Person cannot be cast to java.lang.Comparable
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<Person> allSet = new TreeSet<Person>();
        allSet.add(new Person("张三", 30));
        allSet.add(new Person("李四", 31));
        allSet.add(new Person("王五", 32));
        allSet.add(new Person("王五", 32));
        allSet.add(new Person("王五", 32));
        allSet.add(new Person("赵六", 33));
        allSet.add(new Person("孙七", 33));
        Iterator allSetIterator = allSet.iterator();
        while (allSetIterator.hasNext()) {
            System.out.println(allSetIterator.next());
        }
    }
}