package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0302DAO.java
 * @Description : Payr0302 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0302DAO")
public class InfcPkgPayr0302DAO extends EgovAbstractDAO {

	/**
	 * PAYR0302을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0302VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0302(InfcPkgPayr0302VO vo) throws Exception {
        return (String)insert("infcPkgPayr0302DAO.insertPayr0302_S", vo);
    }

    /**
	 * PAYR0302을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0302VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0302(InfcPkgPayr0302VO vo) throws Exception {
        update("infcPkgPayr0302DAO.updatePayr0302_S", vo);
    }
    @Transactional
    public void updatePayr0302Payr0307(InfcPkgPayr0302VO vo) throws Exception {
        update("infcPkgPayr0302DAO.updatePayr0302Payr0307_S", vo);
    }
    
    /**
	 * PAYR0302을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0302VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0302(InfcPkgPayr0302VO vo) throws Exception {
        delete("infcPkgPayr0302DAO.deletePayr0302_S", vo);
    }
    @Transactional
    public void deletePayr0302Payr0307(InfcPkgPayr0302VO vo) throws Exception {
        delete("infcPkgPayr0302DAO.deletePayr0302Payr0307_S", vo);
    }
    @Transactional
    public void deletePayr0302ToPayr0307T(InfcPkgPayr0302VO vo) throws Exception {
        delete("infcPkgPayr0302DAO.deletePayr0302ToPayr0307T_S", vo);
    }
     
    
    /**
     * PAYR0302을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0302VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0302(InfcPkgPayr0302VO vo) throws Exception {
        delete("infcPkgPayr0302DAO.deletePayCalculationPayr0302_S", vo);
    }
    
     

    /**
	 * PAYR0302을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0302VO
	 * @return 조회한 PAYR0302
	 * @exception Exception
	 */
    public InfcPkgPayr0302VO selectPayr0302(InfcPkgPayr0302VO vo) throws Exception {
        return (InfcPkgPayr0302VO) selectByPk("infcPkgPayr0302DAO.selectPayr0302_S", vo);
    }

    public InfcPkgPayr0302VO selectPayr0302Payr0307(InfcPkgPayr0302VO vo) throws Exception {
        return (InfcPkgPayr0302VO) selectByPk("infcPkgPayr0302DAO.selectPayr0302Payr0307_S", vo);
    }
    
     
    /**
	 * PAYR0302 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0302 목록
	 * @exception Exception
	 */
    public List selectPayr0302List(InfcPkgPayr0302SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0302DAO.selectPayr0302List_D", searchVO);
    }

    /**
	 * PAYR0302 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0302 총 갯수
	 * @exception
	 */
    public int selectPayr0302ListTotCnt(InfcPkgPayr0302SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0302DAO.selectPayr0302ListTotCnt_S", searchVO);
    }
	
    /**
	 * PAYR0302 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0302 목록
	 * @exception Exception
	 */
    public List selectPayr0302ExtpyList(InfcPkgPayr0302SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0302DAO.selectPayr0302ExtpyList_D", searchVO);
    }

    /**
	 * PAYR0302 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0302 총 갯수
	 * @exception
	 */
    public int selectPayr0302ExtpyListTotCnt(InfcPkgPayr0302SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0302DAO.selectPayr0302ExtpyListTotCnt_S", searchVO);
    }
    
    /**
 	 * PAYR0302 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PAYR0302 목록
 	 * @exception Exception
 	 */
     public List selectPayr0302DducList(InfcPkgPayr0302SrhVO searchVO) throws Exception {
         return list("infcPkgPayr0302DAO.selectPayr0302DducList_D", searchVO);
     }

     /**
 	 * PAYR0302 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PAYR0302 총 갯수
 	 * @exception
 	 */
     public int selectPayr0302DducListTotCnt(InfcPkgPayr0302SrhVO searchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0302DAO.selectPayr0302DducListTotCnt_S", searchVO);
     }


}
