package com.xc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xc.dao.ImitateApiDao;
import com.xc.domain.ImitateApi;


/** 
 * @author xiong
 * @date：2017年10月28日 上午10:46:57 
 * @Description:
 */
@Service
public class ImitateApiService {
    @Autowired
    ImitateApiDao imitateApiDao;
    
    public ImitateApi findOne(Integer id) throws Exception{
       return imitateApiDao.findOne(id);
    }
}
