package com.xc.service;

import java.util.concurrent.DelayQueue;

import com.xc.model.Proxy;

/** 
 * @author xiong
 * @date：2017年12月9日 下午3:40:22 
 * @Description:
 */
public interface ProxyService {
    DelayQueue<Proxy> getZhiHuProxyIp();
}
