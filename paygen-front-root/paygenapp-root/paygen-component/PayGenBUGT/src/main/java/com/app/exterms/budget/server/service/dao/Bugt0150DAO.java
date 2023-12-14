package com.app.exterms.budget.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.budget.server.vo.Bugt0150SrhVO;
import com.app.exterms.budget.server.vo.Bugt0150VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bugt0150DAO.java
 * @Description : Bugt0150 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("bugt0150DAO")
public class Bugt0150DAO extends EgovAbstractDAO {

	/**
	 * BUGT0150을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bugt0150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBugt0150(Bugt0150VO vo) throws Exception {
        return (String)insert("bugt0150DAO.insertBugt0150_S", vo);
    }

    /**
	 * BUGT0150을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bugt0150VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBugt0150(Bugt0150VO vo) throws Exception {
        update("bugt0150DAO.updateBugt0150_S", vo);
    }

    /**
	 * BUGT0150을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bugt0150VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBugt0150(Bugt0150VO vo) throws Exception {
        delete("bugt0150DAO.deleteBugt0150_S", vo);
    }

    /**
	 * BUGT0150을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bugt0150VO
	 * @return 조회한 BUGT0150
	 * @exception Exception
	 */
    public Bugt0150VO selectBugt0150(Bugt0150VO vo) throws Exception {
        return (Bugt0150VO) selectByPk("bugt0150DAO.selectBugt0150_S", vo);
    }

    /**
	 * BUGT0150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0150 목록
	 * @exception Exception
	 */
    public List selectBugt0150List(Bugt0150SrhVO searchVO) throws Exception {
        return list("bugt0150DAO.selectBugt0150List_D", searchVO);
    }

    /**
	 * BUGT0150 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0150 총 갯수
	 * @exception
	 */
    public int selectBugt0150ListTotCnt(Bugt0150SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bugt0150DAO.selectBugt0150ListTotCnt_S", searchVO);
    }

}
