package com.app.smrmf.syscom.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.SysMstr060300SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysMstr060300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : SysMstr060300DAO.java
 * @Description : SysMstr060300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysMstr060300DAO")
public class SysMstr060300DAO extends EgovAbstractDAO {

	/**
	 * MSTR_06_0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SysMstr060300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertSysMstr060300(SysMstr060300VO vo) throws Exception {
        return (String)insert("mstr060300DAO.insertSysMstr060300_S", vo);
    }

    /**
	 * MSTR_06_0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SysMstr060300VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateSysMstr060300(SysMstr060300VO vo) throws Exception {
        update("mstr060300DAO.updateSysMstr060300_S", vo);
    }

    /**
	 * MSTR_06_0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SysMstr060300VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteSysMstr060300(SysMstr060300VO vo) throws Exception {
        delete("mstr060300DAO.deleteSysMstr060300_S", vo);
    }

    /**
	 * MSTR_06_0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SysMstr060300VO
	 * @return 조회한 MSTR_06_0300
	 * @exception Exception
	 */
    public SysMstr060300VO selectSysMstr060300(SysMstr060300VO vo) throws Exception {
        return (SysMstr060300VO) selectByPk("mstr060300DAO.selectSysMstr060300_S", vo);
    }

    /**
	 * MSTR_06_0300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return MSTR_06_0300 목록
	 * @exception Exception
	 */
    public List selectSysMstr060300List(SysMstr060300SrhVO searchVO) throws Exception {
        return list("mstr060300DAO.selectSysMstr060300List_D", searchVO);
    }

    /**
	 * MSTR_06_0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return MSTR_06_0300 총 갯수
	 * @exception
	 */
    public int selectSysMstr060300ListTotCnt(SysMstr060300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("mstr060300DAO.selectSysMstr060300ListTotCnt_S", searchVO);
    }

}
