package com.app.exterms.budget.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.budget.server.vo.Bugt0250SrhVO;
import com.app.exterms.budget.server.vo.Bugt0250VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bugt0250DAO.java
 * @Description : Bugt0250 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("bugt0250DAO")
public class Bugt0250DAO extends EgovAbstractDAO {

	/**
	 * BUGT0250을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bugt0250VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBugt0250(Bugt0250VO vo) throws Exception {
        return (String)insert("bugt0250DAO.insertBugt0250_S", vo);
    }

    /**
	 * BUGT0250을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bugt0250VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBugt0250(Bugt0250VO vo) throws Exception {
        update("bugt0250DAO.updateBugt0250_S", vo);
    }

    /**
	 * BUGT0250을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bugt0250VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBugt0250(Bugt0250VO vo) throws Exception {
        delete("bugt0250DAO.deleteBugt0250_S", vo);
    }

    /**
	 * BUGT0250을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bugt0250VO
	 * @return 조회한 BUGT0250
	 * @exception Exception
	 */
    public Bugt0250VO selectBugt0250(Bugt0250VO vo) throws Exception {
        return (Bugt0250VO) selectByPk("bugt0250DAO.selectBugt0250_S", vo);
    }

    /**
	 * BUGT0250 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0250 목록
	 * @exception Exception
	 */
    public List selectBugt0250List(Bugt0250SrhVO searchVO) throws Exception {
        return list("bugt0250DAO.selectBugt0250List_D", searchVO);
    }

    /**
	 * BUGT0250 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0250 총 갯수
	 * @exception
	 */
    public int selectBugt0250ListTotCnt(Bugt0250SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bugt0250DAO.selectBugt0250ListTotCnt_S", searchVO);
    }

}
