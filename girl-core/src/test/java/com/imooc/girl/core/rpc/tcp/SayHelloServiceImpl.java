package com.imooc.girl.core.rpc.tcp;

/**
 * Created by hmh on 2017/8/25.
 */
public class SayHelloServiceImpl implements SayHelloService {

    @Override
    public String sayHello(String helloArg) {
        if (helloArg.equals("hello"))
            return "hello";
        else
            return "bye bye";
    }

}
