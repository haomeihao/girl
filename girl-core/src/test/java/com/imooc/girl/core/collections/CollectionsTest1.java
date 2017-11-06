package com.imooc.girl.core.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hmh on 2017/8/11.
 */
public class CollectionsTest1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();

        Collections.addAll(list, "MLDN","LXH","mldnjava");
//        Collections.reverse(list);

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "、");
        }

//        int point = Collections.binarySearch(list, "LXH");
//        System.out.println("\n检索结果：" + point);
//
//        point = Collections.binarySearch(list, "LI");
//        System.out.println("检索结果：" + point);

        if (Collections.replaceAll(list, "LXH","李兴华")) {
            System.out.println("\n内容替换成功");
        }
        System.out.print("替换之后的结果：");
        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + "、");
        }
    }
}
