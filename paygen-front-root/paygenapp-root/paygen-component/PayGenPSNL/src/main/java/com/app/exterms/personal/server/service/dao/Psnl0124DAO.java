package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0124DefaultVO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0124VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0124DAO.java
 * @Description : Psnl0124 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0124DAO")
public class Psnl0124DAO extends EgovAbstractDAO {

	/**
	 * PSNL0124을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0124VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0124(InfcPkgPsnl0124VO vo) throws Exception {
        return (String)insert("psnl0124DAO.insertPsnl0124_S", vo);
    }

    /**
	 * PSNL0124을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0124VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePsnl0124(InfcPkgPsnl0124VO vo) throws Exception {
        update("psnl0124DAO.updatePsnl0124_S", vo);
    }

    /**
	 * PSNL0124을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0124VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePsnl0124(InfcPkgPsnl0124VO vo) throws Exception {
        delete("psnl0124DAO.deletePsnl0124_S", vo);
    }

    /**
	 * PSNL0124을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0124VO
	 * @return 조회한 PSNL0124
	 * @exception Exception
	 */
    public InfcPkgPsnl0124VO selectPsnl0124(InfcPkgPsnl0124VO vo) throws Exception {
        return (InfcPkgPsnl0124VO) selectByPk("psnl0124DAO.selectPsnl0124_S", vo);
    }

    /**
	 * PSNL0124 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0124 목록
	 * @exception Exception
	 */
    public List selectPsnl0124List(Psnl0124DefaultVO searchVO) throws Exception {
        return list("psnl0124DAO.selectPsnl0124List_D", searchVO);
    }

    /**
	 * PSNL0124 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0124 총 갯수
	 * @exception
	 */
    public int selectPsnl0124ListTotCnt(Psnl0124DefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0124DAO.selectPsnl0124ListTotCnt_S", searchVO);
    }

}
