package com.imooc.girl.core.web.httprpc;

import java.util.Map;

/**
 * Created by hmh on 2017/8/28.
 */
public interface BaseService {
    public Object execute(Map<String, Object> args);
}
