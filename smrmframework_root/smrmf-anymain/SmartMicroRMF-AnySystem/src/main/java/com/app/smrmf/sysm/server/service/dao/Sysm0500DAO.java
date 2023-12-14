package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.vo.SysIfSysm0500SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0500DAO.java
 * @Description : Sysm0500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0500DAO")
public class Sysm0500DAO extends EgovAbstractDAO {

	/**
	 * SYSM0500을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sysm0500VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertSysm0500(SysIfSysm0500VO vo) throws Exception {
        return (String)insert("sysm0500DAO.insertSysm0500_S", vo);
    }

    /**
	 * SYSM0500을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sysm0500VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateSysm0500(SysIfSysm0500VO vo) throws Exception {
        update("sysm0500DAO.updateSysm0500_S", vo);
    }

    /**
	 * SYSM0500을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sysm0500VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteSysm0500(SysIfSysm0500VO vo) throws Exception {
        delete("sysm0500DAO.deleteSysm0500_S", vo);
    }

    /**
	 * SYSM0500을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0500VO
	 * @return 조회한 SYSM0500
	 * @exception Exception
	 */
    public SysIfSysm0500VO selectSysm0500(SysIfSysm0500VO vo) throws Exception {
        return (SysIfSysm0500VO) selectByPk("sysm0500DAO.selectSysm0500_S", vo);
    }

    /**
	 * SYSM0500 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0500 목록
	 * @exception Exception
	 */
    public List selectSysm0500List(SysIfSysm0500SrhVO searchVO) throws Exception {
        return list("sysm0500DAO.selectSysm0500List_D", searchVO);
    }

    /**
	 * SYSM0500 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0500 총 갯수
	 * @exception
	 */
    public int selectSysm0500ListTotCnt(SysIfSysm0500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0500DAO.selectSysm0500ListTotCnt_S", searchVO);
    }

}
