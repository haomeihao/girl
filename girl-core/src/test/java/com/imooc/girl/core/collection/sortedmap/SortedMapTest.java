package com.imooc.girl.core.collection.sortedmap;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by hmh on 2017/8/11.
 */
public class SortedMapTest {
    public static void main(String[] args) {
        SortedMap<String, String> map = new TreeMap();

        map.put("D、jiangker", "http://www.jiangker.com");
        map.put("A、mldn", "http://www.mldn.cn");
        map.put("C、zhinangtuan", "www.zhinangtuan.net.cn");
        map.put("B、mldnjava", "www.mldnjava.com.cn");

        System.out.print("第一个元素的内容的key：" + map.firstKey());
        System.out.println("；对应的值：" + map.get(map.firstKey()));

        System.out.print("最后一个元素的内容的key：" + map.lastKey());
        System.out.println("；对应的值：" + map.get(map.lastKey()));

        System.out.println("返回小于指定范围的集合：");
        for (Map.Entry<String, String> entry : map.headMap("B、mdlnjava").entrySet()) {
            System.out.println("\t|-" + entry.getKey() + "-->" + entry.getValue());
        }

        System.out.println("返回大于指定范围的集合：");
        for (Map.Entry<String, String> entry : map.tailMap("B、mdlnjava").entrySet()) {
            System.out.println("\t|-" + entry.getKey() + "-->" + entry.getValue());
        }

        System.out.println("部分集合：");
        for (Map.Entry<String, String> entry : map.subMap("A、mldn","C、zhinangtuan").entrySet()) {
            System.out.println("\t|-" + entry.getKey() + "-->" + entry.getValue());
        }
    }
}
