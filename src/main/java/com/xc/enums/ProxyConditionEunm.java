package com.xc.enums;
/** 
 * @author xiong
 * @date：2017年12月9日 下午3:51:36 
 * @Description:
 */
public enum ProxyConditionEunm {
    ZHIHU("","")
    ;
    private String url;
    private String content;
    private ProxyConditionEunm(String url,String content) {
        this.url = url;
        this.content = content;
    }
}
