package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfHist0300SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : sysmIfHist0300DAO.java
 * @Description : sysmIfHist0300DAO DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("MSFSysHist0300DAO")
public class MSFSysHist0300DAO extends EgovAbstractDAO   {
	
	
	/**
	 *  시간 목록을 가져온다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return STTS0100 목록
	 * @exception Exception
	 */
	public List getHourList() throws Exception {
		return list("msfHist0300DAO.getHour", null);
	}
	
	/**
	 *  분 목록을 가져온다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return STTS0100 목록
	 * @exception Exception
	 */
	public List getMinuteList() throws Exception {
		return list("msfHist0300DAO.getMinute", null);
	}
	
	/**
	 *  목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return STTS0300 목록
	 * @exception Exception
	 */
    public List selectHist0300List(SysIfHist0300SrhVO hist0300SrhVo) throws Exception {
        return list("msfHist0300DAO.selectHist0300List_D", hist0300SrhVo);
    }
    
    

    /**
  	 * HIST0300 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return HIST0300 총 갯수
  	 * @exception
  	 */
    public int selectHistP030002ToHist0300ListTotCnt(SysIfHist0300SrhVO hist0300SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("msfHist0300DAO.selectHistP030002ToHist0300ListTotCnt_S", hist0300SrhVo);
    }  
      
  	/**
  	 *  목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return STTS0300 목록
  	 * @exception Exception
  	 */
    @SuppressWarnings("unchecked")
  	public List selectHistP030002ToHist0300List(SysIfHist0300SrhVO hist0300SrhVo) throws Exception {
        return (List) list("msfHist0300DAO.selectHistP030002ToHist0300List_D", hist0300SrhVo);
    }
    
  /**
	 * HIST0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return HIST0300 총 갯수
	 * @exception
	 */
  public int selectHist0300ListTotCnt(SysIfHist0300SrhVO hist0300SrhVo) {
      return (Integer)getSqlMapClientTemplate().queryForObject("msfHist0300DAO.selectHist0300ListTotCnt_S", hist0300SrhVo);
  }  
  
     
   /**
	 * HIST0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 HIST0300VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteHist0300(SysIfHist0300SrhVO hist0300SrhVo) throws Exception {
         delete("msfHist0300DAO.deleteHist0300_S", hist0300SrhVo);
    }


}
