package com.xc.enums;
/** 
 * @author xiong
 * @date：2017年10月29日 上午11:05:33 
 * @Description:
 */
public enum SpiderEnum {
    
    UNKONW_ERROR(-1, "未知错误"),
    RESULT_NULL(0, "解析网页获取的结果为空"),
    PARSE_ERROR(1,"解析节点出错 ")
    ;
    private Integer code;

    private String msg;
    private SpiderEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
