package com.imooc.girl.core.collection.hashmap;

import java.util.*;

/**
 * Created by hmh on 2017/8/11.
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> table = new Hashtable<String, String>();

        map.put("mldn", "www.mldn.cn");
        map.put("zhinangtuan", "www.zhinangtuan.net.cn");
        map.put("mldnjava", "www.mldnjava.com.cn");

        Set<String> keySet = map.keySet();
        Iterator<String> iteratorKey = keySet.iterator();
        System.out.print("全部的key：");
        while (iteratorKey.hasNext()) {
            String str = iteratorKey.next();
            System.out.print(str + "、");
        }

        System.out.println();

        Collection<String> values = map.values();
        Iterator<String> iteratorValues =  values.iterator();
        System.out.print("全部的value：");
        while (iteratorValues.hasNext()) {
            String str = iteratorValues.next();
            System.out.print(str + "、");
        }
    }
}
