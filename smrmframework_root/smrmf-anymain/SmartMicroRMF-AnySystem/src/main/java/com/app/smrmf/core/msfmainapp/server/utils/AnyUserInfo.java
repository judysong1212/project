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

public class AnyUserInfo {

    protected HttpServletRequest  httpServletRequest;
    protected HttpServletResponse httpServletResponse;
    protected ServletContext      servletContext;
    protected ServletConfig       servletConfig;
    protected MSFUserInfoVO            user;

    public AnyUserInfo() {
    }

    public AnyUserInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletContext servletContext, ServletConfig servletConfig, MSFUserInfoVO user) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        this.servletContext = servletContext;
        this.servletConfig = servletConfig;
        this.user = user;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }
    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }
    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }
    public ServletContext getServletContext() {
        return servletContext;
    }
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    public ServletConfig getServletConfig() {
        return servletConfig;
    }
    public void setServletConfig(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

    public MSFUserInfoVO getUser() {
        return user;
    }
    public void setUser(MSFUserInfoVO user) {
        this.user = user;
    }

}
