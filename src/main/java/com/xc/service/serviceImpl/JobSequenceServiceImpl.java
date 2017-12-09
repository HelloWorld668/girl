package com.xc.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xc.dao.JobSequenceDao;
import com.xc.domain.JobSequence;
import com.xc.service.JobSequenceService;

/** 
 * @author xiong
 * @date：2017年11月23日 下午9:25:24 
 * @Description:
 */
@Component
public class JobSequenceServiceImpl implements JobSequenceService {
    
    @Autowired
    JobSequenceDao jobSequenceDao;
    
    @Override
    public void saveOrUpdate(String jobName,Integer start) {
        JobSequence jobSequence = jobSequenceDao.findOne(jobName);
        if(null == jobSequence){
            jobSequence = new JobSequence();
            jobSequence.setJobName(jobName);
            jobSequence.setStart(start);
            jobSequenceDao.save(jobSequence);
        }else{
            jobSequence.setStart(start);
            jobSequence.setJobName(jobName);
            jobSequenceDao.saveAndFlush(jobSequence);
        }
    }

    @Override
    public Integer getStart(String jobName) {
        JobSequence jobSequence = jobSequenceDao.findOne(jobName);
        return jobSequence == null?2:jobSequence.getStart();
    }

}
