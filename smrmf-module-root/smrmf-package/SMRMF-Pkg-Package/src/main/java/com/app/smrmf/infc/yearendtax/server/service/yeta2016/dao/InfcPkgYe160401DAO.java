package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : infcPkgYe160401DAO.java
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

@Repository("InfcPkgYe160401DAO")
public class InfcPkgYe160401DAO extends EgovAbstractDAO {
	
	
	
    /**
	 * YETA3210을 등록한다.연말정산 급여내역 생성 
	 * @param vo - 등록할 정보가 담긴 Yeta3210VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//	  @Transactional
//    public String fnPayr06420_PAYR417_2014_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
//        return (String)insert("infcPkgYe160401DAO.fnPayr06420_PAYR417_2014_CREATE_Insert", infcPkgYe160401Vo);
//    } 
	  
	  
	  
	/**
	 * YE160401을 등록한다.연말정산 급여내역 생성
	 * @param vo - 등록할 정보가 담긴 Yeta3210VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//	@Transactional
//	public String fnYeta1100_YE160401_2016_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo)throws Exception {
//		return (String) insert("infcPkgYe160401DAO.fnYeta1100_YE160401_2016_CREATE_Insert_S", infcPkgYe160401Vo);
//	} 
	  
	
	/**
	 * YE160401을 등록한다.연말정산 급여내역 이관
	 * @param vo - 등록할 정보가 담긴 Yeta3210VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
	public String fnYeta1100_YE160401_PAYR_2016_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo)throws Exception {
		return (String) insert("infcPkgYe160401DAO.fnYeta1100_YE160401_PAYR_2016_CREATE_Insert_S", infcPkgYe160401Vo);
	} 	
	
	  

}
