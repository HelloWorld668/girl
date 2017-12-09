package com.xc.controller;

import java.util.concurrent.DelayQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xc.model.Proxy;
import com.xc.service.ProxyService;


/** 
 * @author xiong
 * @date：2017年12月9日 下午3:34:30 
 * @Description:
 */
@Controller
public class ProxyIpController {
    
    @Autowired
    ProxyService proxyService;
    
    @ResponseBody
    @GetMapping(value="/getZhiHuProxyIp")
    public DelayQueue<Proxy> getProxyIp(){
        return proxyService.getZhiHuProxyIp();
    }
}
