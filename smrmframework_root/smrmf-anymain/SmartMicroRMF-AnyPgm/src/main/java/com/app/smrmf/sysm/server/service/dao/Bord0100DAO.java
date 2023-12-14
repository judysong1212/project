package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.Bord0100SrhVO;
import com.app.smrmf.sysm.server.service.vo.Bord0100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bord0100DAO.java
 * @Description : Bord0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bord0100DAO")
public class Bord0100DAO extends EgovAbstractDAO {

	/**
	 * BORD0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bord0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBord0100(Bord0100VO vo) throws Exception {
        return (String)insert("bord0100DAO.insertBord0100_S", vo);
    }

    /**
	 * BORD0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bord0100VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBord0100(Bord0100VO vo) throws Exception {
        update("bord0100DAO.updateBord0100_S", vo);
    }

    /**
	 * BORD0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bord0100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBord0100(Bord0100VO vo) throws Exception {
        delete("bord0100DAO.deleteBord0100_S", vo);
    }

    /**
	 * BORD0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bord0100VO
	 * @return 조회한 BORD0100
	 * @exception Exception
	 */
    public Bord0100VO selectBord0100(Bord0100VO vo) throws Exception {
        return (Bord0100VO) selectByPk("bord0100DAO.selectBord0100_S", vo);
    }

    /**
	 * BORD0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BORD0100 목록
	 * @exception Exception
	 */
    public List selectBord0100List(Bord0100SrhVO searchVO) throws Exception {
        return list("bord0100DAO.selectBord0100List_D", searchVO);
    }

    /**
	 * BORD0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BORD0100 총 갯수
	 * @exception
	 */
    public int selectBord0100ListTotCnt(Bord0100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bord0100DAO.selectBord0100ListTotCnt_S", searchVO);
    }

}
