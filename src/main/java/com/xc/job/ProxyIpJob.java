package com.xc.job;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xc.ProxyIp.domain.XiCiInlandGaoNiIpPage;
import com.xc.ProxyIp.parser.XiCiInlandGaoNiIpPaser;
import com.xc.service.ProxyIPService;

/** 
 * @author xiong
 * @date：2017年10月29日 下午12:28:09 
 * @Description:
 */
@Component
public class ProxyIpJob {
    private static String URL_PREFIX = "http://www.xicidaili.com/nn/";
    private static Integer FIREST_PAGE_NO = 153; 
    
    @Autowired
    XiCiInlandGaoNiIpPaser xiCiInlandGaoNiIpPaser;
    @Autowired
    ProxyIPService proxyIPService;
    
    
    public void run() throws ClientProtocolException, IOException{
        XiCiInlandGaoNiIpPage xiCiInlandGaoNiIpPage = xiCiInlandGaoNiIpPaser.parserPage(URL_PREFIX+FIREST_PAGE_NO);
        proxyIPService.saveProxyIPByXiCiInlandGaoNiIpPage(xiCiInlandGaoNiIpPage);
        
        Integer totalPage = xiCiInlandGaoNiIpPage.getTotalPage();
        for (int i = FIREST_PAGE_NO+1; i < totalPage; i++) {
            xiCiInlandGaoNiIpPage = xiCiInlandGaoNiIpPaser.parserPage(URL_PREFIX+i);
            proxyIPService.saveProxyIPByXiCiInlandGaoNiIpPage(xiCiInlandGaoNiIpPage);
        }
    }
}
