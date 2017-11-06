package com.imooc.girl.core.websocket;

/**
 * Created by hmh on 2017/8/2.
 */
public class HelloMessage {

    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
