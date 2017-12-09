package com.xc.enums;
/** 
 * @author xiong
 * @date：2017年11月22日 下午10:11:51 
 * @Description:
 */
public enum ProxyIpStatusEunm {
    INVALID(-1,"作废"),
    UNKNOW(0,"待检测"),
    USEFUL(1,"可用"),
    ;
   
    
    private Integer code;
    private String message;
    ProxyIpStatusEunm(Integer code, String message) {
        this.message = message;
        this.code = code;
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
