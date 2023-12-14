package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0306SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0306VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0306DAO.java
 * @Description : Payr0306 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0306DAO")
public class InfcPkgPayr0306DAO extends EgovAbstractDAO {

	/**
	 * PAYR0306을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0306VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0306(InfcPkgPayr0306VO vo) throws Exception {
        return (String)insert("infcPkgPayr0306DAO.insertPayr0306_S", vo);
    }

    /**
	 * PAYR0306을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0306VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0306(InfcPkgPayr0306VO vo) throws Exception {
        update("infcPkgPayr0306DAO.updatePayr0306_S", vo);
    }

    /**
	 * PAYR0306을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0306VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0306(InfcPkgPayr0306VO vo) throws Exception {
        delete("infcPkgPayr0306DAO.deletePayr0306_S", vo);
    }


    /**
     * PAYR0306을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0306VO
     * @return void형 
     * @exception Exception
     */
    public void deletePayCalculationPayr0306(InfcPkgPayr0306VO vo) throws Exception {
        delete("infcPkgPayr0306DAO.deletePayCalculationPayr0306_S", vo);
    }
 
    /**
	 * PAYR0306을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0306VO
	 * @return 조회한 PAYR0306
	 * @exception Exception
	 */
    public InfcPkgPayr0306VO selectPayr0306(InfcPkgPayr0306VO vo) throws Exception {
        return (InfcPkgPayr0306VO) selectByPk("infcPkgPayr0306DAO.selectPayr0306_S", vo);
    }

    /**
	 * PAYR0306 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0306 목록
	 * @exception Exception
	 */
    public List selectPayr0306List(InfcPkgPayr0306SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0306DAO.selectPayr0306List_D", searchVO);
    }

    /**
	 * PAYR0306 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0306 총 갯수
	 * @exception
	 */
    public int selectPayr0306ListTotCnt(InfcPkgPayr0306SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0306DAO.selectPayr0306ListTotCnt_S", searchVO);
    }

}
