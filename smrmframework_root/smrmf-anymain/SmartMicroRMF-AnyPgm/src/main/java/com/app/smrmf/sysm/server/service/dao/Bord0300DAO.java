package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.Bord0300SrhVO;
import com.app.smrmf.sysm.server.service.vo.Bord0300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bord0300DAO.java
 * @Description : Bord0300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bord0300DAO")
public class Bord0300DAO extends EgovAbstractDAO {

	/**
	 * BORD0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bord0300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBord0300(Bord0300VO vo) throws Exception {
        return (String)insert("bord0300DAO.insertBord0300_S", vo);
    }

    /**
	 * BORD0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bord0300VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBord0300(Bord0300VO vo) throws Exception {
        update("bord0300DAO.updateBord0300_S", vo);
    }

    /**
	 * BORD0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bord0300VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBord0300(Bord0300VO vo) throws Exception {
        delete("bord0300DAO.deleteBord0300_S", vo);
    }

    /**
	 * BORD0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bord0300VO
	 * @return 조회한 BORD0300
	 * @exception Exception
	 */
    public Bord0300VO selectBord0300(Bord0300VO vo) throws Exception {
        return (Bord0300VO) selectByPk("bord0300DAO.selectBord0300_S", vo);
    }

    /**
	 * BORD0300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BORD0300 목록
	 * @exception Exception
	 */
    public List selectBord0300List(Bord0300SrhVO searchVO) throws Exception {
        return list("bord0300DAO.selectBord0300List_D", searchVO);
    }

    /**
	 * BORD0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BORD0300 총 갯수
	 * @exception
	 */
    public int selectBord0300ListTotCnt(Bord0300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bord0300DAO.selectBord0300ListTotCnt_S", searchVO);
    }

    /**
     * BORD0300 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BORD0300 목록
     * @exception Exception
     */
    public List selectBord0300ViewList(Bord0300SrhVO searchVO) throws Exception {
        return list("bord0300DAO.selectBord0300ViewList_D", searchVO);
    }

    /**
     * BORD0300 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BORD0300 총 갯수
     * @exception
     */
    public int selectBord0300ViewListTotCnt(Bord0300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bord0300DAO.selectBord0300ViewListTotCnt_S", searchVO);
    }

    
}
