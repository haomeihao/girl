package com.imooc.girl.core.findwork;

/**
 * Created by hmh on 2018/6/27.
 */
public class SynchronizeTest {

    public static void main(String[] args) {

        synchronized (SynchronizeTest.class) {
            System.out.println("Synchronize");
        }

    }
}
