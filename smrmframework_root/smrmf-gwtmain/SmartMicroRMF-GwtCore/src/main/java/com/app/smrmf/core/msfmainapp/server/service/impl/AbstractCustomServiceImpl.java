/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.service.impl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFUserInfo;
import com.app.smrmf.core.msfmainapp.server.utils.MSFUserInfoManager;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

public class AbstractCustomServiceImpl extends AbstractServiceImpl { 
 
	private  Log log = LogFactory.getLog(this.getClass()); 


    protected HttpServletRequest  httpServletRequest;
    protected HttpServletResponse httpServletResponse;
    protected ServletContext      servletContext;
    protected ServletConfig       servletConfig;
    protected MSFSysm0100BM       user;

    public AbstractCustomServiceImpl() {
    	
    //	 MSFServerContext.initUserInfo(RemoteServiceUtil.getThreadLocalRequest(), RemoteServiceUtil.getThreadLocalResponse()
  		//          , RemoteServiceUtil.getThreadLocalContext(), RemoteServiceUtil.getThreadLocalConfig());
    	 
        MSFUserInfo userInfo = MSFUserInfoManager.getUserInfo();
        if ( userInfo!=null ) {
            try {
                httpServletRequest  = userInfo.getHttpServletRequest();
                httpServletResponse = userInfo.getHttpServletResponse();
                servletContext      = userInfo.getServletContext();
                servletConfig       = userInfo.getServletConfig();
                user                = userInfo.getUser();
            } catch (Exception ex) {
            }
        }  
    }

    public MSFSysm0100BM getUser() {        return user;    }
    public void setUser(MSFSysm0100BM user) {        this.user = user;    }

    public HttpServletRequest getHttpServletRequest() {        return httpServletRequest;    }
    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {        this.httpServletRequest = httpServletRequest;    }

    public HttpServletResponse getHttpServletResponse() {        return httpServletResponse;    }
    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {        this.httpServletResponse = httpServletResponse;    }

    public ServletContext getServletContext() {        return servletContext;    }
    public void setServletContext(ServletContext servletContext) {        this.servletContext = servletContext;    }
    
    public ServletConfig getServletConfig() {        return servletConfig;    }
    public void setServletConfig(ServletConfig servletConfig) {        this.servletConfig = servletConfig;    }

	
}
