package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0309SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0309VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0309DAO.java
 * @Description : Payr0309 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.07.02
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0309DAO")
public class InfcPkgPayr0309DAO extends EgovAbstractDAO {

	/**
	 * PAYR0309을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0309VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPayr0309(InfcPkgPayr0309VO vo) throws Exception {
        return (String)insert("infcPkgPayr0309DAO.insertPayr0309_S", vo);
    }

    /**
	 * PAYR0309을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0309VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayr0309(InfcPkgPayr0309VO vo) throws Exception {
        update("infcPkgPayr0309DAO.updatePayr0309_S", vo);
    }

    /**
	 * PAYR0309을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0309VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePayr0309(InfcPkgPayr0309VO vo) throws Exception {
        delete("infcPkgPayr0309DAO.deletePayr0309_S", vo);
    }

    /**
	 * PAYR0309을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0309VO
	 * @return 조회한 PAYR0309
	 * @exception Exception
	 */
    public InfcPkgPayr0309VO selectPayr0309(InfcPkgPayr0309VO vo) throws Exception {
        return (InfcPkgPayr0309VO) selectByPk("infcPkgPayr0309DAO.selectPayr0309_S", vo);
    }

    /**
	 * PAYR0309 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0309 목록
	 * @exception Exception
	 */
    public List<?> selectPayr0309List(InfcPkgPayr0309SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0309DAO.selectPayr0309List_D", searchVO);
    }

    /**
	 * PAYR0309 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0309 총 갯수
	 * @exception
	 */
    public int selectPayr0309ListTotCnt(InfcPkgPayr0309SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0309DAO.selectPayr0309ListTotCnt_S", searchVO);
    }

}
