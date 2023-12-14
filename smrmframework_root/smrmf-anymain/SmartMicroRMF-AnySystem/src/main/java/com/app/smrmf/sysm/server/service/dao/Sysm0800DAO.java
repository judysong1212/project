package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm0800SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0800VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0800DAO.java
 * @Description : Sysm0800 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0800DAO")
public class Sysm0800DAO extends EgovAbstractDAO {

	/**
	 * SYSM0800을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sysm0800VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSysm0800(SysIfSysm0800VO vo) throws Exception {
        return (String)insert("sysm0800DAO.insertSysm0800_S", vo);
    }

    /**
	 * SYSM0800을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sysm0800VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSysm0800(SysIfSysm0800VO vo) throws Exception {
        update("sysm0800DAO.updateSysm0800_S", vo);
    }

    /**
	 * SYSM0800을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sysm0800VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSysm0800(SysIfSysm0800VO vo) throws Exception {
        delete("sysm0800DAO.deleteSysm0800_S", vo);
    }

    /**
	 * SYSM0800을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0800VO
	 * @return 조회한 SYSM0800
	 * @exception Exception
	 */
    public SysIfSysm0800VO selectSysm0800(SysIfSysm0800VO vo) throws Exception {
        return (SysIfSysm0800VO) selectByPk("sysm0800DAO.selectSysm0800_S", vo);
    }

    /**
	 * SYSM0800 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0800 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0800List(SysIfSysm0800SrhVO searchVO) throws Exception {
        return list("sysm0800DAO.selectSysm0800List_D", searchVO);
    }

    /**
	 * SYSM0800 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0800 총 갯수
	 * @exception
	 */
    public int selectSysm0800ListTotCnt(SysIfSysm0800SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0800DAO.selectSysm0800ListTotCnt_S", searchVO);
    }

    
    /**
	 * SYSM0800 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0800 목록
	 * @exception Exception
	 */
    public List<?> selectSysmMtr0500ToSysm0800List(SysIfSysm0800SrhVO searchVO) throws Exception {
        return list("sysm0800DAO.selectSysmMtr0500ToSysm0800List_D", searchVO);
    }

    /**
	 * SYSM0800 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0800 총 갯수
	 * @exception
	 */
    public int selectSysmMtr0500ToSysm0800ListTotCnt(SysIfSysm0800SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0800DAO.selectSysmMtr0500ToSysm0800ListTotCnt_S", searchVO);
    }

    
    
}
