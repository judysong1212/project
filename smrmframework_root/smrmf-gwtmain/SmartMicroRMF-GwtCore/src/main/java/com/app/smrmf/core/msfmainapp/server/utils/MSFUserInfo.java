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

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;

public class MSFUserInfo {

    protected HttpServletRequest  httpServletRequest;
    protected HttpServletResponse httpServletResponse;
    protected ServletContext      servletContext;
    protected ServletConfig       servletConfig;
    protected MSFSysm0100BM            user;

    public MSFUserInfo() {
    }

    public MSFUserInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ServletContext servletContext, ServletConfig servletConfig, MSFSysm0100BM user) {
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

    public MSFSysm0100BM getUser() {
        return user;
    }
    public void setUser(MSFSysm0100BM user) {
        this.user = user;
    }

}
