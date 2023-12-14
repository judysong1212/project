package com.app.smrmf.syscom.server.service.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.SysCoCalendarSrhVO;
import com.app.smrmf.sysm.server.service.vo.SysCoCalendarVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : CoCalendarDAO.java
 * @Description : CoCalendar DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysCoCalendarDAO")
public class SysCoCalendarDAO extends EgovAbstractDAO {

	/**
	 * CO_CALENDAR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CoCalendarVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertCoCalendar(SysCoCalendarVO vo) throws Exception {
        return (String)insert("SysCoCalendarDAO.insertCoCalendar_S", vo);
    }

    /**
	 * CO_CALENDAR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CoCalendarVO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateCoCalendar(SysCoCalendarVO vo) throws Exception {
        update("SysCoCalendarDAO.updateCoCalendar_S", vo);
    }

    /**
	 * CO_CALENDAR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CoCalendarVO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteCoCalendar(SysCoCalendarVO vo) throws Exception {
        delete("SysCoCalendarDAO.deleteCoCalendar_S", vo);
    }

    /**
	 * CO_CALENDAR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CoCalendarVO
	 * @return 조회한 CO_CALENDAR
	 * @exception Exception
	 */
    public SysCoCalendarVO selectCoCalendar(SysCoCalendarVO vo) throws Exception {
        return (SysCoCalendarVO) selectByPk("SysCoCalendarDAO.selectCoCalendar_S", vo);
    }

    /**
	 * CO_CALENDAR 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CO_CALENDAR 목록
	 * @exception Exception
	 */
   @Cacheable(value = "calcCache")
    public List selectCoCalendarList(SysCoCalendarSrhVO searchVO) throws Exception {
        return list("SysCoCalendarDAO.selectCoCalendarList_D", searchVO);
    }
    
    
    /**
 	 * CO_CALENDAR 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return CO_CALENDAR 목록
 	 * @exception Exception
 	 */
     @Cacheable(value = "calcMonCache")
     public List selectCoCalendarMonthList(SysCoCalendarSrhVO searchVO) throws Exception {
         return list("SysCoCalendarDAO.selectCoCalendarMonthList_D", searchVO);
     }

     
    /**
	 * CO_CALENDAR 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CO_CALENDAR 총 갯수
	 * @exception
	 */
    public int selectCoCalendarListTotCnt(SysCoCalendarSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("SysCoCalendarDAO.selectCoCalendarListTotCnt_S", searchVO);
    }

}
