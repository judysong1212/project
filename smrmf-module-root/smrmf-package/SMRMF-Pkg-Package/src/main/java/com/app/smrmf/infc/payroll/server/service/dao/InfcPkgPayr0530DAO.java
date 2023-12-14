package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0530SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0530VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0530DAO.java
 * @Description : Payr0530 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0530DAO")
public class InfcPkgPayr0530DAO extends EgovAbstractDAO {

	/**
	 * PAYR0530을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0530VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0530(InfcPkgPayr0530VO vo) throws Exception {
        return (String)insert("infcPkgPayr0530DAO.insertPayr0530_S", vo);
    }

    /**
	 * PAYR0530을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0530VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0530(InfcPkgPayr0530VO vo) throws Exception {
        update("infcPkgPayr0530DAO.updatePayr0530_S", vo);
    }

    /**
	 * PAYR0530을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0530VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0530(InfcPkgPayr0530VO vo) throws Exception {
        delete("infcPkgPayr0530DAO.deletePayr0530_S", vo);
    }
    

    /**
	 * PAYR0530을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0530VO
	 * @return 조회한 PAYR0530
	 * @exception Exception
	 */
    public InfcPkgPayr0530VO selectPayr0530Check(InfcPkgPayr0530VO vo) throws Exception {
        return (InfcPkgPayr0530VO) selectByPk("infcPkgPayr0530DAO.selectPayr0530Check_S", vo);
    }

    /**
	 * PAYR0530을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0530VO
	 * @return 조회한 PAYR0530
	 * @exception Exception
	 */
    public InfcPkgPayr0530VO selectPayr0530(InfcPkgPayr0530VO vo) throws Exception {
        return (InfcPkgPayr0530VO) selectByPk("infcPkgPayr0530DAO.selectPayr0530_S", vo);
    }

    /**
	 * PAYR0530 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0530 목록
	 * @exception Exception
	 */
    public List selectPayr0530List(InfcPkgPayr0530SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0530DAO.selectPayr0530List_D", searchVO);
    }

    /**
	 * PAYR0530 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0530 총 갯수
	 * @exception
	 */
    public int selectPayr0530ListTotCnt(InfcPkgPayr0530SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0530DAO.selectPayr0530ListTotCnt_S", searchVO);
    }

}
