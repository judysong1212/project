package com.app.smrmf.core.msfmainapp.server.utils;
/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;

public class MSFUserInfoManager {

    /** The logger for this class */
    //private static final Logger logger = LoggerFactory.getLogger(MSFUserInfoManager.class);
   /** Holds a single instance of MSFUserInfo */
    private static final ThreadLocal<MSFUserInfo> threadLocal = new ThreadLocal<MSFUserInfo>();

    public static MSFUserInfo getUserInfo() {
        return threadLocal.get();
    }

    public static void setUserInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletContext servletContext, ServletConfig servletConfig, MSFSysm0100BM user) {
        MSFUserInfo userInfo = getUserInfo();
        if ( userInfo==null ) {
            userInfo = new MSFUserInfo(httpServletRequest, httpServletResponse, servletContext, servletConfig, user);
            threadLocal.set(userInfo);
        }
    }

    public static void setUserInfo(MSFUserInfo userInfo) {
        MSFUserInfo tmpUserInfo = getUserInfo();
        if ( tmpUserInfo==null ) {
            threadLocal.set(userInfo);
        }
    }

}
