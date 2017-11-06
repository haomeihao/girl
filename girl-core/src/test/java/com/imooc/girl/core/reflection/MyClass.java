package com.imooc.girl.core.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by hmh on 2017/8/9.
 */
public class MyClass {
    public int count;

    public MyClass(int start) {
        this.count = start;
    }

    public void increase(int step) {
        count = count + step;
    }
}
