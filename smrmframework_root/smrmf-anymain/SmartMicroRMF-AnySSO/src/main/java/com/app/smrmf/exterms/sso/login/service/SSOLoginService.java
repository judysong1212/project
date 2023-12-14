package com.app.smrmf.exterms.sso.login.service;

import com.app.smrmf.sysm.server.vo.system.LoginVO;
import com.app.smrmf.sysm.server.vo.system.SsomUserVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserVO;

/**
 * @Class Name : Sysm0100Service.java
 * @Description : Sysm0100 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.26
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

public interface SSOLoginService { 

	

	/**
	 * 올레 일반 로그인을 처리한다
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
	SsomUserVO actionOLSSOLogin(LoginVO vo) throws Exception;
     
	
	/**
	 * 일반 로그인을 처리한다
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
	SsoxUserVO actionSSOLogin(LoginVO vo) throws Exception;
     
	/**
	 * 인사랑,온나라 서비스 
	 * @param vo SSOLoginVO
	 * @return SSOLoginVO
	 * @exception Exception
	 */
	SsoxUserVO actionSeolSSOLogin(LoginVO vo) throws Exception;
	
//    /**
//	 * 아이디를 찾는다.
//	 * @param vo LoginVO
//	 * @return LoginVO
//	 * @exception Exception
//	 */
//    LoginVO searchId(LoginVO vo) throws Exception;
//    
//    /**
//	 * 비밀번호를 찾는다.
//	 * @param vo LoginVO
//	 * @return boolean
//	 * @exception Exception
//	 */
//    boolean searchPassword(LoginVO vo) throws Exception;
}
