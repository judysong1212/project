package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0250SrhVO;
import com.app.exterms.payroll.server.vo.Payr0250VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0250DAO.java
 * @Description : Payr0250 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0250DAO")
public class Payr0250DAO extends EgovAbstractDAO {

	/**
	 * PAYR0250을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0250VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0250(Payr0250VO vo) throws Exception {
        return (String)insert("payr0250DAO.insertPayr0250_S", vo);
    }
    
    @Transactional
    public String insertPayr0250FromPayrP405001(Payr0250VO vo) throws Exception {
        return (String)insert("payr0250DAO.insertLumpPayr0250_S", vo);
    }

    /**
	 * PAYR0250을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0250VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0250(Payr0250VO vo) throws Exception {
        update("payr0250DAO.updatePayr0250_S", vo);
    }

    /**
     * PAYR0250을 수정한다.
     * @param vo - 수정할 정보가 담긴 Payr0250VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePayr0250PayDdlene(Payr0250VO vo) throws Exception {
        update("payr0250DAO.updatePayr0250PayDdlene_S", vo);
    }
    
    
    /**
	 * PAYR0250을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0250VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0250(Payr0250VO vo) throws Exception {
        delete("payr0250DAO.deletePayr0250_S", vo);
    }

    /**
	 * PAYR0250을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0250VO
	 * @return 조회한 PAYR0250
	 * @exception Exception
	 */
    
    public Payr0250VO selectPayr0250(Payr0250VO vo) throws Exception {
        return (Payr0250VO) selectByPk("payr0250DAO.selectPayr0250_S", vo);
    }

    
    

    /**
	 * PAYR0250 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0250 목록
	 * @exception Exception
	 */
    public List selectPayr0250CheckList(Payr0250VO searchVO) throws Exception {
        return list("payr0250DAO.selectPayr0250CheckList_D", searchVO);
    }
    
    
    /**
	 * PAYR0250 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0250 목록
	 * @exception Exception
	 */
    public List selectPayr0250List(Payr0250SrhVO searchVO) throws Exception {
        return list("payr0250DAO.selectPayr0250List_D", searchVO);
    }

    /**
	 * PAYR0250 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0250 총 갯수
	 * @exception
	 */
    public int selectPayr0250ListTotCnt(Payr0250SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0250DAO.selectPayr0250ListTotCnt_S", searchVO);
    }
    
    /**
 	 * PAYR0250 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PAYR0250 목록
 	 * @exception Exception
 	 */
     public List selectPayr0250ToPayr4150List(Payr0250SrhVO searchVO) throws Exception {
         return list("payr0250DAO.selectPayr0250ToPayr4150List_D", searchVO);
     }

     /**
 	 * PAYR0250 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PAYR0250 총 갯수
 	 * @exception
 	 */
     public int selectPayr0250ToPayr4150ListTotCnt(Payr0250SrhVO searchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("payr0250DAO.selectPayr0250ToPayr4150ListTotCnt_S", searchVO);
     }
     
     /**
  	 * PAYR0250 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0250 목록
  	 * @exception Exception
  	 */
      public List selectPayr0250ToPayr4250List(Payr0250SrhVO searchVO) throws Exception {
          return list("payr0250DAO.selectPayr0250ToPayr4250List_D", searchVO);
      }

      /**
  	 * PAYR0250 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0250 총 갯수
  	 * @exception
  	 */
      public int selectPayr0250ToPayr4250ListTotCnt(Payr0250SrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("payr0250DAO.selectPayr0250ToPayr4250ListTotCnt_S", searchVO);
      }
      
      
	/**
	 * PAYR0250 목록을 조회한다.
	 * @param searchMap- 조회할 정보가 담긴 Map
	 * @return PAYR0250 목록
	 * @exception Exception
	 */
	public List selectCoCalendar(Payr0250SrhVO payr0250SrhVo) throws Exception {
		return list("payr0250DAO.getCoCalendar", payr0250SrhVo);
	}
	
    /**
	 * PAYR0250 목록을 조회한다.
	 * @param searchMap- 조회할 정보가 담긴 Map
	 * @return PAYR0250 목록
	 * @exception Exception
	 */
    public int selectCoCalendarCnt(Payr0250SrhVO payr0250SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0250DAO.getCoCalendarCnt", payr0250SrhVo);
    }

    public int checkSysm0700(Payr0250SrhVO payr0250SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0250DAO.checkSysm0700", payr0250SrhVo);
    }
    
     
}
