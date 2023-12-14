/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.filters;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 

/**
 *
 * Checks all requested URIs and dispatches all resources under the /resources path taking them from classpath
 * If resource is present in the filesystem, then that one is served.
 * 
 * In web.xml add the following lines in filter section (before servlets)
 * <filter>
 *   <filter-name>accessControlFilter</filter-name>
 *   <filter-class>com.app.smrmf.core.msfmainapp.server.filters.AccessControlFilter</filter-class>
 * </filter>
 * <filter-mapping>
 *   <filter-name>accessControlFilter</filter-name>
 *   <url-pattern>/*</url-pattern>
 * </filter-mapping>
 *
 */
public class AccessControlFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AccessControlFilter.class);
    //private boolean DEBUG = false;
    private String rootPath;

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("INIT: " + this.getClass().getName());
        ServletContext servletContext = filterConfig.getServletContext();
        rootPath = servletContext.getRealPath("/");
        logger.info("rootPath="+rootPath);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest  httpServletRequest  = (HttpServletRequest)request;
        //HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        //HttpSession         httpSession         = httpServletRequest.getSession(false);

//        String debugParam    = httpServletRequest.getParameter("DEBUG");
//        if (        debugParam!=null && debugParam.equalsIgnoreCase("TRUE") ) {
//            logger.setLevel(Level.DEBUG);
//        } else if ( debugParam!=null && debugParam.equalsIgnoreCase("FALSE") ) {
//            logger.setLevel(Level.INFO);
//        }
         String requestURI    = httpServletRequest.getRequestURI();
         String contextPath   = httpServletRequest.getContextPath();
         String prefix = contextPath + "/resources/";
//        if (logger.isDebugEnabled()) {
//            String requestURL    = httpServletRequest.getRequestURL().toString();
//            String remoteAddress = httpServletRequest.getRemoteAddr();
//            String msg =
//                "["+MSFServerUtils.convertDateToString(new Date())+"]"+
//                "  Request URI: "   + MSFSharedUtils.rpad(requestURI                        ,100,' ')+ 
//                "  requestURL: "    + MSFSharedUtils.rpad(requestURL                        ,100, ' ')+ 
//                "  contextPath: "   + MSFSharedUtils.rpad(contextPath                       , 20, ' ')+ 
//                "  remoteAddress: " + MSFSharedUtils.rpad(remoteAddress                     , 20, ' ')+ 
//                "  Method: "        + MSFSharedUtils.rpad(httpServletRequest.getMethod()    ,  5, ' ')+ 
//                "  Protocol: "      + MSFSharedUtils.rpad(httpServletRequest.getProtocol()  , 15, ' ')+ 
//                "  Server Name: "   + MSFSharedUtils.rpad(httpServletRequest.getServerName(), 30, ' ')+ 
//                "  Port: "          + MSFSharedUtils.rpad(httpServletRequest.getServerPort(),  5, ' ')+ 
//                "";
//            logger.debug(msg);
//        }
        //Check se la risorsa potrebbe stare in un jar
        boolean loadFromFilesystem = true;
        if ( requestURI!=null && requestURI.startsWith(prefix) ) {
            String relativePath = requestURI.substring(contextPath.length()+1);
            String absolutePath = rootPath + relativePath;
            File f = new File(absolutePath);
            if ( f==null || !f.isFile() ) {
                //Sembra che il file non sia sul file system, provo a prenderlo dal jar
                loadFromFilesystem = dispatchResourceFromClasspath(response, relativePath, requestURI);
            }

        }

        //Vai avanti prendendo la risorsa dal file system
        if ( loadFromFilesystem ) {
            chain.doFilter(request, response);
        }

    }

    private boolean dispatchResourceFromClasspath(ServletResponse response, String relativePath, String requestURI) {
        boolean loadFromFilesystem = true;
        InputStream in = null;
        try {
            //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            ClassLoader classLoader = this.getClass().getClassLoader();
            in = classLoader.getResourceAsStream( relativePath );
            logger.debug("in: "+in);
            ServletOutputStream out = response.getOutputStream();
            byte[] buf = new byte[4 * 1024];
            int numRead = 0;
            while ((numRead = in.read(buf)) >= 0) {
                out.write(buf, 0, numRead);
            }
            loadFromFilesystem = false;
            logger.debug("URI from jar: "+requestURI);
        } catch (Exception ex) {
            logger.error("자원 추출중 에러발생 '"+relativePath+"' in='"+in+"' 클래스패스 : "+ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ex) {
                    logger.error("자원에 대한 입력  스트림을 닫은 중 오류 발생 '"+relativePath+"' 클래스패스 : "+ex, ex);
                }
            }
        }
        return loadFromFilesystem;
    }

    public void destroy() {
        logger.info("DESTROY: " + this.getClass().getName());
    }

}
