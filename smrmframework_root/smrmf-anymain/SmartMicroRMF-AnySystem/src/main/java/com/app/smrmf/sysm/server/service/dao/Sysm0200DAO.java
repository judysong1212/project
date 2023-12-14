package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.vo.SysIfSysm0200SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0200DAO.java
 * @Description : Sysm0200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0200DAO")
public class Sysm0200DAO extends EgovAbstractDAO {

	/**
	 * SYSM0200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sysm0200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertSysm0200(SysIfSysm0200VO vo) throws Exception {
        return (String)insert("sysm0200DAO.insertSysm0200_S", vo);
    }

    /**
	 * SYSM0200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sysm0200VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateSysm0200(SysIfSysm0200VO vo) throws Exception {
        update("sysm0200DAO.updateSysm0200_S", vo);
    }

    /**
	 * SYSM0200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sysm0200VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteSysm0200(SysIfSysm0200VO vo) throws Exception {
        delete("sysm0200DAO.deleteSysm0200_S", vo);
    }

    /**
	 * SYSM0200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0200VO
	 * @return 조회한 SYSM0200
	 * @exception Exception
	 */
    public SysIfSysm0200VO selectSysm0200(SysIfSysm0200VO vo) throws Exception {
        return (SysIfSysm0200VO) selectByPk("sysm0200DAO.selectSysm0200_S", vo);
    }

    /**
	 * SYSM0200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0200 목록
	 * @exception Exception
	 */
    public List selectSysm0200List(SysIfSysm0200SrhVO searchVO) throws Exception {
        return list("sysm0200DAO.selectSysm0200List_D", searchVO);
    }
    
    /**
	 * SYSM0200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0200 목록
	 * @exception Exception
	 */
    public List<SysIfSysm0200VO> selectMenuSysm0200List(SysIfSysm0200SrhVO searchVO) throws Exception {
        return list("sysm0200DAO.selectMenuSysm0200List_D", searchVO);
    }

    /**
	 * SYSM0200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0200 총 갯수
	 * @exception
	 */
    public int selectSysm0200ListTotCnt(SysIfSysm0200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0200DAO.selectSysm0200ListTotCnt_S", searchVO);
    }
    
}
