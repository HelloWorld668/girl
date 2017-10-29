package com.xc.job;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
 * @author xiong
 * @date：2017年10月29日 下午12:41:20 
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyIpJobTest {
    @Autowired
    ProxyIpJob proxyIpJob;
    
    @Test
    public void test() throws ClientProtocolException, IOException{
        proxyIpJob.run();
    }
}
