package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.prgm.server.vo.PrgmComBass0120SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0120DAO.java
 * @Description : Bass0120 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComBass0120DAO")
public class PrgmComBass0120DAO extends EgovAbstractDAO {
	
 
    /**
	 * BASS0120 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0120 목록
	 * @exception Exception
	 */
	  public List selectBass0120List(PrgmComBass0120SrhVO searchVO) throws Exception {
	        return list("prgmComBass0120DAO.selectPrgmBass0120List_D", searchVO);
	    }

    /**
	 * BASS0120 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0120 총 갯수
	 * @exception
	 */
    public int selectBass0120ListTotCnt(PrgmComBass0120SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0120DAO.selectPrgmBass0120ListTotCnt_S", searchVO);
    }

  
}
