package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0450SrhVO;
import com.app.exterms.payroll.server.vo.Payr0450VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0450DAO.java
 * @Description : Payr0450 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0450DAO")
public class Payr0450DAO extends EgovAbstractDAO {

	/**
	 * PAYR0450을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0450VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0450(Payr0450VO vo) throws Exception {
        return (String)insert("payr0450DAO.insertPayr0450_S", vo);
    }

    /**
	 * PAYR0450을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0450VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0450(Payr0450VO vo) throws Exception {
        update("payr0450DAO.updatePayr0450_S", vo);
    }

    /**
	 * PAYR0450을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0450VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0450(Payr0450VO vo) throws Exception {
        delete("payr0450DAO.deletePayr0450_S", vo);
    }

    /**
	 * PAYR0450을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0450VO
	 * @return 조회한 PAYR0450
	 * @exception Exception
	 */
    public Payr0450VO selectPayr0450(Payr0450VO vo) throws Exception {
        return (Payr0450VO) selectByPk("payr0450DAO.selectPayr0450_S", vo);
    }

    
    public Payr0450VO selectPayr0450ToPayr4100(Payr0450VO vo) throws Exception {
        return (Payr0450VO) selectByPk("payr0450DAO.selectPayr0450ToPayr4100_S", vo);
    }

    
    
    /**
	 * PAYR0450 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0450 목록
	 * @exception Exception
	 */
    public List selectPayr0450List(Payr0450SrhVO searchVO) throws Exception {
        return list("payr0450DAO.selectPayr0450List_D", searchVO);
    }

    /**
	 * PAYR0450 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0450 총 갯수
	 * @exception
	 */
    public int selectPayr0450ListTotCnt(Payr0450SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0450DAO.selectPayr0450ListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR0450 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0450 목록
	 * @exception Exception
	 */
    public List selectPayr0450ToPayr5600List(Payr0450SrhVO searchVO) throws Exception {
        return list("payr0450DAO.selectPayr0450ToPayr5600List_D", searchVO);
    }

    /**
	 * PAYR0450 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0450 총 갯수
	 * @exception
	 */
    public int selectPayr0450ToPayr5600ListTotCnt(Payr0450SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0450DAO.selectPayr0450ToPayr5600ListTotCnt_S", searchVO);
    }
    
    

}
