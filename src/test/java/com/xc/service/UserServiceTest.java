package com.xc.service;

import com.xc.domain.Example;
import com.xc.service.ExampleService;

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
    private ExampleService userService;

    @Test
    public void findOneTest() {
        Example girl = userService.findOne(73);
        Assert.assertEquals(new Integer(13), girl.getId());
    }
}
