package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0900SrhVO;
import com.app.exterms.payroll.server.vo.Payr0900VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0900DAO.java
 * @Description : Payr0900 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0900DAO")
public class Payr0900DAO extends EgovAbstractDAO {

	/**
	 * PAYR0900을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0900VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0900(Payr0900VO vo) throws Exception {
        return (String)insert("payr0900DAO.insertPayr0900_S", vo);
    }

    /**
	 * PAYR0900을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0900VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0900(Payr0900VO vo) throws Exception {
        update("payr0900DAO.updatePayr0900_S", vo);
    }

    /**
	 * PAYR0900을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0900VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0900(Payr0900VO vo) throws Exception {
        delete("payr0900DAO.deletePayr0900_S", vo);
    }

    /**
	 * PAYR0900을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0900VO
	 * @return 조회한 PAYR0900
	 * @exception Exception
	 */
    public Payr0900VO selectPayr0900(Payr0900VO vo) throws Exception {
        return (Payr0900VO) selectByPk("payr0900DAO.selectPayr0900_S", vo);
    }

    /**
	 * PAYR0900 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0900 목록
	 * @exception Exception
	 */
    public List selectPayr0900List(Payr0900SrhVO searchVO) throws Exception {
        return list("payr0900DAO.selectPayr0900List_D", searchVO);
    }

    /**
	 * PAYR0900 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0900 총 갯수
	 * @exception
	 */
    public int selectPayr0900ListTotCnt(Payr0900SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0900DAO.selectPayr0900ListTotCnt_S", searchVO);
    }

}
