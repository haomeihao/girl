package com.imooc.girl.core.exception;

import com.imooc.girl.core.enums.ResultEnum;

/**
 * Created by hmh on 2017/8/1.
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
