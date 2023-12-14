package com.app.exterms.budget.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.budget.server.vo.Bugt0050SrhVO;
import com.app.exterms.budget.server.vo.Bugt0050VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bugt0050DAO.java
 * @Description : Bugt0050 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("bugt0050DAO")
public class Bugt0050DAO extends EgovAbstractDAO {

	/**
	 * BUGT0050을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bugt0050VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBugt0050(Bugt0050VO vo) throws Exception {
        return (String)insert("bugt0050DAO.insertBugt0050_S", vo);
    }

    /**
	 * BUGT0050을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bugt0050VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBugt0050(Bugt0050VO vo) throws Exception {
        update("bugt0050DAO.updateBugt0050_S", vo);
    }

    /**
	 * BUGT0050을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bugt0050VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBugt0050(Bugt0050VO vo) throws Exception {
        delete("bugt0050DAO.deleteBugt0050_S", vo);
    }

    /**
	 * BUGT0050을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bugt0050VO
	 * @return 조회한 BUGT0050
	 * @exception Exception
	 */
    public Bugt0050VO selectBugt0050(Bugt0050VO vo) throws Exception {
        return (Bugt0050VO) selectByPk("bugt0050DAO.selectBugt0050_S", vo);
    }

    /**
	 * BUGT0050 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0050 목록
	 * @exception Exception
	 */
    public List selectBugt0050List(Bugt0050SrhVO searchVO) throws Exception {
        return list("bugt0050DAO.selectBugt0050List_D", searchVO);
    }

    /**
	 * BUGT0050 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BUGT0050 총 갯수
	 * @exception
	 */
    public int selectBugt0050ListTotCnt(Bugt0050SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bugt0050DAO.selectBugt0050ListTotCnt_S", searchVO);
    }

}
