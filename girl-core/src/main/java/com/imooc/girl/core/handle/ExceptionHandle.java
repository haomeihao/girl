package com.imooc.girl.core.handle;

import com.imooc.girl.core.domain.Result;
import com.imooc.girl.core.exception.GirlException;
import com.imooc.girl.core.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hmh on 2017/8/1.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException)e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            log.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
