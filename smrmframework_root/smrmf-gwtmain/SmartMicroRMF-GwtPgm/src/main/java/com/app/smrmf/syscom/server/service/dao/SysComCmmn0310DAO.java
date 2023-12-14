package com.app.smrmf.syscom.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.Cmmn0310SrhVO;
import com.app.smrmf.sysm.server.service.vo.Cmmn0310VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Cmmn0310DAO.java
 * @Description : Cmmn0310 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysComCmmn0310DAO")
public class SysComCmmn0310DAO extends EgovAbstractDAO {

	/**
	 * CMMN0310을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Cmmn0310VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertCmmn0310(Cmmn0310VO vo) throws Exception {
        return (String)insert("msfCmmn0310DAO.insertCmmn0310_S", vo);
    }

    /**
	 * CMMN0310을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Cmmn0310VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateCmmn0310(Cmmn0310VO vo) throws Exception {
        update("msfCmmn0310DAO.updateCmmn0310_S", vo);
    }

    /**
	 * CMMN0310을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Cmmn0310VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteCmmn0310(Cmmn0310VO vo) throws Exception {
        delete("msfCmmn0310DAO.deleteCmmn0310_S", vo);
    }

    /**
	 * CMMN0310을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Cmmn0310VO
	 * @return 조회한 CMMN0310
	 * @exception Exception
	 */
    public Cmmn0310VO selectCmmn0310(Cmmn0310VO vo) throws Exception {
        return (Cmmn0310VO) selectByPk("msfCmmn0310DAO.selectCmmn0310_S", vo);
    }

    /**
	 * CMMN0310 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CMMN0310 목록
	 * @exception Exception
	 */
    public List selectCmmn0310List(Cmmn0310SrhVO searchVO) throws Exception {
        return list("msfCmmn0310DAO.selectCmmn0310List_D", searchVO);
    }

    /**
	 * CMMN0310 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CMMN0310 총 갯수
	 * @exception
	 */
    public int selectCmmn0310ListTotCnt(Cmmn0310SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("msfCmmn0310DAO.selectCmmn0310ListTotCnt_S", searchVO);
    }

}
