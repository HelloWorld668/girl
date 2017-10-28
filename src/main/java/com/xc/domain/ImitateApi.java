package com.xc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

/** 
 * @author xiong
 * @date：2017年10月28日 上午10:44:28 
 * @Description:
 */
@Entity
public class ImitateApi {
    @Id
    @GeneratedValue
    private Integer id;
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
     * @return the content
     */
    public String getContent() {
        return content;
    }
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    @Length(min=6, max=99999)
    private String content;
}
