package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0310SrhVO;
import com.app.exterms.personal.server.vo.Psnl0310VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0310DAO.java
 * @Description : Psnl0310 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0310DAO")
public class Psnl0310DAO extends EgovAbstractDAO {
	
	
	/** 발령 확정 **/
	@Transactional
	public String inserPsnl0310(Psnl0310VO psnl0310Vo) throws Exception{
		return (String)insert("psnl0310DAO.inserPsnl0310", psnl0310Vo);
	}
	
	/** 발령 여부 **/
	@Transactional
	public int updatePsnl0310_APPMT_FIX_YN(Psnl0310VO psnl0310Vo) throws Exception{
		return update("psnl0310DAO.updatePsnl0310_APPMT_FIX_YN", psnl0310Vo);
	}
	

	/**
	 * PSNL0310을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0310VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0310(Psnl0310VO vo) throws Exception {
        return (String)insert("psnl0310DAO.insertPsnl0310_S", vo);
    }

    /**
	 * PSNL0310을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0310VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePsnl0310(Psnl0310VO vo) throws Exception {
        update("psnl0310DAO.updatePsnl0310_S", vo);
    }

    /**
	 * PSNL0310을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0310VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePsnl0310(Psnl0310VO vo) throws Exception {
        delete("psnl0310DAO.deletePsnl0310_S", vo);
    }

    /**
	 * PSNL0310을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0310VO
	 * @return 조회한 PSNL0310
	 * @exception Exception
	 */
    public Psnl0310VO selectPsnl0310(Psnl0310VO vo) throws Exception {
        return (Psnl0310VO) selectByPk("psnl0310DAO.selectPsnl0310_S", vo);
    }

    /**
	 * PSNL0310 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0310 목록
	 * @exception Exception
	 */
    public List selectPsnl0310List(Psnl0310SrhVO searchVO) throws Exception {
        return list("psnl0310DAO.selectPsnl0310List_D", searchVO);
    }

    /**
	 * PSNL0310 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0310 총 갯수
	 * @exception
	 */
    public int selectPsnl0310ListTotCnt(Psnl0310SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0310DAO.selectPsnl0310ListTotCnt_S", searchVO);
    }

}
