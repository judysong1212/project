package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0445SrhVO;
import com.app.exterms.payroll.server.vo.Payr0445VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0445DAO.java
 * @Description : Payr0445 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0445DAO")
public class Payr0445DAO extends EgovAbstractDAO {

	/**
	 * PAYR0445을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0445VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0445(Payr0445VO vo) throws Exception {
        return (String)insert("payr0445DAO.insertPayr0445_S", vo);
    }

    /**
	 * PAYR0445을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0445VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0445(Payr0445VO vo) throws Exception {
        update("payr0445DAO.updatePayr0445_S", vo);
    }

    /**
	 * PAYR0445을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0445VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0445(Payr0445VO vo) throws Exception {
        delete("payr0445DAO.deletePayr0445_S", vo);
    }

    /**
	 * PAYR0445을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0445VO
	 * @return 조회한 PAYR0445
	 * @exception Exception
	 */
    public Payr0445VO selectPayr0445(Payr0445VO vo) throws Exception {
        return (Payr0445VO) selectByPk("payr0445DAO.selectPayr0445_S", vo);
    }

    /**
	 * PAYR0445 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0445 목록
	 * @exception Exception
	 */
    public List selectPayr0445List(Payr0445SrhVO searchVO) throws Exception {
        return list("payr0445DAO.selectPayr0445List_D", searchVO);
    }

    /**
	 * PAYR0445 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0445 총 갯수
	 * @exception
	 */
    public int selectPayr0445ListTotCnt(Payr0445SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0445DAO.selectPayr0445ListTotCnt_S", searchVO);
    }

}
