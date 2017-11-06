package com.imooc.girl.core.collection.hashmap;

import java.util.*;

/**
 * Created by hmh on 2017/8/11.
 */
public class IdentityHashMapTest {
    public static void main(String[] args) {
        Map<Person, String> map = new IdentityHashMap();

        map.put(new Person("张三", 30), "zhangsan_1");
        map.put(new Person("张三", 30), "zhangsan_2");
        map.put(new Person("李四", 21), "lisi");

        Set<Map.Entry<Person, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Person, String>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Person, String> entry = entryIterator.next();
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
