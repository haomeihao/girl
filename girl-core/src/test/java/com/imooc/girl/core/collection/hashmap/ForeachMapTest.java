package com.imooc.girl.core.collection.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hmh on 2017/8/11.
 */
public class ForeachMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("mldn", "www.mldn.cn");
        map.put("zhinangtuan", "www.zhinangtuan.net.cn");
        map.put("mldnjava", "www.mldnjava.com.cn");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
