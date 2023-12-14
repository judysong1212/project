package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0305DAO.java
 * @Description : Payr0305 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0305DAO")
public class InfcPkgPayr0305DAO extends EgovAbstractDAO {

	/**
	 * PAYR0305을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0305VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0305(InfcPkgPayr0305VO vo) throws Exception {
        return (String)insert("infcPkgPayr0305DAO.insertPayr0305_S", vo);
    }

    /**
	 * PAYR0305을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0305VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0305(InfcPkgPayr0305VO vo) throws Exception {
        update("infcPkgPayr0305DAO.updatePayr0305_S", vo);
    }
    
    
    @Transactional
    public void updatePayr0302ToPayr0305(InfcPkgPayr0305VO vo) throws Exception {
        update("infcPkgPayr0305DAO.updatePayr0302ToPayr0305_S", vo);
    }
	 

    /**
	 * PAYR0305을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0305VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0305(InfcPkgPayr0305VO vo) throws Exception {
        delete("infcPkgPayr0305DAO.deletePayr0305_S", vo);
    }
    /**
     * PAYR0305을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0305VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0305(InfcPkgPayr0305VO vo) throws Exception {
        delete("infcPkgPayr0305DAO.deletePayCalculationPayr0305_S", vo);
    }
    
    
    /**
	 * PAYR0305을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0305VO
	 * @return 조회한 PAYR0305
	 * @exception Exception
	 */
    public InfcPkgPayr0305VO selectPayr0305(InfcPkgPayr0305VO vo) throws Exception {
        return (InfcPkgPayr0305VO) selectByPk("infcPkgPayr0305DAO.selectPayr0305_S", vo);
    }

    /**
	 * PAYR0305 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0305 목록
	 * @exception Exception
	 */
    public List selectPayr0305List(InfcPkgPayr0305SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0305DAO.selectPayr0305List_D", searchVO);
    }

    /**
	 * PAYR0305 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0305 총 갯수
	 * @exception
	 */
    public int selectPayr0305ListTotCnt(InfcPkgPayr0305SrhVO searchVO) {
     
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0305DAO.selectPayr0305ListTotCnt_S", searchVO);
    }

}
