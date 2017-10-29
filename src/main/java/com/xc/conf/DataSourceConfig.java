package com.xc.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

/** 
 * @author xiong
 * @date：2017年10月28日 下午4:43:11 
 * @Description:
 */
@Profile("dev")
@ConfigurationProperties(prefix = "datasource",locations = "${user.home}/girl-datasorce.properties")
public class DataSourceConfig {
    private String name;  
    private String gender;  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public String getGender() {  
        return gender;  
    }  
    public void setGender(String gender) {  
        this.gender = gender;  
    }  
}
