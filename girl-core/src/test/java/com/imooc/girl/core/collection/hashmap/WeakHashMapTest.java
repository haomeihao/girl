package com.imooc.girl.core.collection.hashmap;


import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by hmh on 2017/8/11.
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new WeakHashMap<String, String>();

        map.put(new String("mldn"), new String("www.mldn.cn"));
        map.put("zhinangtuan", "www.zhinangtuan.net.cn");
        map.put("mldnjava", "www.mldnjava.com.cn");

        System.gc(); //进行垃圾收集
        map.put("lxh", "lingxinghua");
        System.out.println("内容：" + map);
    }
}
