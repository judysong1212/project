package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0306SrhVO;
import com.app.exterms.payroll.server.vo.Payr0306VO;

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

@Repository("Payr0306DAO")
public class Payr0306DAO extends EgovAbstractDAO {

	/**
	 * PAYR0306을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0306VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0306(Payr0306VO vo) throws Exception {
        return (String)insert("payr0306DAO.insertPayr0306_S", vo);
    }

    /**
	 * PAYR0306을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0306VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0306(Payr0306VO vo) throws Exception {
        update("payr0306DAO.updatePayr0306_S", vo);
    }

    /**
	 * PAYR0306을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0306VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0306(Payr0306VO vo) throws Exception {
        delete("payr0306DAO.deletePayr0306_S", vo);
    }


    /**
     * PAYR0306을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0306VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0306(Payr0306VO vo) throws Exception {
        delete("payr0306DAO.deletePayCalculationPayr0306_S", vo);
    }
 
    /**
	 * PAYR0306을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0306VO
	 * @return 조회한 PAYR0306
	 * @exception Exception
	 */
    public Payr0306VO selectPayr0306(Payr0306VO vo) throws Exception {
        return (Payr0306VO) selectByPk("payr0306DAO.selectPayr0306_S", vo);
    }

    /**
	 * PAYR0306 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0306 목록
	 * @exception Exception
	 */
    public List selectPayr0306List(Payr0306SrhVO searchVO) throws Exception {
        return list("payr0306DAO.selectPayr0306List_D", searchVO);
    }

    /**
	 * PAYR0306 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0306 총 갯수
	 * @exception
	 */
    public int selectPayr0306ListTotCnt(Payr0306SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0306DAO.selectPayr0306ListTotCnt_S", searchVO);
    }

}
