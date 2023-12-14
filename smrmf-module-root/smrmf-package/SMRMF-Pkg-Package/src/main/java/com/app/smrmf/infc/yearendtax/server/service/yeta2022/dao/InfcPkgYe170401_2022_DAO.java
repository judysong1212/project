package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : infcPkgYe160401_2022_DAO.java
 * @Description : Ye160401 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe170401_2022_DAO")
public class InfcPkgYe170401_2022_DAO extends EgovAbstractDAO {
	
	 
	 
	@Transactional
	public String fnYeta7100_YE160401_PAYR_2022_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo)throws Exception {
		return (String) insert("infcPkgYe170401_2022_DAO.fnYeta7100_YE160401_PAYR_2022_CREATE_Insert_S", infcPkgYe160401Vo);
	} 	
	

  

}
