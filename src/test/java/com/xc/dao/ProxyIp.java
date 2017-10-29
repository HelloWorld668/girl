package com.xc.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
 * @author xiong
 * @date：2017年10月29日 下午4:46:44 
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyIp {
    @Autowired ProxyIPDao proxyIPDao;
    public void test(){
        ProxyIp ip = new ProxyIp();
    }
}
