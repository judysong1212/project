package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0303SrhVO;
import com.app.exterms.payroll.server.vo.Payr0303VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0303DAO.java
 * @Description : Payr0303 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.09.22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0303DAO")
public class Payr0303DAO extends EgovAbstractDAO {

	/**
	 * PAYR0303을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0303VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertPayr0303(Payr0303VO vo) throws Exception {
        return (String)insert("payr0303DAO.insertPayr0303_S", vo);
    }

    /**
	 * PAYR0303을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0303VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updatePayr0303(Payr0303VO vo) throws Exception {
        update("payr0303DAO.updatePayr0303_S", vo);
    }

    /**
	 * PAYR0303을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0303VO
	 * @return void형 
	 * @exception Exception
	 */
	@Transactional
    public void deletePayr0303(Payr0303VO vo) throws Exception {
        delete("payr0303DAO.deletePayr0303_S", vo);
    }
	@Transactional
    public void deletePayr4210ToPayr0303(Payr0303VO vo) throws Exception {
        delete("payr0303DAO.deletePayr4210ToPayr0303_S", vo);
    }

    /**
	 * PAYR0303을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0303VO
	 * @return 조회한 PAYR0303
	 * @exception Exception
	 */
    public Payr0303VO selectPayr0303(Payr0303VO vo) throws Exception {
        return (Payr0303VO) selectByPk("payr0303DAO.selectPayr0303_S", vo);
    }

    /**
	 * PAYR0303 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0303 목록
	 * @exception Exception
	 */
    public List<?> selectPayr0303List(Payr0303SrhVO searchVO) throws Exception {
        return list("payr0303DAO.selectPayr0303List_D", searchVO);
    }

    /**
	 * PAYR0303 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0303 총 갯수
	 * @exception
	 */
    public int selectPayr0303ListTotCnt(Payr0303SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0303DAO.selectPayr0303ListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR0303 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0303 목록
	 * @exception Exception
	 */
    public List  selectXlsPayr4220List(Payr0303SrhVO searchVO) throws Exception {
        return list("payr0303DAO.selectXlsPayr4220List_D", searchVO);
    } 
  
}
