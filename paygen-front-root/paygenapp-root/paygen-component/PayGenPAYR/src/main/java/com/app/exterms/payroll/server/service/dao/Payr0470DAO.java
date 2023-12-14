package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0470SrhVO;
import com.app.exterms.payroll.server.vo.Payr0470VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0470DAO.java
 * @Description : Payr0470 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0470DAO")
public class Payr0470DAO extends EgovAbstractDAO {

	/**
	 * PAYR0470을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0470VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0470(Payr0470VO vo) throws Exception {
        return (String)insert("payr0470DAO.insertPayr0470_S", vo);
    }

    /**
	 * PAYR0470을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0470VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0470(Payr0470VO vo) throws Exception {
        update("payr0470DAO.updatePayr0470_S", vo);
    }

    /**
	 * PAYR0470을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0470VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0470(Payr0470VO vo) throws Exception {
        delete("payr0470DAO.deletePayr0470_S", vo);
    }

    /**
	 * PAYR0470을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0470VO
	 * @return 조회한 PAYR0470
	 * @exception Exception
	 */
    public Payr0470VO selectPayr0470(Payr0470VO vo) throws Exception {
        return (Payr0470VO) selectByPk("payr0470DAO.selectPayr0470_S", vo);
    }

    /**
	 * PAYR0470 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0470 목록
	 * @exception Exception
	 */
    public List selectPayr0470List(Payr0470SrhVO searchVO) throws Exception {
        return list("payr0470DAO.selectPayr0470List_D", searchVO);
    }

    /**
	 * PAYR0470 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0470 총 갯수
	 * @exception
	 */
    public int selectPayr0470ListTotCnt(Payr0470SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0470DAO.selectPayr0470ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PAYR0470 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0470 목록
   	 * @exception Exception
   	 */
       public List selectPayr0470ToPayr4450List(Payr0470SrhVO searchVO) throws Exception {
           return list("payr0470DAO.selectPayr0470ToPayr4450List_D", searchVO);
       }
       
   /**
  	 * PAYR0470 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0470 목록
  	 * @exception Exception
  	 */
      public List selectPayr0470ToPayr0480List(Payr0470SrhVO searchVO) throws Exception {
          return list("payr0470DAO.selectPayr0470ToPayr0480List", searchVO);
      }

	/**
   	 * PAYR0470 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0470 총 갯수
   	 * @exception
   	 */
       public int selectPayr0470ToPayr4450ListTotCnt(Payr0470SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("payr0470DAO.selectPayr0470ToPayr4450ListTotCnt_S", searchVO);
       }
       
       
       /** 지급공제 구분에 따른 지급공제항목 리스트 **/
		@SuppressWarnings("rawtypes")
		public List selectPayDducExtpyCd(Payr0470SrhVO payr0470SrhVo) {
			return list("payr0470DAO.selectPayr0470AND480ToPayr4200List_D", payr0470SrhVo);
		}

}
