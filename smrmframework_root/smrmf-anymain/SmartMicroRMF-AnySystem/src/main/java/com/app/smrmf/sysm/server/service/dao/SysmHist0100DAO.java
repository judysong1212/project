package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfHist0100SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : SysmIfHist0100DAO.java
 * @Description : SysmIfHist0100DAO DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysmHist0100DAO")
public class SysmHist0100DAO extends EgovAbstractDAO   {
	
	/**
	 *  시간 목록을 가져온다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return STTS0100 목록
	 * @exception Exception
	 */
	public List getHourList() throws Exception {
		return list("sysmHist0100DAO.getHour", null);
	}
	
	/**
	 *  분 목록을 가져온다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return STTS0100 목록
	 * @exception Exception
	 */
	public List getMinuteList() throws Exception {
		return list("sysmHist0100DAO.getMinute", null);
	}
	
	/**
	 *  목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return STTS0100 목록
	 * @exception Exception
	 */
    public List selectHist0100List(SysIfHist0100SrhVO hist0100SrhVo) throws Exception {
        return list("sysmHist0100DAO.selectHist0100List_D", hist0100SrhVo);
    }
    
    public List selectHist0100ExlList(SysIfHist0100SrhVO hist0100SrhVo) throws Exception {
        return list("sysmHist0100DAO.selectHist0100ExlList_D", hist0100SrhVo);
    } 
  /**
	 * HIST0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return HIST0100 총 갯수
	 * @exception
	 */
  public int selectHist0100ListTotCnt(SysIfHist0100SrhVO hist0100SrhVo) {
      return (Integer)getSqlMapClientTemplate().queryForObject("sysmHist0100DAO.selectHist0100ListTotCnt_S", hist0100SrhVo);
  }  
    
    
   /**
	 * HIST0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 HIST0100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteHist0100(SysIfHist0100SrhVO hist0100SrhVo) throws Exception {
         delete("sysmHist0100DAO.deleteHist0100_S", hist0100SrhVo);
    }

}
