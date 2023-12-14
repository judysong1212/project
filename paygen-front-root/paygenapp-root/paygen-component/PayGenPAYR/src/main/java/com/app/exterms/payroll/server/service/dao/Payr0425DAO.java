package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0425SrhVO;
import com.app.exterms.payroll.server.vo.Payr0425VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0425DAO.java
 * @Description : Payr0425 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0425DAO")
public class Payr0425DAO extends EgovAbstractDAO {

	/**
	 * PAYR0425을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0425VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0425(Payr0425VO vo) throws Exception {
        return (String)insert("payr0425DAO.insertPayr0425_S", vo);
    }

    /**
	 * PAYR0425을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0425VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0425(Payr0425VO vo) throws Exception {
        update("payr0425DAO.updatePayr0425_S", vo);
    }

    /**
	 * PAYR0425을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0425VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0425(Payr0425VO vo) throws Exception {
        delete("payr0425DAO.deletePayr0425_S", vo);
    }

    /**
	 * PAYR0425을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0425VO
	 * @return 조회한 PAYR0425
	 * @exception Exception
	 */
    public Payr0425VO selectPayr0425(Payr0425VO vo) throws Exception {
        return (Payr0425VO) selectByPk("payr0425DAO.selectPayr0425_S", vo);
    }

    /**
	 * PAYR0425 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0425 목록
	 * @exception Exception
	 */
    public List selectPayr0425List(Payr0425SrhVO searchVO) throws Exception {
        return list("payr0425DAO.selectPayr0425List_D", searchVO);
    }

    /**
	 * PAYR0425 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0425 총 갯수
	 * @exception
	 */
    public int selectPayr0425ListTotCnt(Payr0425SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0425DAO.selectPayr0425ListTotCnt_S", searchVO);
    }

}
