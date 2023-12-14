/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.vo.SysIfHist0100SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfHist0100VO;
import com.app.smrmf.sysm.server.vo.SysIfHist0200SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfHist0200VO;
import com.app.smrmf.sysm.server.vo.SysIfHist0300SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfHist0300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0100DAO.java
 * @Description : Sysm0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("LogHistoryServiceDAO")
public class LogHistoryServiceDAO extends EgovAbstractDAO {
  
	//=================== HIST0100
	/**
	 * HIST0100을 저장한다.
	 * @param vo - 삭제할 정보가 담긴 HIST0100VO
	 * @return void형 
	 * @exception Exception
	 */	
	//@Transactional(propagation = Propagation.REQUIRES_NEW) 
	public String insertHist0100(SysIfHist0100VO hist0100VO) throws Exception{
		return (String) insert("LogHistoryServiceDAO.insertHist0100", hist0100VO);
	}
	 
	/**
	 * HIST0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 HIST0100VO
	 * @return void형
	 * @exception Exception
	 */
	//@Transactional(propagation = Propagation.REQUIRES_NEW) 
	public void updateHist0100(SysIfHist0100VO hist0100VO) throws Exception {
		update("LogHistoryServiceDAO.updateHist0100", hist0100VO);
	}
	
	/**
	 * HIST0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 HIST0100VO
	 * @return void형 
	 * @exception Exception
	 */
	//@Transactional(propagation = Propagation.REQUIRES_NEW) 
	public void deleteHist0100(SysIfHist0100VO hist0100VO) throws Exception {
		delete("LogHistoryServiceDAO.deleteHist0100_S", hist0100VO);
	}
	
	/**
	 *  목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return HIST0100 목록
	 * @exception Exception
	 */
    public List selectHist0100List(SysIfHist0100SrhVO hist0100SrhVo) throws Exception {
    	return list("LogHistoryServiceDAO.selectHist0100List", hist0100SrhVo);
    }
    
    
    /**
	 * HIST0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return HIST0100 총 갯수
	 * @exception
	 */
	public int selectHist0100ListTotCnt(SysIfHist0100SrhVO hist0100SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("LogHistoryServiceDAO.selectHist0100ListTotCnt", hist0100SrhVo);
	}  
	//=================== HIST0100
  
	//=================== HIST0200
	/**
	 * HIST0200을 저장한다.
	 * @param vo - 삭제할 정보가 담긴 HIST0200VO
	 * @return void형 
	 * @exception Exception
	 */	
	//@Transactional(propagation = Propagation.REQUIRES_NEW) 
	public String insertHist0200(SysIfHist0200VO hist0200VO) throws Exception{
		return (String) insert("LogHistoryServiceDAO.insertHist0200", hist0200VO);
	}
	 
	/**
	 * HIST0200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 HIST0200VO
	 * @return void형
	 * @exception Exception
	 */
	//@Transactional(propagation = Propagation.REQUIRES_NEW) 
	public void updateHist0200(SysIfHist0200VO hist0200VO) throws Exception {
		update("LogHistoryServiceDAO.updateHist0200", hist0200VO);
	}
	
	/**
	 * HIST0200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 HIST0200VO
	 * @return void형 
	 * @exception Exception
	 */
	//@Transactional(propagation = Propagation.REQUIRES_NEW) 
	public void deleteHist0200(SysIfHist0200VO hist0200VO) throws Exception {
		delete("LogHistoryServiceDAO.deleteHist0200", hist0200VO);
	}
	
	/**
	 *  목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return HIST0200 목록
	 * @exception Exception
	 */
	  public List selectHist0200List(SysIfHist0200SrhVO hist0200SrhVo) throws Exception {
	      return list("LogHistoryServiceDAO.selectHist0200List", hist0200SrhVo);
	  }
  
  	/**
	 * HIST0200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return HIST0200 총 갯수
	 * @exception
	 */
	public int selectHist0200ListTotCnt(SysIfHist0200SrhVO hist0200SrhVo) {
	    return (Integer)getSqlMapClientTemplate().queryForObject("LogHistoryServiceDAO.selectHist0200ListTotCnt", hist0200SrhVo);
	}  
	//=================== HIST0200
	
	
	//=================== HIST0300
	/**
	 * HIST0300을 저장한다.
	 * @param vo - 삭제할 정보가 담긴 HIST0300VO
	 * @return void형 
	 * @exception Exception
	 */	
	//@Transactional(propagation = Propagation.REQUIRES_NEW) 
	public String insertHist0300(SysIfHist0300VO hist0300VO) throws Exception{
		return (String) insert("LogHistoryServiceDAO.insertHist0300", hist0300VO);
	}
	 
	/**
	 * HIST0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 HIST0300VO
	 * @return void형
	 * @exception Exception
	 */
	//@Transactional(propagation = Propagation.REQUIRES_NEW) 
	public void updateHist0300(SysIfHist0300VO hist0300VO) throws Exception {
		update("LogHistoryServiceDAO.updateHist0300", hist0300VO);
	}
	
	/**
	 * HIST0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 HIST0300VO
	 * @return void형 
	 * @exception Exception
	 */
	//@Transactional(propagation = Propagation.REQUIRES_NEW) 
	public void deleteHist0300(SysIfHist0300VO hist0300VO) throws Exception {
		delete("LogHistoryServiceDAO.deleteHist0300", hist0300VO);
	}
	
	/**
	 *  목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return HIST0300 목록
	 * @exception Exception
	 */
	public List selectHist0300List(SysIfHist0300SrhVO hist0300SrhVo) throws Exception {
	      return list("LogHistoryServiceDAO.selectHist0300List", hist0300SrhVo);
	}
  
  	/**
	 * HIST0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return HIST0300 총 갯수
	 * @exception
	 */
	public int selectHist0300ListTotCnt(SysIfHist0300SrhVO hist0300SrhVo) {
	    return (Integer)getSqlMapClientTemplate().queryForObject("LogHistoryServiceDAO.selectHist0300ListTotCnt", hist0300SrhVo);
	}  
	//=================== HIST0300
 
}
