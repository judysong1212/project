package com.app.exterms.payroll.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0540SrhVO;
import com.app.exterms.payroll.server.vo.Payr0540VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0540DAO.java
 * @Description : Payr0540 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0540DAO")
public class Payr0540DAO extends EgovAbstractDAO {
	
	public String getMaxSeilNum(HashMap<String, String> hMap){
		return (String)selectByPk("payr0540DAO.getMaxSeilNum", hMap);
	}
		
	
	/**
	 * PAYR0540을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0540VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertPayr0540(Payr0540VO vo) throws Exception {
        return (String)insert("payr0540DAO.insertPayr0540_S", vo);
    }

    /**
	 * PAYR0540을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0540VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updatePayr0540(Payr0540VO vo) throws Exception {
        update("payr0540DAO.updatePayr0540_S", vo);
    }

    /**
	 * PAYR0540을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0540VO
	 * @return void형 
	 * @exception Exception
	 */
	@Transactional
    public void deletePayr0540(Payr0540VO vo) throws Exception {
        delete("payr0540DAO.deletePayr0540_S", vo);
    }

    /**
	 * PAYR0540을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0540VO
	 * @return 조회한 PAYR0540
	 * @exception Exception
	 */
    public Payr0540VO selectPayr0540(Payr0540VO vo) throws Exception {
        return (Payr0540VO) selectByPk("payr0540DAO.selectPayr0540_S", vo);
    }

    /**
	 * PAYR0540 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0540 목록
	 * @exception Exception
	 */
    public List selectPayr0540List(Payr0540SrhVO searchVO) throws Exception {
        return list("payr0540DAO.selectPayr0540List_D", searchVO);
    }

    /**
	 * PAYR0540 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0540 총 갯수
	 * @exception
	 */
    public int selectPayr0540ListTotCnt(Payr0540SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0540DAO.selectPayr0540ListTotCnt_S", searchVO);
    }

}
