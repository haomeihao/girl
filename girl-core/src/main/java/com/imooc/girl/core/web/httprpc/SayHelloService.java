package com.imooc.girl.core.web.httprpc;

import java.util.Map;

/**
 * Created by hmh on 2017/8/28.
 */
public class SayHelloService implements BaseService {
    @Override
    public Object execute(Map<String, Object> args) {

        String[] helloArg = (String[]) args.get("arg1");

        if ("hello".equals(helloArg[0]))
            return "hello";
        else
            return "bye bye";
    }
}
