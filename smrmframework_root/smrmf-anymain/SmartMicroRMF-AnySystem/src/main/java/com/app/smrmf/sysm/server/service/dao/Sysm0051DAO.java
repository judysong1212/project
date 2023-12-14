package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm0051SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0051VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0051DAO.java
 * @Description : Sysm0051 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0051DAO")
public class Sysm0051DAO extends EgovAbstractDAO {

	/**
	 * SYSM0051을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sysm0051VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSysm0051(SysIfSysm0051VO vo) throws Exception {
        return (String)insert("sysm0051DAO.insertSysm0051_S", vo);
    }

    /**
	 * SYSM0051을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sysm0051VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSysm0051(SysIfSysm0051VO vo) throws Exception {
        update("sysm0051DAO.updateSysm0051_S", vo);
    }

    /**
	 * SYSM0051을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sysm0051VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSysm0051(SysIfSysm0051VO vo) throws Exception {
        delete("sysm0051DAO.deleteSysm0051_S", vo);
    }

    /**
	 * SYSM0051을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0051VO
	 * @return 조회한 SYSM0051
	 * @exception Exception
	 */
    public SysIfSysm0051VO selectSysm0051(SysIfSysm0051VO vo) throws Exception {
        return (SysIfSysm0051VO) selectByPk("sysm0051DAO.selectSysm0051_S", vo);
    }

    /**
	 * SYSM0051 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0051 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0051List(SysIfSysm0051SrhVO searchVO) throws Exception {
        return list("sysm0051DAO.selectSysm0051List_D", searchVO);
    }

    /**
	 * SYSM0051 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0051 총 갯수
	 * @exception
	 */
    public int selectSysm0051ListTotCnt(SysIfSysm0051SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0051DAO.selectSysm0051ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * PAYR0304 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0051 총 갯수
	 * @exception
	 */
    public int selectSysmMtrToPayr0304ListTotCnt(SysIfSysm0051SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0051DAO.selectPayr0304ListTotCnt_S", searchVO);
    }


}
