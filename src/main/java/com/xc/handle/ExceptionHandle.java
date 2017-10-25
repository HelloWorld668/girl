package com.xc.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xc.domain.Result;
import com.xc.exception.ExampleException;
import com.xc.utils.ResultUtil;

/** 
 * @author xiong
 * @date：2017年10月19日 下午10:15:58 
 * @Description:
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof ExampleException) {
            ExampleException userException = (ExampleException) e;
            return ResultUtil.error(userException.getCode(), userException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
