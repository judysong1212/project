package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO;

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

@Repository("InfcPkgYe170402DAO")
public class InfcPkgYe170402DAO extends EgovAbstractDAO {
	
 
 
	@Transactional
    public String fnYeta2100_YE160402_PAYR_2017_CREATE_Insert(InfcPkgYe160402VO infcPkgYe160402Vo) throws Exception {
        return (String)insert("infcPkgYe170402DAO.fnYeta2100_YE160402_PAYR_2017_CREATE_Insert_S", infcPkgYe160402Vo);
    } 
	
	
	
 

}
