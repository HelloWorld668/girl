package com.xc.exception;

import com.xc.enums.ResultEnum;


/** 
 * @author xiong
 * @date：2017年10月19日 下午10:15:58 
 * @Description:
 */
public class ExampleException extends RuntimeException{

    /**
     * 
     */
    private static final long serialVersionUID = -4856090059324466527L;
    private Integer code;

    public ExampleException(ResultEnum resultEnum) {
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
