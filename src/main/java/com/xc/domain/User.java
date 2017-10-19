package com.xc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/** 
 * @author xiong
 * @date：2017年10月19日 下午10:07:22 
 * @Description:
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotNull(message = "用户名必须填写")
    //@Length(min=6, max=24)
    private String userName;
    
    @NotNull(message = "密码必须填写")
    //@Length(min=6, max=24)
    private String passWord;
    
    public User() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord the passWord to set
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
}
