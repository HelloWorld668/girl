package com.xc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xc.service.ImitateApiService;

/** 
 * @author xiong
 * @date：2017年10月28日 上午10:52:42 
 * @Description:
 */
@RestController
public class ImitateApiController {
    private final static Logger logger = LoggerFactory.getLogger(ImitateApiController.class);
    
    @Autowired
    private ImitateApiService imitateApiService;
    
    @GetMapping(value = "/findOneimitate/{id}")
    public String userFindOne(@PathVariable("id") Integer id) throws Exception {
        return imitateApiService.findOne(id).getContent();
    }
    
}
