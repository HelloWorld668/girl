package com.xc.ProxyIp.parserImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.mysql.jdbc.StringUtils;
import com.xc.ProxyIp.domain.XiCiInlandGaoNiIpPage;
import com.xc.ProxyIp.parser.XiCiInlandGaoNiIpPaser;
import com.xc.domain.ProxyIp;
import com.xc.enums.ProxyIpStatusEunm;
import com.xc.enums.SpiderEnum;
import com.xc.exception.SpiderException;
import com.xc.job.ProxyIpJob;
import com.xc.utils.HttpClientUtils;

/** 
 * @author xiong
 * @date：2017年10月29日 上午10:32:39 
 * @Description:
 */
@Component
public class XiCiInlandGaoNiIpPaserImpl implements XiCiInlandGaoNiIpPaser{
    
    private static String URL_PREFIX = "http://www.xicidaili.com/nn/";
    private final static Logger logger = LoggerFactory.getLogger(XiCiInlandGaoNiIpPaserImpl.class);
    
    @Override
    public XiCiInlandGaoNiIpPage parserPage(Integer pageNo) throws ClientProtocolException, IOException {
        XiCiInlandGaoNiIpPage xiCiInlandGaoNiIpPage = new XiCiInlandGaoNiIpPage();
        //String pageStr = HttpClientUtils.getWithProxy(url,"51.15.195.177",3128,"http");
        String pageStr = HttpClientUtils.get(URL_PREFIX+pageNo);
        logger.info("spider task:"+URL_PREFIX+pageNo);
        if(StringUtils.isNullOrEmpty(pageStr)){
            throw new SpiderException(SpiderEnum.RESULT_NULL);
        }
        
        Document pageDom = Jsoup.parse(pageStr);
        xiCiInlandGaoNiIpPage.setTotalPage(getTotalPage(pageDom));
        
        List<ProxyIp> list = getProxIpList(pageDom);
        xiCiInlandGaoNiIpPage.setList(list );
        
        return xiCiInlandGaoNiIpPage;
    }
    private List<ProxyIp> getProxIpList(Document pageDom) {
        List<ProxyIp> res = new ArrayList<ProxyIp>();
        ProxyIp proxyIP;
        
        Element table = pageDom.getElementById("ip_list");
        Element tbody = table.child(0);
        Elements trs = tbody.children();
        trs.remove(0);
        for (Element tr : trs) {
            proxyIP = new ProxyIp();
            
            proxyIP.setStatus(ProxyIpStatusEunm.UNKNOW.getCode());
            proxyIP.setCheckTimes(0);
            
            Elements tds = tr.children();
            
            Elements td1Child = tds.get(0).children();
            if(null != td1Child && td1Child.size()>0){
                String country = td1Child.get(0).attr("alt");
                proxyIP.setCountry(country);
            }
            
            Element ipAddressElement = tds.get(1);
            proxyIP.setIpAddress(ipAddressElement.text());
            
            Element portElement = tds.get(2);
            proxyIP.setPort(portElement.text());
            
            Element serverAddressElement = tds.get(3);
            proxyIP.setServerAddress(serverAddressElement.text());
            
            Element gaoniElement = tds.get(4);
            proxyIP.setGaoni("高匿".equalsIgnoreCase(gaoniElement.text()));
            
            Element typeElement = tds.get(5);
            proxyIP.setType(typeElement.text());
            
            Element speedElement = tds.get(6).child(0);
            proxyIP.setSpeed(speedElement.attr("title"));
            
            Element connectionTimeElement = tds.get(7).child(0);;
            proxyIP.setConnectionTime(connectionTimeElement.attr("title"));
            
            Element aliveDaysElement = tds.get(8);
            proxyIP.setAliveDays(aliveDaysElement.text());
            
            Element verifyMinutesElement = tds.get(9);
            proxyIP.setVerifyMinutes(verifyMinutesElement.text());
            
            res.add(proxyIP);
        }
        return res;
    }
    private Integer getTotalPage(Document pageDom) {
        Integer res = 0;
        try {
            Elements pageNoElements = pageDom.getElementsByClass("pagination");
            if(CollectionUtils.isEmpty(pageNoElements)){
                throw new SpiderException(SpiderEnum.PARSE_ERROR);
            }
            Element pageNoElement = pageNoElements.get(pageNoElements.size()-1);
            Elements pageNoElementChildren = pageNoElement.children();
            Element childNode = pageNoElementChildren.get(pageNoElementChildren.size()-2);
            String text = childNode.text();
            res = Integer.parseInt(text);
        } catch (Exception e) {
            throw new SpiderException(SpiderEnum.PARSE_ERROR,e);
        }
        return res;
    }
}
