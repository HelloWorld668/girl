package com.xc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xc.dao.UserDao;
import com.xc.domain.User;
import com.xc.enums.ResultEnum;
import com.xc.exception.UserException;

/** 
 * @author xiong
 * @date：2017年10月19日 下午10:17:31 
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    
    @Transactional
    public void insertTwo() {
        User user = new User();
        user.setUserName("helloworld");
        user.setPassWord("******");
        userDao.save(user);


        User userb = new User();
        userb.setUserName("admin");
        userb.setPassWord("******");
        userDao.save(userb);
    }

    public void getUserName(Integer id) throws Exception{
        User user = userDao.findOne(id);
        String userName = user.getUserName();
        if ("helloworld".equalsIgnoreCase(userName)) {
            throw new UserException(ResultEnum.CHE_DAN);
        }else if ("admin".equalsIgnoreCase(userName)) {
            throw new UserException(ResultEnum.DA_YE);
        }
    }
   
    public User findOne(Integer id) {
        return userDao.findOne(id);
    }
}
