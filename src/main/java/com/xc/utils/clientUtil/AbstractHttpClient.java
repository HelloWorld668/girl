package com.xc.utils.clientUtil;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
 * @author xiong
 * @date：2017年12月11日 下午9:35:58 
 * @Description:
 */
public abstract class AbstractHttpClient {
    private Logger logger = LoggerFactory.getLogger(AbstractHttpClient.class);
    public InputStream getWebPageInputStream(String url){
        try {
            CloseableHttpResponse response = HttpClientUtil.getResponse(url);
            return response.getEntity().getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
