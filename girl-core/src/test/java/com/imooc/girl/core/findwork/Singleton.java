package com.imooc.girl.core.findwork;

/**
 * 双重检查锁的单例模式
 * Created by hmh on 2018/6/27.
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
