package com.xc.ProxyIp.parser;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Component;

import com.xc.ProxyIp.domain.XiCiInlandGaoNiIpPage;

/** 
 * @author xiong
 * @date：2017年10月28日 下午8:44:13 
 * @Description:
 */
@Component
public interface XiCiInlandGaoNiIpPaser {
    XiCiInlandGaoNiIpPage parserPage(String url) throws ClientProtocolException, IOException ;
}
