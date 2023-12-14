package com.app.exterms.budget.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.budget.server.vo.Bugt0010SrhVO;
import com.app.exterms.budget.server.vo.Bugt0010VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bugt0010DAO.java
 * @Description : Bugt0010 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("bugt0010DAO")
public class Bugt0010DAO extends EgovAbstractDAO {

	/**
	 * BUGT0010을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bugt0010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBugt0010(Bugt0010VO vo) throws Exception {
        return (String)insert("bugt0010DAO.insertBugt0010_S", vo);
    }

    /**
	 * BUGT0010을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bugt0010VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBugt0010(Bugt0010VO vo) throws Exception {
        update("bugt0010DAO.updateBugt0010_S", vo);
    }

    /**
	 * BUGT0010을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bugt0010VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBugt0010(Bugt0010VO vo) throws Exception {
        delete("bugt0010DAO.deleteBugt0010_S", vo);
    }

    /**
	 * BUGT0010을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bugt0010VO
	 * @return 조회한 BUGT0010
	 * @exception Exception
	 */
    public Bugt0010VO selectBugt0010(Bugt0010VO vo) throws Exception {
        return (Bugt0010VO) selectByPk("bugt0010DAO.selectBugt0010_S", vo);
    }

    /**
	 * BUGT0010 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0010 목록
	 * @exception Exception
	 */
    public List selectBugt0010List(Bugt0010SrhVO searchVO) throws Exception {
        return list("bugt0010DAO.selectBugt0010List_D", searchVO);
    }

    /**
	 * BUGT0010 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0010 총 갯수
	 * @exception
	 */
    public int selectBugt0010ListTotCnt(Bugt0010SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bugt0010DAO.selectBugt0010ListTotCnt_S", searchVO);
    }

}
