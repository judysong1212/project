package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.vo.SysIfSysm0400SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0400VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0400DAO.java
 * @Description : Sysm0400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0400DAO")
public class Sysm0400DAO extends EgovAbstractDAO {

	/**
	 * SYSM0400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sysm0400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertSysm0400(SysIfSysm0400VO vo) throws Exception {
        return (String)insert("sysm0400DAO.insertSysm0400_S", vo);
    }

    /**
	 * SYSM0400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sysm0400VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateSysm0400(SysIfSysm0400VO vo) throws Exception {
        update("sysm0400DAO.updateSysm0400_S", vo);
    }

    /**
	 * SYSM0400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sysm0400VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteSysm0400(SysIfSysm0400VO vo) throws Exception {
        delete("sysm0400DAO.deleteSysm0400_S", vo);
    }

    /**
	 * SYSM0400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0400VO
	 * @return 조회한 SYSM0400
	 * @exception Exception
	 */
    public SysIfSysm0400VO selectSysm0400(SysIfSysm0400VO vo) throws Exception {
        return (SysIfSysm0400VO) selectByPk("sysm0400DAO.selectSysm0400_S", vo);
    }

    /**
	 * SYSM0400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0400 목록
	 * @exception Exception
	 */
    public List selectSysm0400List(SysIfSysm0400SrhVO searchVO) throws Exception {
        return list("sysm0400DAO.selectSysm0400List_D", searchVO);
    }

    /**
	 * SYSM0400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0400 총 갯수
	 * @exception
	 */
    public int selectSysm0400ListTotCnt(SysIfSysm0400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0400DAO.selectSysm0400ListTotCnt_S", searchVO);
    }

}
