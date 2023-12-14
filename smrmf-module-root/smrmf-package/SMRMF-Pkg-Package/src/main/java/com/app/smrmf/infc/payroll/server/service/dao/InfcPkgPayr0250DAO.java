package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;

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

@Repository("InfcPkgPayr0250DAO")
public class InfcPkgPayr0250DAO extends EgovAbstractDAO {

	/**
	 * PAYR0250을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0250VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0250(InfcPkgPayr0250VO vo) throws Exception {
        return (String)insert("infcPkgPayr0250DAO.insertPayr0250_S", vo);
    }

    /**
	 * PAYR0250을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0250VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0250(InfcPkgPayr0250VO vo) throws Exception {
        update("infcPkgPayr0250DAO.updatePayr0250_S", vo);
    }

    /**
     * PAYR0250을 수정한다.
     * @param vo - 수정할 정보가 담긴 Payr0250VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePayr0250PayDdlene(InfcPkgPayr0250VO vo) throws Exception {
        update("infcPkgPayr0250DAO.updatePayr0250PayDdlene_S", vo);
    }
    
    
    /**
	 * PAYR0250을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0250VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0250(InfcPkgPayr0250VO vo) throws Exception {
        delete("infcPkgPayr0250DAO.deletePayr0250_S", vo);
    }

    /**
	 * PAYR0250을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0250VO
	 * @return 조회한 PAYR0250
	 * @exception Exception
	 */
    
    public InfcPkgPayr0250VO selectPayr0250(InfcPkgPayr0250VO vo) throws Exception {
        return (InfcPkgPayr0250VO) selectByPk("infcPkgPayr0250DAO.selectPayr0250_S", vo);
    }

    /**
	 * PAYR0250 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0250 목록
	 * @exception Exception
	 */
    public List selectPayr0250List(InfcPkgPayr0250SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0250DAO.selectPayr0250List_D", searchVO);
    }

    /**
	 * PAYR0250 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0250 총 갯수
	 * @exception
	 */
    public int selectPayr0250ListTotCnt(InfcPkgPayr0250SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0250DAO.selectPayr0250ListTotCnt_S", searchVO);
    }
    
    /**
 	 * PAYR0250 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PAYR0250 목록
 	 * @exception Exception
 	 */
     public List selectPayr0250ToPayr4150List(InfcPkgPayr0250SrhVO searchVO) throws Exception {
         return list("infcPkgPayr0250DAO.selectPayr0250ToPayr4150List_D", searchVO);
     }

     /**
 	 * PAYR0250 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PAYR0250 총 갯수
 	 * @exception
 	 */
     public int selectPayr0250ToPayr4150ListTotCnt(InfcPkgPayr0250SrhVO searchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0250DAO.selectPayr0250ToPayr4150ListTotCnt_S", searchVO);
     }
     
     /**
  	 * PAYR0250 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0250 목록
  	 * @exception Exception
  	 */
      public List selectPayr0250ToPayr4250List(InfcPkgPayr0250SrhVO searchVO) throws Exception {
          return list("infcPkgPayr0250DAO.selectPayr0250ToPayr4250List_D", searchVO);
      }

      /**
  	 * PAYR0250 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0250 총 갯수
  	 * @exception
  	 */
      public int selectPayr0250ToPayr4250ListTotCnt(InfcPkgPayr0250SrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0250DAO.selectPayr0250ToPayr4250ListTotCnt_S", searchVO);
      }
    
    
     
}
