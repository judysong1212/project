package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0309SrhVO;
import com.app.exterms.payroll.server.vo.Payr0309VO;

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

@Repository("Payr0309DAO")
public class Payr0309DAO extends EgovAbstractDAO {

	/**
	 * PAYR0309을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0309VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertPayr0309(Payr0309VO vo) throws Exception {
        return (String)insert("payr0309DAO.insertPayr0309_S", vo);
    }

    /**
	 * PAYR0309을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0309VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updatePayr0309(Payr0309VO vo) throws Exception {
        update("payr0309DAO.updatePayr0309_S", vo);
    }

    /**
	 * PAYR0309을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0309VO
	 * @return void형 
	 * @exception Exception
	 */
	@Transactional
    public void deletePayr0309(Payr0309VO vo) throws Exception {
        delete("payr0309DAO.deletePayr0309_S", vo);
    }

	@Transactional
    public void deletePayCalculationPayr0309(Payr0309VO vo) throws Exception {
        delete("payr0309DAO.deletePayCalculationPayr0309_S", vo);
    }
    /**
	 * PAYR0309을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0309VO
	 * @return 조회한 PAYR0309
	 * @exception Exception
	 */
    public Payr0309VO selectPayr0309(Payr0309VO vo) throws Exception {
        return (Payr0309VO) selectByPk("payr0309DAO.selectPayr0309_S", vo);
    }

    /**
	 * PAYR0309 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0309 목록
	 * @exception Exception
	 */
    public List<?> selectPayr0309List(Payr0309SrhVO searchVO) throws Exception {
        return list("payr0309DAO.selectPayr0309List_D", searchVO);
    }

    /**
	 * PAYR0309 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0309 총 갯수
	 * @exception
	 */
    public int selectPayr0309ListTotCnt(Payr0309SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0309DAO.selectPayr0309ListTotCnt_S", searchVO);
    }

}
