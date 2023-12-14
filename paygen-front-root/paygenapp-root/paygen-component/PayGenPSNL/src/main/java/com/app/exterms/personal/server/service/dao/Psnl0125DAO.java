package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0125DefaultVO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0125VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0125DAO.java
 * @Description : Psnl0125 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0125DAO")
public class Psnl0125DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public String insertPsnl0125(HashMap hMap) throws Exception {
		return (String)insert("psnl0125DAO.insertPsnl0125", hMap);
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public int updatePsnl0125(HashMap hMap) throws Exception {
		return update("psnl0125DAO.updatePsnl0125", hMap);
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public int deletePsnl0125(HashMap hMap) throws Exception {
		return delete("psnl0125DAO.deletePsnl0125", hMap);
	}
	
	
	/**
	 * PSNL0125을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0125VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertPsnl0125_S(InfcPkgPsnl0125VO vo) throws Exception {
        return (String)insert("psnl0125DAO.insertPsnl0125_S", vo);
    }

    /**
	 * PSNL0125을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0125VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updatePsnl0125_S(InfcPkgPsnl0125VO vo) throws Exception {
        update("psnl0125DAO.updatePsnl0125_S", vo);
    }

    /**
	 * PSNL0125을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0125VO
	 * @return void형 
	 * @exception Exception
	 */
	@Transactional
    public void deletePsnl0125_S(InfcPkgPsnl0125VO vo) throws Exception {
        delete("psnl0125DAO.deletePsnl0125_S", vo);
    }

    /**
	 * PSNL0125을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0125VO
	 * @return 조회한 PSNL0125
	 * @exception Exception
	 */
    public InfcPkgPsnl0125VO selectPsnl0125(InfcPkgPsnl0125VO vo) throws Exception {
        return (InfcPkgPsnl0125VO) selectByPk("psnl0125DAO.selectPsnl0125_S", vo);
    }

    /**
	 * PSNL0125 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0125 목록
	 * @exception Exception
	 */
    public List selectPsnl0125List(Psnl0125DefaultVO searchVO) throws Exception {
        return list("psnl0125DAO.selectPsnl0125List_D", searchVO);
    }

    /**
	 * PSNL0125 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0125 총 갯수
	 * @exception
	 */
    public int selectPsnl0125ListTotCnt(Psnl0125DefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0125DAO.selectPsnl0125ListTotCnt_S", searchVO);
    }

}
