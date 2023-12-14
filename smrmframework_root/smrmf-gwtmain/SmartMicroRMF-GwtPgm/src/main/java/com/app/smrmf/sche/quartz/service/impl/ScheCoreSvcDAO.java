package com.app.smrmf.sche.quartz.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("ScheCoreSvcDAO") 
public class ScheCoreSvcDAO extends EgovAbstractDAO {
	 
	  public SmrmfScheVO  sysScheHealthCheck() throws Exception {
		  return (SmrmfScheVO)getSqlMapClientTemplate().queryForObject("scheCoreSvcDao.sysScheHealthCheck_S", null);
	    }
	 
	    
}
