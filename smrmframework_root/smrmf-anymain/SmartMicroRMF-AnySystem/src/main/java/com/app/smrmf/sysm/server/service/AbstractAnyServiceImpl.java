/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.sysm.server.service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.app.smrmf.core.msfmainapp.server.utils.AnyUserInfo;
import com.app.smrmf.core.msfmainapp.server.utils.AnyUserInfoManager;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

public class AbstractAnyServiceImpl extends AbstractServiceImpl { 
 
	private  Log log = LogFactory.getLog(this.getClass()); 


    protected HttpServletRequest  httpServletRequest;
    protected HttpServletResponse httpServletResponse;
    protected ServletContext      servletContext;
    protected ServletConfig       servletConfig;
    protected MSFUserInfoVO       user;

    public AbstractAnyServiceImpl() {
    	
    //	 MSFServerContext.initUserInfo(RemoteServiceUtil.getThreadLocalRequest(), RemoteServiceUtil.getThreadLocalResponse()
  		//          , RemoteServiceUtil.getThreadLocalContext(), RemoteServiceUtil.getThreadLocalConfig());
    	 
        AnyUserInfo userInfo = AnyUserInfoManager.getUserInfo();
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

    public MSFUserInfoVO getUser() {        return user;    }
    public void setUser(MSFUserInfoVO user) {        this.user = user;    }

    public HttpServletRequest getHttpServletRequest() {        return httpServletRequest;    }
    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {        this.httpServletRequest = httpServletRequest;    }

    public HttpServletResponse getHttpServletResponse() {        return httpServletResponse;    }
    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {        this.httpServletResponse = httpServletResponse;    }

    public ServletContext getServletContext() {        return servletContext;    }
    public void setServletContext(ServletContext servletContext) {        this.servletContext = servletContext;    }
    
    public ServletConfig getServletConfig() {        return servletConfig;    }
    public void setServletConfig(ServletConfig servletConfig) {        this.servletConfig = servletConfig;    }

	
}
