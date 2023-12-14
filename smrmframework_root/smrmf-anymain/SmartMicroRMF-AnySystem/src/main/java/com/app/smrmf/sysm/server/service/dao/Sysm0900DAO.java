package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm0900SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0900DAO.java
 * @Description : Sysm0900 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0900DAO")
public class Sysm0900DAO extends EgovAbstractDAO {

    
    /**
	 * SYSM0900 목록을 조회한다.(PSNL0100)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0900 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0900ToPsnl0100List(SysIfSysm0900SrhVO searchVO) throws Exception {
        return list("sysm0900DAO.selectSysm0900ToPsnl0100List", searchVO);
    }
    
    
    /**
	 * SYSM0900 목록을 조회한다.(PSNL0100)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0900 목록
	 * @exception Exception
	 */
    public List<?> selectXlsSysm0900ToPsnl0100List(SysIfSysm0900SrhVO searchVO) throws Exception {
        return list("sysm0900DAO.selectXlsSysm0900ToPsnl0100List", searchVO);
    }
    
    
    /**
	 * SYSM0900 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0900 총 갯수
	 * @exception
	 */
    public int selectSysm0900ToPsnl0100ListCnt(SysIfSysm0900SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0900DAO.selectSysm0900ToPsnl0100ListTotCnt_S", searchVO);
    }
    
    /**
	 * SYSM0900 목록을 조회한다.(PSNL0115)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0900 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0900ToPsnl0115List(SysIfSysm0900SrhVO searchVO) throws Exception {
        return list("sysm0900DAO.selectSysm0900ToPsnl0115List", searchVO);
    }
    
    /**
	 * SYSM0900 목록을 조회한다.(PSNL0115)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0900 목록
	 * @exception Exception
	 */
    public List<?> selectXlsSysm0900ToPsnl0115List(SysIfSysm0900SrhVO searchVO) throws Exception {
        return list("sysm0900DAO.selectXlsSysm0900ToPsnl0115List", searchVO);
    }
    
    /**
	 * SYSM0900 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0900 총 갯수
	 * @exception
	 */
    public int selectSysm0900ToPsnl0115ListCnt(SysIfSysm0900SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0900DAO.selectSysm0900ToPsnl0115ListTotCnt_S", searchVO);
    }
    

}
