package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0130SrhVO;
import com.app.exterms.personal.server.vo.Psnl0130VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0130DAO.java
 * @Description : Psnl0130 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014/07/31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Psnl0130DAO")
public class Psnl0130DAO extends EgovAbstractDAO {

	/**
	 * PSNL0130을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0130VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0130(Psnl0130VO vo) throws Exception {
        return (String)insert("psnl0130DAO.insertPsnl0130_S", vo);
    }

    /**
	 * PSNL0130을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0130VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePsnl0130(Psnl0130VO vo) throws Exception {
        update("psnl0130DAO.updatePsnl0130_S", vo);
    }

    /**
	 * PSNL0130을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0130VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePsnl0130(Psnl0130VO vo) throws Exception {
        delete("psnl0130DAO.deletePsnl0130_S", vo);
    }

    /**
	 * PSNL0130을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0130VO
	 * @return 조회한 PSNL0130
	 * @exception Exception
	 */
    public Psnl0130VO selectPsnl0130(Psnl0130VO vo) throws Exception {
        return (Psnl0130VO) selectByPk("psnl0130DAO.selectPsnl0130_S", vo);
    }

    /**
	 * PSNL0130 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0130 목록
	 * @exception Exception
	 */
    public List selectPsnl0130List(Psnl0130SrhVO searchVO) throws Exception {
        return list("psnl0130DAO.selectPsnl0130List_D", searchVO);
    }

    /**
	 * PSNL0130 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0130 총 갯수
	 * @exception
	 */
    public int selectPsnl0130ListTotCnt(Psnl0130SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0130DAO.selectPsnl0130ListTotCnt_S", searchVO);
    }

}
