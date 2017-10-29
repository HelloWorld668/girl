package com.xc.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author xiong
 * @date：2017年10月25日 下午10:38:19
 * @Description:
 */
public class HttpClientUtils {

    public static String get(String url) throws ClientProtocolException,
            IOException {
        String responseBody;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            addHeader(httpget);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity)
                                : null;
                    } else {
                        throw new ClientProtocolException(url
                                + ":Unexpected response status: " + status);
                    }
                }

            };
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        return responseBody;
    }
    public static String getWithProxy(String url,String ipAddress,Integer port,String type) throws ClientProtocolException, IOException{

        String responseBody;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpHost proxy = new HttpHost(ipAddress, port, type);
            RequestConfig config = RequestConfig.custom().setProxy(proxy)
                    .build();
            
            HttpGet httpget = new HttpGet(url);
            httpget.setConfig(config);
            
            addHeader(httpget);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity)
                                : null;
                    } else {
                        throw new ClientProtocolException(url
                                + ":Unexpected response status: " + status);
                    }
                }

            };
            responseBody = httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
        return responseBody;
    
    }
    private static void addHeader(HttpGet httpget) {
        // httpget.addHeader("Accept",
        // "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        // httpget.addHeader("Accept-Encoding","gzip, deflate");
        // httpget.addHeader("Accept-Language","zh-CN,zh;q=0.8");
        // httpget.addHeader("Cache-Control","max-age=0");
        // httpget.addHeader("Connection","keep-alive");
        httpget.addHeader(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
        // httpget.addHeader("Host","www.xicidaili.com");
        // httpget.addHeader("Upgrade-Insecure-Requests","1");
    }

    public static void main(String[] args) throws Exception {
        String withProxy = getWithProxy("http://www.xicidaili.com/nn/153","51.15.195.177",3128,"http");
        System.out.println(withProxy);
    }
}
