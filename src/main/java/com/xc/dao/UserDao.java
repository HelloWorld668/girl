package com.xc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xc.domain.User;

/** 
 * @author xiong
 * @date：2017年10月19日 下午10:15:58 
 * @Description:
 */
public interface UserDao extends JpaRepository<User, Integer>{
    
  //通过年龄来查询
    public List<User> findById(Integer age);

}
