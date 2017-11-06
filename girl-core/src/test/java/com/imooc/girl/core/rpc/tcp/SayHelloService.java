package com.imooc.girl.core.rpc.tcp;

/**
 * Created by hmh on 2017/8/25.
 */
public interface SayHelloService {

    /**
     * 问好的接口
     * @param helloArg
     * @return
     */
    public String sayHello(String helloArg);

}
