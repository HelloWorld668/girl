package com.xc.exception;

import com.xc.enums.SpiderEnum;

/** 
 * @author xiong
 * @date：2017年10月29日 上午11:04:14 
 * @Description:
 */
public class SpiderException extends RuntimeException{
    /**
     * 
     */
    private static final long serialVersionUID = 5238030425325868777L;
    private Integer code;
    private String message;
    
    public SpiderException(SpiderEnum spiderEnum) {
        super(spiderEnum.getMsg());
        this.code = spiderEnum.getCode();
    }
    
    public SpiderException(SpiderEnum spiderEnum,Exception e) {
        super(new StringBuffer(spiderEnum.getMsg()).append(e.getMessage()).toString());
        this.code = spiderEnum.getCode();
    }
    
    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
