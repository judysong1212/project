package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.Bord0200SrhVO;
import com.app.smrmf.sysm.server.service.vo.Bord0200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bord0200DAO.java
 * @Description : Bord0200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bord0200DAO")
public class Bord0200DAO extends EgovAbstractDAO {

	/**
	 * BORD0200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bord0200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBord0200(Bord0200VO vo) throws Exception {
        return (String)insert("bord0200DAO.insertBord0200_S", vo);
    }

    /**
	 * BORD0200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bord0200VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBord0200(Bord0200VO vo) throws Exception {
        update("bord0200DAO.updateBord0200_S", vo);
    }

    /**
	 * BORD0200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bord0200VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBord0200(Bord0200VO vo) throws Exception {
        delete("bord0200DAO.deleteBord0200_S", vo);
    }

    /**
	 * BORD0200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bord0200VO
	 * @return 조회한 BORD0200
	 * @exception Exception
	 */
    public Bord0200VO selectBord0200(Bord0200VO vo) throws Exception {
        return (Bord0200VO) selectByPk("bord0200DAO.selectBord0200_S", vo);
    }

    /**
	 * BORD0200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BORD0200 목록
	 * @exception Exception
	 */
    public List selectBord0200List(Bord0200SrhVO searchVO) throws Exception {
        return list("bord0200DAO.selectBord0200List_D", searchVO);
    }

    /**
	 * BORD0200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BORD0200 총 갯수
	 * @exception
	 */
    public int selectBord0200ListTotCnt(Bord0200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bord0200DAO.selectBord0200ListTotCnt_S", searchVO);
    }

}
