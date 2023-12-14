package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.InfcPsnl0100SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Pyyt0304DAO.java
 * @Description : Pyyt0304 DAO Class
 * @Modification Information
 *
 * @author BaeDaEun
 * @since 2016.12.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta1100DAO")
public class Yeta1100DAO extends EgovAbstractDAO {

    /**
	 * PYYT0304 목록을 조회한다.
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0304 목록
	 * @exception Exception
	 */
    public List selectYetaP110001List(InfcPsnl0100SrhVO   psnl0100SrhVO) throws Exception {
        return list("yeta1100DAO.selectPsnl0100List_D", psnl0100SrhVO);
    }

    /**
	 * PYYT0304 총 갯수를 조회한다..
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0304  총 갯수
	 * @exception
	 */
    public int selectYetaP110001ListTotCnt(InfcPsnl0100SrhVO   psnl0100SrhVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta1100DAO.selectPsnl0100ListCnt_S", psnl0100SrhVO);
    }
    
    

}
