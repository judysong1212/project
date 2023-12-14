package com.app.smrmf.sche.quartz.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.sche.quartz.service.ScheCoreSvcService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("ScheCoreSvcService") 
public class ScheCoreSvcServiceImpl extends AbstractServiceImpl implements  ScheCoreSvcService {

	
	@Autowired
    @Resource(name="ScheCoreSvcDAO")
    private ScheCoreSvcDAO scheCoreSvcDao;
	
	public  SmrmfScheVO sysScheHealthCheck() throws Exception  {
		 
		 return scheCoreSvcDao.sysScheHealthCheck();
		 
	 } 
	   
}
