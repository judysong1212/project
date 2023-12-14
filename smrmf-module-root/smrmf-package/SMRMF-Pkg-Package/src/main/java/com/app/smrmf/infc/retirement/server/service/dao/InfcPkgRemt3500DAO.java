package com.app.smrmf.infc.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3500SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt3500DAO.java
 * @Description : Remt3500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgRemt3500DAO")
public class InfcPkgRemt3500DAO extends EgovAbstractDAO {

	 
    /**
     * REMT3500 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return REMT3500 목록
     * @exception Exception
     */
    public List selectPayr4100ToRemt3500List(InfcPkgRemt3500SrhVO searchVO) throws Exception {
        return list("infcPkgRemt3500DAO.selectPayr4100ToRemt3500List_D", searchVO);
    }

    /**
     * REMT3500 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return REMT3500 총 갯수
     * @exception
     */
    public int selectPayr4100ToRemt3500ListTotCnt(InfcPkgRemt3500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt3500DAO.selectPayr4100ToRemt3500ListTotCnt_S", searchVO);
    }
    
    
    

}
