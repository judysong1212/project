package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0307SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0307VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0307DAO.java
 * @Description : Payr0307 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0307DAO")
public class InfcPkgPayr0307DAO extends EgovAbstractDAO {

	/**
	 * PAYR0307을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0307VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0307(InfcPkgPayr0307VO vo) throws Exception {
        return (String)insert("infcPkgPayr0307DAO.insertPayr0307_S", vo);
    }

    /**
	 * PAYR0307을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0307VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0307(InfcPkgPayr0307VO vo) throws Exception {
        update("infcPkgPayr0307DAO.updatePayr0307_S", vo);
    }

    /**
	 * PAYR0307을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0307VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0307(InfcPkgPayr0307VO vo) throws Exception {
        delete("infcPkgPayr0307DAO.deletePayr0307_S", vo);
    }

    /**
     * PAYR0307을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0307VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0307(InfcPkgPayr0307VO vo) throws Exception {
        delete("infcPkgPayr0307DAO.deletePayCalculationPayr0307_S", vo);
    }
  
    /**
	 * PAYR0307을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0307VO
	 * @return 조회한 PAYR0307
	 * @exception Exception
	 */
    public InfcPkgPayr0307VO selectPayr0307(InfcPkgPayr0307VO vo) throws Exception {
        return (InfcPkgPayr0307VO) selectByPk("infcPkgPayr0307DAO.selectPayr0307_S", vo);
    }
    
    
    public InfcPkgPayr0307VO selectPayr0307Max(InfcPkgPayr0307VO vo) throws Exception {
        return (InfcPkgPayr0307VO) selectByPk("infcPkgPayr0307DAO.selectPayr0307Max_S", vo);
    }
    
    public List<InfcPkgPayr0307VO> selectPayr0307All(InfcPkgPayr0307VO vo) throws Exception {
        return (List<InfcPkgPayr0307VO>)list("infcPkgPayr0307DAO.selectPayr0307All_S", vo); 
    }
    
    public List selectPayr0307ToFreeCalcList(InfcPkgPayr0307SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0307DAO.selectPayr0307ToFreeCalcList_D", searchVO);
    } 

    /**
	 * PAYR0307 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 목록
	 * @exception Exception
	 */
    public List selectPayr0307List(InfcPkgPayr0307SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0307DAO.selectPayr0307List_D", searchVO);
    }

    /**
	 * PAYR0307 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 총 갯수
	 * @exception
	 */
    public int selectPayr0307ListTotCnt(InfcPkgPayr0307SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0307DAO.selectPayr0307ListTotCnt_S", searchVO);
    }
	

    /**
	 * PAYR0307 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 목록
	 * @exception Exception
	 */
    public List selectPayr0307ToPayr4200List(InfcPkgPayr0307SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0307DAO.selectPayr0307ToPayr4200List_D", searchVO);
    }

    /**
	 * PAYR0307 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 총 갯수
	 * @exception
	 */
    public int selectPayr0307ToPayr4200ListTotCnt(InfcPkgPayr0307SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0307DAO.selectPayr0307ToPayr4200ListTotCnt_S", searchVO);
    }
    

    /**
	 * PAYR0307 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 목록
	 * @exception Exception
	 */
    public List selectPayr0307ToPayr420001List(InfcPkgPayr0307SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0307DAO.selectPayr0307ToPayr420001List_D", searchVO);
    }

    /**
	 * PAYR0307 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 총 갯수
	 * @exception
	 */
    public int selectPayr0307ToPayr420001ListTotCnt(InfcPkgPayr0307SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0307DAO.selectPayr0307ToPayr420001ListTotCnt_S", searchVO);
    }
    
    

}
