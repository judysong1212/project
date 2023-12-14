package com.web.exterms.mypage.login.service;

import java.util.ArrayList;
import java.util.HashMap;

import egovframework.com.cmm.LoginVO;

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

public interface MyLoginService {
	

	/**
	 * 일반 로그인을 처리한다
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    LoginVO actionLogin(LoginVO vo) throws Exception;
     
    
    /**
	 * 아이디를 찾는다.
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    LoginVO searchId(LoginVO vo) throws Exception;
    
    /**
	 * 비밀번호를 찾는다.
	 * @param vo LoginVO
	 * @return boolean
	 * @exception Exception
	 */
    boolean searchPassword(LoginVO vo) throws Exception;
    
    @SuppressWarnings("rawtypes")
	public MyPageSessionVO selectSysm0100(MyPageSessionVO myPageSessionVO) throws Exception;
    
    @SuppressWarnings("rawtypes")
    public MyPageSessionVO getMemberInfo(MyPageSessionVO myPageSessionVO) throws Exception;
    
    public String insertSyms0100ToSysm0130Info(MyPageSessionVO myPageSessionVO) throws Exception;
    
    public void updatePasswordInfo(MyPageSessionVO myPageSessionVO) throws Exception;
    
    @SuppressWarnings("rawtypes")
   	public MyPageSessionVO selectPasswordInfo(MyPageSessionVO myPageSessionVO) throws Exception;

    public void updateSysm0100PasswordInfo(MyPageSessionVO myPageSessionVO)	throws Exception;
    
    public String insertSessionLoginSysm0120(MyPageSessionVO myPageSessionVO) throws Exception;
    
    @SuppressWarnings("rawtypes")
    public MyPageSessionVO selectErrLoginSysm0120(MyPageSessionVO myPageSessionVO) throws Exception;
    
    public void updateErrLoginSysm0120(MyPageSessionVO myPageSessionVO)	throws Exception;
    
    public String insertErrLoginSysm0120(MyPageSessionVO myPageSessionVO) throws Exception;
    
    public void updateSysm0100UseInfo(MyPageSessionVO myPageSessionVO)	throws Exception;
    
    public void deleteErrLoginSysm0120(MyPageSessionVO myPageSessionVO)	throws Exception; 
    
    public void updateSessionChkSysm0120(MyPageSessionVO myPageSessionVO)	throws Exception;
    
}
