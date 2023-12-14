package com.app.smrmf.exterms.sso.login.service.impl;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.system.LoginVO;
import com.app.smrmf.sysm.server.vo.system.SsomUserVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserVO;

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

@Repository("SSOLoginDAO")
public class SSOLoginDAO extends EgovAbstractDAO {

	/**
	 * 일반 로그인을 처리한다
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    public SsoxUserVO actionSSOLogin(LoginVO vo) throws Exception {
    	return (SsoxUserVO)selectByPk("ssoLoginDAO.actionSSOLogin", vo);
    }
 
	/**
	 * 올레 일반 로그인을 처리한다
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    public SsomUserVO actionOLSSOLogin(LoginVO vo) throws Exception {
    	return (SsomUserVO)selectByPk("ssoLoginDAO.actionOLSSOLogin", vo);
    }
    
    
    
	/**
	 * 세올,온나라 서비스 
	 * @param vo SSOLoginVO
	 * @return SSOLoginVO
	 * @exception Exception
	 */
    public SsoxUserVO actionSeolSSOLogin(LoginVO vo) throws Exception {
    	return (SsoxUserVO)selectByPk("ssoLoginDAO.actionSeolSSOLogin", vo);
    }
//    /**
//	 * 아이디를 찾는다.
//	 * @param vo LoginVO
//	 * @return LoginVO
//	 * @exception Exception
//	 */
//    public LoginVO searchId(LoginVO vo) throws Exception {
//    	
//    	return (LoginVO)selectByPk("myLoginDAO.searchId", vo);
//    }
//    
//    /**
//	 * 비밀번호를 찾는다.
//	 * @param vo LoginVO
//	 * @return LoginVO
//	 * @exception Exception
//	 */
//    public LoginVO searchPassword(LoginVO vo) throws Exception {
//    	
//    	return (LoginVO)selectByPk("myLoginDAO.searchPassword", vo);
//    }
//    
//    /**
//	 * 변경된 비밀번호를 저장한다.
//	 * @param vo LoginVO
//	 * @exception Exception
//	 */
//    public void updatePassword(LoginVO vo) throws Exception {
//    	update("myLoginDAO.updatePassword", vo);
//    }

}
