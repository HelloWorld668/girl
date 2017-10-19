package com.xc.enums;

/** 
 * @author xiong
 * @date：2017年10月19日 下午10:15:58 
 * @Description:
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    CHE_DAN(100, "你怕是在扯淡"),
    DA_YE(101, "你是大爷"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
