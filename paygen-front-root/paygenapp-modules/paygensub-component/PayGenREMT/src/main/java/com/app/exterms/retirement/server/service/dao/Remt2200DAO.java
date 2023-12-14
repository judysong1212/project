package com.app.exterms.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.retirement.server.vo.Remt2200SrhVO;
import com.app.exterms.retirement.server.vo.Remt2200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt2200DAO.java
 * @Description : Remt2200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Remt2200DAO")
public class Remt2200DAO extends EgovAbstractDAO {

	/**
	 * REMT2200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt2200(Remt2200VO vo) throws Exception {
        return (String)insert("remt2200DAO.insertRemt2200_S", vo);
    }

    /**
	 * REMT2200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt2200(Remt2200VO vo) throws Exception {
        update("remt2200DAO.updateRemt2200_S", vo);
    }

    /**
	 * REMT2200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt2200(Remt2200VO vo) throws Exception {
        delete("remt2200DAO.deleteRemt2200_S", vo);
    }

    /**
	 * REMT2200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2200VO
	 * @return 조회한 REMT2200
	 * @exception Exception
	 */
    public Remt2200VO selectRemt2200(Remt2200VO vo) throws Exception {
        return (Remt2200VO) selectByPk("remt2200DAO.selectRemt2200_S", vo);
    }

    /**
	 * REMT2200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2200 목록
	 * @exception Exception
	 */
    public List<?> selectRemt2200List(Remt2200SrhVO searchVO) throws Exception {
        return list("remt2200DAO.selectRemt2200List_D", searchVO);
    }

    /**
	 * REMT2200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2200 총 갯수
	 * @exception
	 */
    public int selectRemt2200ListTotCnt(Remt2200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("remt2200DAO.selectRemt2200ListTotCnt_S", searchVO);
    }

    
    /**
	 * REMT2200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2200 목록
	 * @exception Exception
	 */
    public List<?> selectRemt0100ToRemt2200List(Remt2200SrhVO searchVO) throws Exception {
        return list("remt2200DAO.selectRemt0100ToRemt2200List_D", searchVO);
    }

    /**
	 * REMT2200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2200 총 갯수
	 * @exception
	 */
    public int selectRemt0100ToRemt2200ListTotCnt(Remt2200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("remt2200DAO.selectRemt0100ToRemt2200ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * REMT2200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2200 목록
	 * @exception Exception
	 */
    public List<?> selectRemtWfep0100ToRemt2200List(Remt2200SrhVO searchVO) throws Exception {
        return list("remt2200DAO.selectRemtWfep0100ToRemt2200List_D", searchVO);
    }

    /**
	 * REMT2200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2200 총 갯수
	 * @exception
	 */
    public int selectRemtWfep0100ToRemt2200ListTotCnt(Remt2200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("remt2200DAO.selectRemtWfep0100ToRemt2200ListTotCnt_S", searchVO);
    }
    
    
}
