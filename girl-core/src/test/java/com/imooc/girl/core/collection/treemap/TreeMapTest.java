package com.imooc.girl.core.collection.treemap;

import java.util.*;

/**
 * Created by hmh on 2017/8/11.
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();

        map.put("A、mldn", "www.mldn.cn");
        map.put("C、zhinangtuan", "www.zhinangtuan.net.cn");
        map.put("B、mldnjava", "www.mldnjava.com.cn");

        Set<String> keySet = map.keySet();
        Iterator<String> iteratorKey = keySet.iterator();
//        System.out.print("全部的key：");
        while (iteratorKey.hasNext()) {
            String str = iteratorKey.next();
            System.out.println(str + "-->" + map.get(str));
        }

//        System.out.println();
//
//        Collection<String> values = map.values();
//        Iterator<String> iteratorValues =  values.iterator();
//        System.out.print("全部的value：");
//        while (iteratorValues.hasNext()) {
//            String str = iteratorValues.next();
//            System.out.print(str + "、");
//        }
    }
}
