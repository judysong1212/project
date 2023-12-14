package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye160402DAO.java
 * @Description : Ye160402 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe160402DAO")
public class InfcPkgYe160402DAO extends EgovAbstractDAO {
	
    /**
	 * YE160402을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3210VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String fnYeta1100_YE160402_2016_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
        return (String)insert("infcPkgYe160402DAO.fnYeta1100_YE160402_2016_CREATE_Insert_S", infcPkgYeta2000Vo);
    } 
	
	
	@Transactional
    public String fnYeta1100_YE160402_PAYR_2016_CREATE_Insert(InfcPkgYe160402VO infcPkgYe160402Vo) throws Exception {
        return (String)insert("infcPkgYe160402DAO.fnYeta1100_YE160402_PAYR_2016_CREATE_Insert_S", infcPkgYe160402Vo);
    } 
	
  
}
