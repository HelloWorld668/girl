package com.xc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
 * @author xiong
 * @date：2017年11月23日 下午10:31:34 
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyIPServiceTest {
    @Autowired
    ProxyIPService proxyIPService;
    
    @Test
    public void test(){
        long countTotalUnknowProxyIp = proxyIPService.countTotalUnknowProxyIp();
        System.out.println(countTotalUnknowProxyIp);
    }
}
