package com.smrmf.exterms.mypage.login.service.impl; 


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.vo.system.LoginVO;

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

@Repository("PayGenLoginDAO")
public class PayGenLoginDAO extends EgovAbstractDAO {

	/**
	 * 일반 로그인을 처리한다
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    public LoginVO actionLogin(LoginVO vo) throws Exception {
    	return (LoginVO)selectByPk("payGenLoginDAO.actionLogin", vo);
    }
 
    /**
	 * 아이디를 찾는다.
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    public LoginVO searchId(LoginVO vo) throws Exception {
    	
    	return (LoginVO)selectByPk("payGenLoginDAO.searchId", vo);
    }
    
    /**
	 * 비밀번호를 찾는다.
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    public LoginVO searchPassword(LoginVO vo) throws Exception {
    	
    	return (LoginVO)selectByPk("payGenLoginDAO.searchPassword", vo);
    }
    
    /**
	 * 변경된 비밀번호를 저장한다.
	 * @param vo LoginVO
	 * @exception Exception
	 */
    @Transactional
    public void updatePassword(LoginVO vo) throws Exception {
    	update("payGenLoginDAO.updatePassword", vo);
    }

}
