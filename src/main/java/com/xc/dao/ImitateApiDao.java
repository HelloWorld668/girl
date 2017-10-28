package com.xc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xc.domain.ImitateApi;

/** 
 * @author xiong
 * @date：2017年10月28日 上午10:46:34 
 * @Description:
 */
public interface ImitateApiDao extends JpaRepository<ImitateApi, Integer>{
  //通过年龄来查询
    public List<ImitateApi> findById(Integer age);
}
