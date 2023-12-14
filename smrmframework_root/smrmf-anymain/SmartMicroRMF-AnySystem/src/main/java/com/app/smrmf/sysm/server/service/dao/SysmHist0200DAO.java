package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfHist0200SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : sysmHist0200DAO.java
 * @Description : sysmHist0200DAO DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysmHist0200DAO")
public class SysmHist0200DAO extends EgovAbstractDAO   {
	
	/**
	 *  시간 목록을 가져온다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return STTS0100 목록
	 * @exception Exception
	 */
	public List getHourList() throws Exception {
		return list("sysmHist0200DAO.getHour", null);
	}
	
	/**
	 *  분 목록을 가져온다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return STTS0100 목록
	 * @exception Exception
	 */
	public List getMinuteList() throws Exception {
		return list("sysmHist0200DAO.getMinute", null);
	}
	
	/**
	 *  목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return HIST0200 목록
	 * @exception Exception
	 */
    public List selectHist0200List(SysIfHist0200SrhVO hist0200SrhVo) throws Exception {
        return list("sysmHist0200DAO.selectHist0200List_D", hist0200SrhVo);
    }
    

    public List selectHist0200ExlList(SysIfHist0200SrhVO hist0200SrhVo) throws Exception {
        return list("sysmHist0200DAO.selectHist0200ExlList_D", hist0200SrhVo);
    } 
  /**
	 * HIST0200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return HIST0200 총 갯수
	 * @exception
	 */
  public int selectHist0200ListTotCnt(SysIfHist0200SrhVO hist0200SrhVo) {
      return (Integer)getSqlMapClientTemplate().queryForObject("sysmHist0200DAO.selectHist0200ListTotCnt_S", hist0200SrhVo);
  }  
    
    
   /**
	 * HIST0200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 HIST0200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteHist0200(SysIfHist0200SrhVO hist0200SrhVo) throws Exception {
         delete("sysmHist0200DAO.deleteHist0200_S", hist0200SrhVo);
    }
    
    /**
   	 * 오라클 디비 용량체크 확인 
   	 * @param vo - 디비정보가 담긴 HIST0200vo
   	 * @return void형 
   	 * @exception Exception
   	 */ 
    
    public List selectXlsSysm3200List(SysIfHist0200SrhVO oracleDb0100) throws Exception {
        return list("sysmHist0200DAO.selectXlsSysm3200List_S", null);
   }
    
    public List selectXlsFileSysm3200List(SysIfHist0200SrhVO oracleDb0100) throws Exception {
        return list("sysmHist0200DAO.selectXlsFileSysm3200List_S", null);
   }



}
