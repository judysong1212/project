package com.app.smrmf.infc.sysauth.system.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.sysauth.system.server.vo.InfcPkgSysm0100SrhVO;
import com.app.smrmf.infc.sysauth.system.server.vo.InfcPkgSysm0100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0100DAO.java
 * @Description : Sysm0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgSysm0100DAO")
public class InfcPkgSysm0100DAO extends EgovAbstractDAO {

	 /**
     * Sysm0100 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Sysm0100 목록
     * @exception Exception
     */
    public List selectYeta2080ToSysm0100List(InfcPkgSysm0100SrhVO searchVO) throws Exception {
    	return list("InfcPkgSysm0100DAO.selectYeta2080ToSysm0100List_D", searchVO);
    }
    
    /**
     * Sysm0100 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Sysm0100 총 갯수
     * @exception
     */
    public int selectYeta2080ToSysm0100ListCnt(InfcPkgSysm0100SrhVO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("InfcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt_S", searchVO);
    }
    
    
    public int updaetYeta2080ToSysm0100Yn(InfcPkgSysm0100VO infcPkgSysm0100Vo) throws Exception {
    	return update("InfcPkgSysm0100DAO.updaetYeta2080ToSysm0100Yn", infcPkgSysm0100Vo);
    } 
    

}
