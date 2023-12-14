package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0999DefaultVO;
import com.app.exterms.personal.server.vo.Psnl0999VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0999DAO.java
 * @Description : Psnl0999 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0999DAO")
public class Psnl0999DAO extends EgovAbstractDAO {

	/**
	 * PSNL0999을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0999VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0999(Psnl0999VO vo) throws Exception {
        return (String)insert("psnl0999DAO.insertPsnl0999_S", vo);
    }

    /**
	 * PSNL0999을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0999VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePsnl0999(Psnl0999VO vo) throws Exception {
        update("psnl0999DAO.updatePsnl0999_S", vo);
    }

    /**
	 * PSNL0999을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0999VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePsnl0999(Psnl0999VO vo) throws Exception {
        delete("psnl0999DAO.deletePsnl0999_S", vo);
    }

    /**
	 * PSNL0999을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0999VO
	 * @return 조회한 PSNL0999
	 * @exception Exception
	 */
    public Psnl0999VO selectPsnl0999(Psnl0999VO vo) throws Exception {
        return (Psnl0999VO) selectByPk("psnl0999DAO.selectPsnl0999_S", vo);
    }

    /**
	 * PSNL0999 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0999 목록
	 * @exception Exception
	 */
    public List selectPsnl0999List(Psnl0999DefaultVO searchVO) throws Exception {
        return list("psnl0999DAO.selectPsnl0999List_D", searchVO);
    }

    /**
	 * PSNL0999 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0999 총 갯수
	 * @exception
	 */
    public int selectPsnl0999ListTotCnt(Psnl0999DefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0999DAO.selectPsnl0999ListTotCnt_S", searchVO);
    }

}
