package com.xc.service;

import org.springframework.stereotype.Service;


/** 
 * @author xiong
 * @date：2017年11月23日 下午9:24:47 
 * @Description:
 */
@Service
public interface JobSequenceService {
    void saveOrUpdate(String jobName,Integer start);
    
    Integer getStart(String jobName);
}
