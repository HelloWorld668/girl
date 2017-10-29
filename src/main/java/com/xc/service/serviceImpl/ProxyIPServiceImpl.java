package com.xc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xc.ProxyIp.domain.XiCiInlandGaoNiIpPage;
import com.xc.dao.ProxyIPDao;
import com.xc.domain.ProxyIp;
import com.xc.service.ProxyIPService;

/** 
 * @author xiong
 * @date：2017年10月29日 下午12:36:56 
 * @Description:
 */
@Component
public class ProxyIPServiceImpl implements ProxyIPService{
    
    @Autowired 
    private ProxyIPDao proxyIPDao;
    @Override
    public void saveProxyIPByXiCiInlandGaoNiIpPage(
            XiCiInlandGaoNiIpPage xiCiInlandGaoNiIpPage) {
        List<ProxyIp> list = xiCiInlandGaoNiIpPage.getList();
        proxyIPDao.save(list);
    }

}
