package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0220SrhVO;
import com.app.exterms.payroll.server.vo.Payr0220VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0220DAO.java
 * @Description : Payr0220 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0220DAO")
public class Payr0220DAO extends EgovAbstractDAO {

	/**
	 * PAYR0220을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0220VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0220(Payr0220VO vo) throws Exception {
        return (String)insert("payr0220DAO.insertPayr0220_S", vo);
    }

    /**
	 * PAYR0220을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0220VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0220(Payr0220VO vo) throws Exception {
        update("payr0220DAO.updatePayr0220_S", vo);
    }

    /**
	 * PAYR0220을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0220VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0220(Payr0220VO vo) throws Exception {
        delete("payr0220DAO.deletePayr0220_S", vo);
    }

    /**
	 * PAYR0220을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0220VO
	 * @return 조회한 PAYR0220
	 * @exception Exception
	 */
    public Payr0220VO selectPayr0220(Payr0220VO vo) throws Exception {
        return (Payr0220VO) selectByPk("payr0220DAO.selectPayr0220_S", vo);
    }

    /**
	 * PAYR0220 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0220 목록
	 * @exception Exception
	 */
    public List selectPayr0220List(Payr0220SrhVO searchVO) throws Exception {
        return list("payr0220DAO.selectPayr0220List_D", searchVO);
    }

    /**
	 * PAYR0220 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0220 총 갯수
	 * @exception
	 */
    public int selectPayr0220ListTotCnt(Payr0220SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0220DAO.selectPayr0220ListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR0220 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0220 목록
	 * @exception Exception
	 */
    public List selectPayr0220ToPayr4100List(Payr0220SrhVO searchVO) throws Exception {
        return list("payr0220DAO.selectPayr0220ToPayr4100List_D", searchVO);
    }

    /**
	 * PAYR0220 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0220 총 갯수
	 * @exception
	 */
    public int selectPayr0220ToPayr4100ListTotCnt(Payr0220SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0220DAO.selectPayr0220ToPayr4100ListTotCnt_S", searchVO);
    }
    
    

}
