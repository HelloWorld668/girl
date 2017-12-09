package com.xc.service.serviceImpl;

import java.util.concurrent.DelayQueue;

import com.xc.model.Proxy;
import com.xc.service.ProxyService;

/** 
 * @author xiong
 * @date：2017年12月9日 下午3:44:03 
 * @Description:
 */
public class ProxyServiceImpl implements ProxyService{
    
    public final static DelayQueue<Proxy> proxyQueue = new DelayQueue();
    
    @Override
    public DelayQueue<Proxy> getZhiHuProxyIp() {
        
        return getProxyByCondition();
    }

}
