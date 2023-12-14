package com.app.exterms.budget.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.budget.server.vo.Bugt0200SrhVO;
import com.app.exterms.budget.server.vo.Bugt0200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bugt0200DAO.java
 * @Description : Bugt0200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("bugt0200DAO")
public class Bugt0200DAO extends EgovAbstractDAO {

	/**
	 * BUGT0200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bugt0200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBugt0200(Bugt0200VO vo) throws Exception {
        return (String)insert("bugt0200DAO.insertBugt0200_S", vo);
    }

    /**
	 * BUGT0200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bugt0200VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBugt0200(Bugt0200VO vo) throws Exception {
        update("bugt0200DAO.updateBugt0200_S", vo);
    }

    /**
	 * BUGT0200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bugt0200VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBugt0200(Bugt0200VO vo) throws Exception {
        delete("bugt0200DAO.deleteBugt0200_S", vo);
    }

    /**
	 * BUGT0200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bugt0200VO
	 * @return 조회한 BUGT0200
	 * @exception Exception
	 */
    public Bugt0200VO selectBugt0200(Bugt0200VO vo) throws Exception {
        return (Bugt0200VO) selectByPk("bugt0200DAO.selectBugt0200_S", vo);
    }

    /**
	 * BUGT0200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0200 목록
	 * @exception Exception
	 */
    public List selectBugt0200List(Bugt0200SrhVO searchVO) throws Exception {
        return list("bugt0200DAO.selectBugt0200List_D", searchVO);
    }

    /**
	 * BUGT0200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0200 총 갯수
	 * @exception
	 */
    public int selectBugt0200ListTotCnt(Bugt0200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bugt0200DAO.selectBugt0200ListTotCnt_S", searchVO);
    }

}
