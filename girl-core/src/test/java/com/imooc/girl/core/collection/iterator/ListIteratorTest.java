package com.imooc.girl.core.collection.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by hmh on 2017/8/11.
 */
public class ListIteratorTest {
    public static void main(String[] args) {
        List<String> all = new ArrayList<String>();
        all.add("Hello");
        all.add("_");
        all.add("World");

        ListIterator<String> listIterator =  all.listIterator();

        System.out.print("由前向后输出：");
        while (listIterator.hasNext()) {
            String str = listIterator.next();
        }

        System.out.print("\n由后向前输出：");
        while (listIterator.hasPrevious()) {
            String str = listIterator.previous();
            System.out.print(str + "、");
        }

        System.out.print("\n由前向后输出：");
        while (listIterator.hasNext()) {
            String str = listIterator.next();
            System.out.print(str + "、");
        }

        System.out.println();
    }
}
