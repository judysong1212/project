package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0460SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0460VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0460DAO.java
 * @Description : Payr0460 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0460DAO")
public class InfcPkgPayr0460DAO extends EgovAbstractDAO {

	/**
	 * PAYR0460을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0460VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0460(InfcPkgPayr0460VO vo) throws Exception {
        return (String)insert("infcPkgPayr0460DAO.insertPayr0460_S", vo);
    }

    /**
	 * PAYR0460을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0460VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0460(InfcPkgPayr0460VO vo) throws Exception {
        update("infcPkgPayr0460DAO.updatePayr0460_S", vo);
    }

    /**
	 * PAYR0460을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0460VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0460(InfcPkgPayr0460VO vo) throws Exception {
        delete("infcPkgPayr0460DAO.deletePayr0460_S", vo);
    }

    /**
	 * PAYR0460을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0460VO
	 * @return 조회한 PAYR0460
	 * @exception Exception
	 */
    public InfcPkgPayr0460VO selectPayr0460(InfcPkgPayr0460VO vo) throws Exception {
        return (InfcPkgPayr0460VO) selectByPk("infcPkgPayr0460DAO.selectPayr0460_S", vo);
    }

    /**
	 * PAYR0460 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0460 목록
	 * @exception Exception
	 */
    public List selectPayr0460List(InfcPkgPayr0460SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0460DAO.selectPayr0460List_D", searchVO);
    }

    /**
	 * PAYR0460 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0460 총 갯수
	 * @exception
	 */
    public int selectPayr0460ListTotCnt(InfcPkgPayr0460SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0460DAO.selectPayr0460ListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR0460 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0460 목록
	 * @exception Exception
	 */
    public List selectPayr0460ToPayr5500List(InfcPkgPayr0460SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0460DAO.selectPayr0460ToPayr5500List_D", searchVO);
    }

    /**
	 * PAYR0460 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0460 총 갯수
	 * @exception
	 */
    public int selectPayr0460ToPayr5500ListTotCnt(InfcPkgPayr0460SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0460DAO.selectPayr0460ToPayr5500ListTotCnt_S", searchVO);
    }
    
    

}
