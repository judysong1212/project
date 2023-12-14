/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.ext.constants.PropConfs;

public class AnyWebServerUtils {
 
	 private static final Logger logger = LoggerFactory.getLogger(AnyWebServerUtils.class);
	 
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : web jsp 베이스 서버에서 구동시 처리 하는 로직   
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : getLoggedUser
	  * @date : 2017. 10. 2.
	  * @author : atres
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2017. 10. 2.		atres				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param request
	  * @return
	  * @throws MSFUserExpiredException
	  */
	 public static MSFUserInfoVO getLoggedUser(HttpServletRequest request) throws Exception {
		  MSFUserInfoVO user = null;
	        try {
	            HttpSession session = request.getSession();
	            user = (MSFUserInfoVO) session.getAttribute(PropConfs.WEB_SESSION_USER);
	            if ( user != null ) {
	                return user;
	            }
	        } catch (Exception ex) {
	            logger.error("EXCEPTION reading user from session.", ex);
	        }
	        throw new Exception();
	    }

   
}
