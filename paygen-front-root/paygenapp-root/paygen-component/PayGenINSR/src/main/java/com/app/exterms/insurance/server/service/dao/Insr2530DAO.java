package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr2530SrhVO;
import com.app.exterms.insurance.server.vo.Insr2530VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr2530DAO.java
 * @Description : Insr2530 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr2530DAO")
public class Insr2530DAO extends EgovAbstractDAO {

	/**
	 * INSR2530을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr2530VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr2530(Insr2530VO vo) throws Exception {
        return (String)insert("insr2530DAO.insertInsr2530_S", vo);
    }

    /**
	 * INSR2530을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr2530VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr2530(Insr2530VO vo) throws Exception {
        update("insr2530DAO.updateInsr2530_S", vo);
    }

    /**
	 * INSR2530을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr2530VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr2530(Insr2530VO vo) throws Exception {
        delete("insr2530DAO.deleteInsr2530_S", vo);
    }

    /**
	 * INSR2530을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr2530VO
	 * @return 조회한 INSR2530
	 * @exception Exception
	 */
    public Insr2530VO selectInsr2530(Insr2530VO vo) throws Exception {
        return (Insr2530VO) selectByPk("insr2530DAO.selectInsr2530_S", vo);
    }

    /**
	 * INSR2530 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2530 목록
	 * @exception Exception
	 */
    public List<?> selectInsr2530List(Insr2530SrhVO searchVO) throws Exception {
        return list("insr2530DAO.selectInsr2530List_D", searchVO);
    }

    /**
	 * INSR2530 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2530 총 갯수
	 * @exception
	 */
    public int selectInsr2530ListTotCnt(Insr2530SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr2530DAO.selectInsr2530ListTotCnt_S", searchVO);
    }

}
