/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.utils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;

public class AnyUserInfoManager {

    /** The logger for this class */
    //private static final Logger logger = Logger.getLogger(MSFUserInfoManager.class);
   /** Holds a single instance of MSFUserInfo */
    private static final ThreadLocal<AnyUserInfo> threadLocal = new ThreadLocal<AnyUserInfo>();

    public static AnyUserInfo getUserInfo() {
        return threadLocal.get();
    }

    public static void setUserInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletContext servletContext, ServletConfig servletConfig, MSFUserInfoVO user) {
    	AnyUserInfo userInfo = getUserInfo();
        if ( userInfo==null ) {
            userInfo = new AnyUserInfo(httpServletRequest, httpServletResponse, servletContext, servletConfig, user);
            threadLocal.set(userInfo);
        }
    }

    public static void setUserInfo(AnyUserInfo userInfo) {
    	AnyUserInfo tmpUserInfo = getUserInfo();
        if ( tmpUserInfo==null ) {
            threadLocal.set(userInfo);
        }
    }

}
