package com.xc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xc.domain.JobSequence;

/** 
 * @author xiong
 * @date：2017年11月23日 下午9:24:23 
 * @Description:
 */
public interface JobSequenceDao extends JpaRepository<JobSequence, String>{

}
