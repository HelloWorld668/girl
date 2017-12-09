package com.xc.service;

import org.springframework.stereotype.Service;

import com.xc.ProxyIp.domain.XiCiInlandGaoNiIpPage;

/** 
 * @author xiong
 * @date：2017年10月29日 下午12:34:33 
 * @Description:
 */
@Service
public interface ProxyIPService {
    void saveProxyIPByXiCiInlandGaoNiIpPage(XiCiInlandGaoNiIpPage xiCiInlandGaoNiIpPage);
    
    long countTotalUnknowProxyIp();
}
