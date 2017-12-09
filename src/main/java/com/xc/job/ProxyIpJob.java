package com.xc.job;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xc.ProxyIp.domain.XiCiInlandGaoNiIpPage;
import com.xc.ProxyIp.parser.XiCiInlandGaoNiIpPaser;
import com.xc.controller.ExampleController;
import com.xc.service.JobSequenceService;
import com.xc.service.ProxyIPService;

/** 
 * @author xiong
 * @date：2017年10月29日 下午12:28:09 
 * @Description:
 */
@Component
public class ProxyIpJob {
    
    private final static Logger logger = LoggerFactory.getLogger(ProxyIpJob.class);
    
    @Autowired
    XiCiInlandGaoNiIpPaser xiCiInlandGaoNiIpPaser;
    @Autowired
    ProxyIPService proxyIPService;
    @Autowired
    JobSequenceService jobSequenceService;
    
    static long maxUnkonwIp = 1000L;
    
    public void run() {
        while(true){
            try {
                doJob();
            } catch (Exception e) {
                logger.error("更新代理ip库异常",e);
            } 
        }
    }

    private void doJob() throws ClientProtocolException, IOException, InterruptedException{
        Integer start = jobSequenceService.getStart(this.getClass().getName());
        
        XiCiInlandGaoNiIpPage xiCiInlandGaoNiIpPage = xiCiInlandGaoNiIpPaser.parserPage(start++);
        jobSequenceService.saveOrUpdate(this.getClass().getName(), start);
        proxyIPService.saveProxyIPByXiCiInlandGaoNiIpPage(xiCiInlandGaoNiIpPage);
        
        Integer totalPage = xiCiInlandGaoNiIpPage.getTotalPage();
        if(start >= totalPage){
            jobSequenceService.saveOrUpdate(this.getClass().getName(), 1);
        }
        
        for (int i = start+1; i < totalPage; i++) {
            long unknowProxyIpNum = proxyIPService.countTotalUnknowProxyIp();
            if(unknowProxyIpNum > maxUnkonwIp){
                int s = (int) (Math.random()*100);
                logger.info("库存待检测ip超过"+maxUnkonwIp+"   "+s+"秒后继续爬去");
                Thread.sleep(s*1000);
                break;
            }
            xiCiInlandGaoNiIpPage = xiCiInlandGaoNiIpPaser.parserPage(i);
            proxyIPService.saveProxyIPByXiCiInlandGaoNiIpPage(xiCiInlandGaoNiIpPage);
            jobSequenceService.saveOrUpdate(this.getClass().getName(), i+1);
        }
    }
}
