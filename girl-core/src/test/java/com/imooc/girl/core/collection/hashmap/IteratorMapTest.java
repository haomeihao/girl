package com.imooc.girl.core.collection.hashmap;

import java.util.*;

/**
 * Created by hmh on 2017/8/11.
 */
public class IteratorMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<String, String>();

        map.put("mldn", "www.mldn.cn");
        map.put("zhinangtuan", "www.zhinangtuan.net.cn");
        map.put("mldnjava", "www.mldnjava.com.cn");
        map.put("zhinangtuan1", "www.zhinangtuan.net.cn");
        map.put("zhinangtuan2", "www.zhinangtuan.net.cn");

        Set<Map.Entry<String, String>> entrySet =  map.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
