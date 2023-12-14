package com.web.exterms.mypage.login.service.impl;

import org.springframework.stereotype.Repository;

import com.web.exterms.mypage.login.service.MyPageSessionVO;

import egovframework.com.cmm.LoginVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0100DAO.java
 * @Description : Sysm0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.26
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("MyLoginDAO")
public class MyLoginDAO extends EgovAbstractDAO {

	/**
	 * 일반 로그인을 처리한다
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    public LoginVO actionLogin(LoginVO vo) throws Exception {
    	return (LoginVO)selectByPk("myLoginDAO.actionLogin", vo);
    }
 
    /**
	 * 아이디를 찾는다.
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    public LoginVO searchId(LoginVO vo) throws Exception {
    	
    	return (LoginVO)selectByPk("myLoginDAO.searchId", vo);
    }
    
    /**
	 * 비밀번호를 찾는다.
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    public LoginVO searchPassword(LoginVO vo) throws Exception {
    	
    	return (LoginVO)selectByPk("myLoginDAO.searchPassword", vo);
    }
    
    /**
	 * 변경된 비밀번호를 저장한다.
	 * @param vo LoginVO
	 * @exception Exception
	 */
    public void updatePassword(LoginVO vo) throws Exception {
    	update("myLoginDAO.updatePassword", vo);
    }

	@SuppressWarnings("rawtypes")
	public MyPageSessionVO selectSysm0100(MyPageSessionVO myPageSessionVO) {
		return (MyPageSessionVO)getSqlMapClientTemplate().queryForObject("myLoginDAO.selectLoginInfo", myPageSessionVO);
	}
	
	@SuppressWarnings("rawtypes")
	public MyPageSessionVO getMemberInfo(MyPageSessionVO myPageSessionVO) {
		return (MyPageSessionVO)getSqlMapClientTemplate().queryForObject("myLoginDAO.getMemberInfo", myPageSessionVO);
	}
	
	public String insertSyms0100ToSysm0130Info(MyPageSessionVO myPageSessionVO){
		return (String) insert("myLoginDAO.insertSyms0100ToSysm0130Info", myPageSessionVO);
	}

	public void updatePassword(MyPageSessionVO myPageSessionVO) {
		update("myLoginDAO.updatePassword", myPageSessionVO);
	}
	
	public void updateSysm0100Password(MyPageSessionVO myPageSessionVO) {
		update("myLoginDAO.updateSysm0100Password", myPageSessionVO);
	}
	
	@SuppressWarnings("rawtypes")
	public MyPageSessionVO selectPasswordInfo(MyPageSessionVO myPageSessionVO) {
		return (MyPageSessionVO)getSqlMapClientTemplate().queryForObject("myLoginDAO.selectPasswordInfo", myPageSessionVO);
	}
	
	public String insertSessionLoginSysm0120(MyPageSessionVO myPageSessionVO){
		return (String) insert("myLoginDAO.insertSessionLoginSysm0120", myPageSessionVO);
	}
	
	@SuppressWarnings("rawtypes")
	public MyPageSessionVO selectErrLoginSysm0120(MyPageSessionVO myPageSessionVO) {
		return (MyPageSessionVO)getSqlMapClientTemplate().queryForObject("myLoginDAO.selectErrLoginSysm0120", myPageSessionVO);
	}

	public void updateErrLoginSysm0120(MyPageSessionVO myPageSessionVO) {
		update("myLoginDAO.updateErrLoginSysm0120", myPageSessionVO);
	}

	public String insertErrLoginSysm0120(MyPageSessionVO myPageSessionVO) {
		return (String) insert("myLoginDAO.insertErrLoginSysm0120", myPageSessionVO);
	}
	
	public void updateSysm0100UseInfo(MyPageSessionVO myPageSessionVO) {
		update("myLoginDAO.updateSysm0100UseInfo", myPageSessionVO);
	}
	
	public void deleteErrLoginSysm0120(MyPageSessionVO myPageSessionVO) {
		delete("myLoginDAO.deleteErrLoginSysm0120", myPageSessionVO);
	}
	
	public void updateSessionChkSysm0120(MyPageSessionVO myPageSessionVO) {
		update("myLoginDAO.updateSessionChkSysm0120", myPageSessionVO);
	}
	
}
