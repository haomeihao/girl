package com.imooc.girl.core.rpc.httprpc;

/**
 * Created by hmh on 2017/8/28.
 */
public class JsonResultUtil {

    public static JsonResult success(Object object) {
        JsonResult result = new JsonResult();
        result.setResultCode(200);
        result.setMessage("success");
        result.setResult(object);
        return result;
    }

    public static JsonResult success() {
        return success(null);
    }

    public static JsonResult error(Integer code, String msg) {
        JsonResult result = new JsonResult();
        result.setResultCode(code);
        result.setMessage(msg);
        return result;
    }
}
