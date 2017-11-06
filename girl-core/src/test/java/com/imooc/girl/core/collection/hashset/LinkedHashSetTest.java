package com.imooc.girl.core.collection.hashset;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by hmh on 2017/8/11.
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set<Person> allSet = new LinkedHashSet();

        allSet.add(new Person("张三", 30));
        allSet.add(new Person("孙七", 33));
        allSet.add(new Person("王五", 32));
        allSet.add(new Person("王五", 32));
        allSet.add(new Person("王五", 32));
        allSet.add(new Person("赵六", 33));
        allSet.add(new Person("李四", 31));

        Iterator allSetIterator = allSet.iterator();
        while (allSetIterator.hasNext()) {
            System.out.println(allSetIterator.next());
        }
    }
}
