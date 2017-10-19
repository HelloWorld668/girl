package com.xc;

import com.xc.domain.User;
import com.xc.service.UserService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findOneTest() {
        User girl = userService.findOne(73);
        Assert.assertEquals(new Integer(13), girl.getId());
    }
}
