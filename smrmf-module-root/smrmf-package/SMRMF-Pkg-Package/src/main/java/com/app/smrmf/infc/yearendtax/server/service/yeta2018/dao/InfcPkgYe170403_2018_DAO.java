package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160403VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye160403_2018_DAO.java
 * @Description : Ye160403 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe170403_2018_DAO")
public class InfcPkgYe170403_2018_DAO extends EgovAbstractDAO {

	 
	 /**
		 * YE160402을 등록한다.
		 * @param vo - 등록할 정보가 담긴 Yeta3210VO
		 * @return 등록 결과
		 * @exception Exception
		 */
//		@Transactional
//	    public String fnYeta3100_YE160403_2018_CREATE_Insert(InfcPkgYeta3000_2018_VO infcPkgYeta3000Vo) throws Exception {
//	        return (String)insert("infcPkgYe170403_2018_DAO.fnYeta1100_YE160403_2016_CREATE_Insert_S", infcPkgYeta3000Vo);
//	    } 	
//		
		
		@Transactional
	    public String fnYeta3100_YE160403_PAYR_2018_CREATE_Insert(InfcPkgYe160403VO infcPkgYe160403Vo) throws Exception {
	        return (String)insert("infcPkgYe170403_2018_DAO.fnYeta3100_YE160403_PAYR_2018_CREATE_Insert_S", infcPkgYe160403Vo);
	    } 	
	
	 

}
