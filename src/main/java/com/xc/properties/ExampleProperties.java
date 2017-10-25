package com.xc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/** 
 * @author xiong
 * @date：2017年10月19日 下午10:15:58 
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "user")
public class ExampleProperties {

    private String userName;

    private Integer passWord;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the passWord
     */
    public Integer getPassWord() {
        return passWord;
    }

    /**
     * @param passWord the passWord to set
     */
    public void setPassWord(Integer passWord) {
        this.passWord = passWord;
    }

   
}
