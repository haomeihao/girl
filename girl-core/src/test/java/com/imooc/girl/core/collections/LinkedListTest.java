package com.imooc.girl.core.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hmh on 2017/8/11.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List list =  Collections.synchronizedList(new LinkedList());//线程安全LinkedList
    }
}
