package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm0700SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0700VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0700DAO.java
 * @Description : Sysm0700 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0700DAO")
public class Sysm0700DAO extends EgovAbstractDAO {

	/**
	 * SYSM0700을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sysm0700VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSysm0700(SysIfSysm0700VO vo) throws Exception {
        return (String)insert("sysm0700DAO.insertSysm0700_S", vo);
    }

    /**
	 * SYSM0700을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sysm0700VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSysm0700(SysIfSysm0700VO vo) throws Exception {
        update("sysm0700DAO.updateSysm0700_S", vo);
    }

    /**
	 * SYSM0700을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sysm0700VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSysm0700(SysIfSysm0700VO vo) throws Exception {
        delete("sysm0700DAO.deleteSysm0700_S", vo);
    }

    /**
	 * SYSM0700을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0700VO
	 * @return 조회한 SYSM0700
	 * @exception Exception
	 */
    public SysIfSysm0700VO selectSysm0700(SysIfSysm0700VO vo) throws Exception {
        return (SysIfSysm0700VO) selectByPk("sysm0700DAO.selectSysm0700_S", vo);
    }

    /**
	 * SYSM0700 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0700 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0700List(SysIfSysm0700SrhVO searchVO) throws Exception {
        return list("sysm0700DAO.selectSysm0700List_D", searchVO);
    }

    /**
	 * SYSM0700 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0700 총 갯수
	 * @exception
	 */
    public int selectSysm0700ListTotCnt(SysIfSysm0700SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0700DAO.selectSysm0700ListTotCnt_S", searchVO);
    }
    
    /**
	 * SYSM0700 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0700 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0700ToSysm0700List(SysIfSysm0700SrhVO searchVO) throws Exception {
        return list("sysm0700DAO.selectSysm0700ToSysm0700List_D", searchVO);
    }

    /**
	 * SYSM0700 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0700 총 갯수
	 * @exception
	 */
    public int selectSysm0700ToSysm0700ListTotCnt(SysIfSysm0700SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0700DAO.selectSysm0700ToSysm0700ListTotCnt_S", searchVO);
    }
     
    
    

}
