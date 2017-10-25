package com.xc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.xc.dao.ExampleDao;
import com.xc.domain.Example;
import com.xc.domain.Result;
import com.xc.service.ExampleService;
import com.xc.utils.ResultUtil;

import javax.validation.Valid;

import java.util.List;

/*
 * 
 * 
 */
@RestController
public class ExampleController {
    /** 
     * @author xiong
     * @date：2017年10月19日 下午10:15:58 
     * @Description:
     */
    private final static Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @Autowired
    private ExampleDao userDao;

    @Autowired
    private ExampleService userService;

    @GetMapping(value = "/users")
    public List<Example> userList() {
        logger.info("userList");

        return userDao.findAll();
    }

    @PostMapping(value = "/users")
    public Result<Example> userAdd(@Valid Example user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        user.setPassWord(user.getPassWord());
        user.setUserName(user.getUserName());

        return ResultUtil.success(userDao.save(user));
    }

    @GetMapping(value = "/users/{id}")
    public Example userFindOne(@PathVariable("id") Integer id) {
        return userDao.findOne(id);
    }

    @PutMapping(value = "/user/{id}")
    public Example userUpdate(@PathVariable("id") Integer id,
                           @RequestParam("passWord") String passWord,
                           @RequestParam("userName") String userName) {
        Example user = new Example();
        user.setId(id);
        user.setUserName(userName);
        user.setPassWord(passWord);

        return userDao.save(user);
    }

    @DeleteMapping(value = "/user/{id}")
    public void userDelete(@PathVariable("id") Integer id) {
        userDao.delete(id);
    }

    @GetMapping(value = "/users/age/{id}")
    public List<Example> userListByAge(@PathVariable("id") Integer id) {
        return userDao.findById(id);
    }

    @PostMapping(value = "/users/two")
    public void userTwo() {
        userService.insertTwo();
    }

    @GetMapping(value = "/users/getUserName/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        userService.getUserName(id);
    }
}
