package com.xc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xc.dao.ExampleDao;
import com.xc.domain.Example;
import com.xc.enums.ResultEnum;
import com.xc.exception.ExampleException;

/** 
 * @author xiong
 * @date：2017年10月19日 下午10:17:31 
 * @Description:
 */
@Service
public class ExampleService {
    @Autowired
    private ExampleDao userDao;
    
    @Transactional
    public void insertTwo() {
        Example user = new Example();
        user.setUserName("helloworld");
        user.setPassWord("******");
        userDao.save(user);


        Example userb = new Example();
        userb.setUserName("admin");
        userb.setPassWord("******");
        userDao.save(userb);
    }

    public void getUserName(Integer id) throws Exception{
        Example user = userDao.findOne(id);
        String userName = user.getUserName();
        if ("helloworld".equalsIgnoreCase(userName)) {
            throw new ExampleException(ResultEnum.CHE_DAN);
        }else if ("admin".equalsIgnoreCase(userName)) {
            throw new ExampleException(ResultEnum.DA_YE);
        }
    }
   
    public Example findOne(Integer id) {
        return userDao.findOne(id);
    }
}
