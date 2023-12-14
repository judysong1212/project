package com.crypto.service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

public class AbstCryptCutmServiceImpl extends AbstractServiceImpl  implements ServletContextAware, ServletConfigAware {
    
	
	    protected HttpServletRequest  httpServletRequest;
	    protected HttpServletResponse httpServletResponse;
	    protected ServletContext      servletContext;
	    protected ServletConfig       servletConfig;
 
	    
	    public AbstCryptCutmServiceImpl() {
	     
	            try {
	            	
	            	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	                
	            	httpServletRequest  = request;
	               // httpServletResponse = userInfo.getHttpServletResponse();
	               // servletContext      = userInfo.getServletContext();
	               // servletConfig       = userInfo.getServletConfig();
	             
	            } catch (Exception ex) {
	            } 
	    } 
	      
	      @Override
	      public void setServletConfig(final ServletConfig servletConfig) {
	          this.servletConfig = servletConfig;

	      }

	      @Override
	      public void setServletContext(final ServletContext servletContext) {
	          this.servletContext = servletContext;

	      }
 
	    public HttpServletRequest getHttpServletRequest() {        return httpServletRequest;    }
	    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {        this.httpServletRequest = httpServletRequest;    }

	    public HttpServletResponse getHttpServletResponse() {        return httpServletResponse;    }
	    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {        this.httpServletResponse = httpServletResponse;    }

	    public ServletContext getServletContext() {        return servletContext;    }
	   
	    public ServletConfig getServletConfig() {        return servletConfig;    }
	    

}
