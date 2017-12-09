package com.xc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xc.job.ProxyIpJob;

/** 
 * @author xiong
 * @date：2017年11月23日 下午9:40:27 
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JobSequenceServiceTest {
    @Autowired
    JobSequenceService jobSequenceService;
    
    @Test
    public void test(){
        jobSequenceService.saveOrUpdate(ProxyIpJob.class.getName(), 2);
    }
}
