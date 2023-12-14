package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0303SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0303VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0303DAO.java
 * @Description : Payr0303 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0303DAO")
public class InfcPkgPayr0303DAO extends EgovAbstractDAO {

	/**
	 * PAYR0303을 등록한다.
	 * @param vo - 등록할 정보가 담긴 InfcPkgPayr0303VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPayr0303(InfcPkgPayr0303VO vo) throws Exception {
        return (String)insert("infcPkgPayr0303DAO.insertPayr0303_S", vo);
    }

    /**
	 * PAYR0303을 수정한다.
	 * @param vo - 수정할 정보가 담긴 InfcPkgPayr0303VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayr0303(InfcPkgPayr0303VO vo) throws Exception {
        update("infcPkgPayr0303DAO.updatePayr0303_S", vo);
    }

    /**
	 * PAYR0303을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 InfcPkgPayr0303VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePayr0303(InfcPkgPayr0303VO vo) throws Exception {
        delete("infcPkgPayr0303DAO.deletePayr0303_S", vo);
    }

    /**
	 * PAYR0303을 조회한다.
	 * @param vo - 조회할 정보가 담긴 InfcPkgPayr0303VO
	 * @return 조회한 PAYR0303
	 * @exception Exception
	 */
    public InfcPkgPayr0303VO selectPayr0303(InfcPkgPayr0303VO vo) throws Exception {
        return (InfcPkgPayr0303VO) selectByPk("infcPkgPayr0303DAO.selectPayr0303_S", vo);
    }

    /**
	 * PAYR0303 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0303 목록
	 * @exception Exception
	 */
    public List<?> selectPayr0303List(InfcPkgPayr0303SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0303DAO.selectPayr0303List_D", searchVO);
    }

    /**
	 * PAYR0303 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0303 총 갯수
	 * @exception
	 */
    public int selectPayr0303ListTotCnt(InfcPkgPayr0303SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0303DAO.selectPayr0303ListTotCnt_S", searchVO);
    }
}
