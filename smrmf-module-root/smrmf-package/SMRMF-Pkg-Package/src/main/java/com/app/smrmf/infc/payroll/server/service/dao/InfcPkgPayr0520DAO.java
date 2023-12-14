package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0520DAO.java
 * @Description : Payr0520 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0520DAO")
public class InfcPkgPayr0520DAO extends EgovAbstractDAO {
	
 
	/**
	 * PAYR0520을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0520VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertPayr0520(InfcPkgPayr0520VO vo) throws Exception {
        return (String)insert("infcPkgPayr0520DAO.insertPayr0520_S", vo);
    }

    /**
	 * PAYR0520을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0520VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updatePayr0520(InfcPkgPayr0520VO vo) throws Exception {
        update("infcPkgPayr0520DAO.updatePayr0520_S", vo);
    }

    /**
	 * PAYR0520을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0520VO
	 * @return void형 
	 * @exception Exception
	 */
	@Transactional
    public void deletePayr0520(InfcPkgPayr0520VO vo) throws Exception {
        delete("infcPkgPayr0520DAO.deletePayr0520_S", vo);
    }

    /**
	 * PAYR0520을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0520VO
	 * @return 조회한 PAYR0520
	 * @exception Exception
	 */
    public InfcPkgPayr0520VO selectPayr0520(InfcPkgPayr0520VO vo) throws Exception {
        return (InfcPkgPayr0520VO) selectByPk("infcPkgPayr0520DAO.selectPayr0520_S", vo);
    }

    /**
	 * PAYR0520 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0520 목록
	 * @exception Exception
	 */
    public List selectPayr0520List(InfcPkgPayr0520SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0520DAO.selectPayr0520List_D", searchVO);
    }
    
    
    

    /**
	 * PAYR0520 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0520 총 갯수
	 * @exception
	 */
    public int selectPayr0520ListTotCnt(InfcPkgPayr0520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0520DAO.selectPayr0520ListTotCnt_S", searchVO);
    }
    
    /**
     * PAYR0520 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0520 목록
     * @exception Exception
     */
    public List selectPayr0520ToPayr3200DducdivcdList(InfcPkgPayr0520SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0520DAO.selectPayr0520ToPayr3200DducdivcdList_D", searchVO);
    }
    
    
    

    /**
     * PAYR0520 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0520 총 갯수
     * @exception
     */
    public int selectPayr0520ToPayr3200DducdivcdListTotCnt(InfcPkgPayr0520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0520DAO.selectPayr0520ToPayr3200DducdivcdListTotCnt_S", searchVO);
    }
     
    
    /**
     * PAYR0520 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0520 목록
     * @exception Exception
     */
    public List selectPayr0520ToPayr3200List(InfcPkgPayr0520SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0520DAO.selectPayr0520ToPayr3200List_D", searchVO);
    }
    
    
    

    /**
     * PAYR0520 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0520 총 갯수
     * @exception
     */
    public int selectPayr0520ToPayr3200ListTotCnt(InfcPkgPayr0520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0520DAO.selectPayr0520ToPayr3200ListTotCnt_S", searchVO);
    }


    public List selectPayr0520ToPayrCalcList(InfcPkgPayr0520SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0520DAO.selectPayr0520ToPayrCalcList_D", searchVO);
    }
    
    

}
