package com.app.exterms.budget.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.budget.server.vo.Bugt0100SrhVO;
import com.app.exterms.budget.server.vo.Bugt0100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bugt0100DAO.java
 * @Description : Bugt0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("bugt0100DAO")
public class Bugt0100DAO extends EgovAbstractDAO {

	/**
	 * BUGT0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bugt0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBugt0100(Bugt0100VO vo) throws Exception {
        return (String)insert("bugt0100DAO.insertBugt0100_S", vo);
    }

    /**
	 * BUGT0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bugt0100VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBugt0100(Bugt0100VO vo) throws Exception {
        update("bugt0100DAO.updateBugt0100_S", vo);
    }

    /**
	 * BUGT0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bugt0100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBugt0100(Bugt0100VO vo) throws Exception {
        delete("bugt0100DAO.deleteBugt0100_S", vo);
    }

    /**
	 * BUGT0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bugt0100VO
	 * @return 조회한 BUGT0100
	 * @exception Exception
	 */
    public Bugt0100VO selectBugt0100(Bugt0100VO vo) throws Exception {
        return (Bugt0100VO) selectByPk("bugt0100DAO.selectBugt0100_S", vo);
    }

    /**
	 * BUGT0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0100 목록
	 * @exception Exception
	 */
    public List selectBugt0100List(Bugt0100SrhVO searchVO) throws Exception {
        return list("bugt0100DAO.selectBugt0100List_D", searchVO);
    }

    /**
	 * BUGT0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0100 총 갯수
	 * @exception
	 */
    public int selectBugt0100ListTotCnt(Bugt0100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bugt0100DAO.selectBugt0100ListTotCnt_S", searchVO);
    }

}
