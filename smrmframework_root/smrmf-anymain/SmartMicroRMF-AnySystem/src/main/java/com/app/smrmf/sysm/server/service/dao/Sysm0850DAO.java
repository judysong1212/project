package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm0850SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0850VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0850DAO.java
 * @Description : Sysm0850 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0850DAO")
public class Sysm0850DAO extends EgovAbstractDAO {

	/**
	 * SYSM0850을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sysm0850VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSysm0850(SysIfSysm0850VO vo) throws Exception {
        return (String)insert("sysm0850DAO.insertSysm0850_S", vo);
    }

    /**
	 * SYSM0850을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sysm0850VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSysm0850(SysIfSysm0850VO vo) throws Exception {
        update("sysm0850DAO.updateSysm0850_S", vo);
    }

    /**
	 * SYSM0850을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sysm0850VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSysm0850(SysIfSysm0850VO vo) throws Exception {
        delete("sysm0850DAO.deleteSysm0850_S", vo);
    }

    /**
	 * SYSM0850을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0850VO
	 * @return 조회한 SYSM0850
	 * @exception Exception
	 */
    public SysIfSysm0850VO selectSysm0850(SysIfSysm0850VO vo) throws Exception {
        return (SysIfSysm0850VO) selectByPk("sysm0850DAO.selectSysm0850_S", vo);
    }

    /**
	 * SYSM0850 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0850 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0850List(SysIfSysm0850SrhVO searchVO) throws Exception {
        return list("sysm0850DAO.selectSysm0850List_D", searchVO);
    }

    /**
	 * SYSM0850 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0850 총 갯수
	 * @exceptions
	 */
    public int selectSysm0850ListTotCnt(SysIfSysm0850SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0850DAO.selectSysm0850ListTotCnt_S", searchVO);
    }

}
