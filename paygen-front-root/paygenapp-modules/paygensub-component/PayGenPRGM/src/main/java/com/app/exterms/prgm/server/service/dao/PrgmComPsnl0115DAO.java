package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.prgm.server.vo.PrgmComPsnl0115SrhVO;
import com.app.exterms.prgm.server.vo.PrgmComPsnl0115VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0115DAO.java
 * @Description : Psnl0115 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.09.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComPsnl0115DAO")
public class PrgmComPsnl0115DAO extends EgovAbstractDAO {

	/**
	 * PSNL0115을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0115VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0115(PrgmComPsnl0115VO vo) throws Exception {
        return (String)insert("prgmComPsnl0115DAO.insertPsnl0115_S", vo);
    }

    /**
	 * PSNL0115을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0115VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePsnl0115(PrgmComPsnl0115VO vo) throws Exception {
        update("prgmComPsnl0115DAO.updatePsnl0115_S", vo);
    }

    /**
	 * PSNL0115을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0115VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePsnl0115(PrgmComPsnl0115VO vo) throws Exception {
        delete("prgmComPsnl0115DAO.deletePsnl0115_S", vo);
    }

    /**
	 * PSNL0115을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0115VO
	 * @return 조회한 PSNL0115
	 * @exception Exception
	 */
    public PrgmComPsnl0115VO selectPsnl0115(PrgmComPsnl0115VO vo) throws Exception {
        return (PrgmComPsnl0115VO) selectByPk("prgmComPsnl0115DAO.selectPsnl0115_S", vo);
    }

    /**
	 * PSNL0115 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0115 목록
	 * @exception Exception
	 */
    public List selectPsnl0115List(PrgmComPsnl0115SrhVO searchVO) throws Exception {
        return list("prgmComPsnl0115DAO.selectPsnl0115List_D", searchVO);
    }

    /**
	 * PSNL0115 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0115 총 갯수
	 * @exception
	 */
    public int selectPsnl0115ListTotCnt(PrgmComPsnl0115SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPsnl0115DAO.selectPsnl0115ListTotCnt_S", searchVO);
    }

}
