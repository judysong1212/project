package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160403VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye160403_2023_DAO.java
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

@Repository("InfcPkgYe170403_2023_DAO")
public class InfcPkgYe170403_2023_DAO extends EgovAbstractDAO {

	 
	 /**
		 * YE160402을 등록한다.
		 * @param vo - 등록할 정보가 담긴 Yeta4210VO
		 * @return 등록 결과
		 * @exception Exception
		 */
//		@Transactional
//	    public String fnYeta4100_YE160403_2023_CREATE_Insert(InfcPkgYeta4000_2023_VO infcPkgYeta4000Vo) throws Exception {
//	        return (String)insert("infcPkgYe170403_2023_DAO.fnYeta1100_YE160403_2016_CREATE_Insert_S", infcPkgYeta4000Vo);
//	    } 	
//		
		
		@Transactional
	    public String fnYeta8100_YE160403_PAYR_2023_CREATE_Insert(InfcPkgYe160403VO infcPkgYe160403Vo) throws Exception {
	        return (String)insert("infcPkgYe170403_2023_DAO.fnYeta8100_YE160403_PAYR_2023_CREATE_Insert_S", infcPkgYe160403Vo);
	    } 	
	
	 

}
